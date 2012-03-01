package org.mymediadb.api.ttdb.internal.api;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.ContentEncodingHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.log4j.Logger;
import org.mymediadb.api.ttdb.api.TtdbApi;
import org.mymediadb.api.ttdb.internal.model.FullSeriesImpl;
import org.mymediadb.api.ttdb.internal.model.UpdatesImpl;
import org.mymediadb.api.ttdb.internal.model.misc.*;
import org.mymediadb.api.ttdb.model.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public final class TtdbApiImpl implements TtdbApi {

    private static Logger log = Logger.getLogger(TtdbApiImpl.class);
    private static TtdbApiImpl instance = null;
    private static HttpClient httpClient;

    private String mirror;
    private String apiKey;
    private String language;

    private static final int HTTP_CONNECTION_TIMEOUT = 240000;
    private static final int HTTP_MAX_CONNECTIONS = 100;
    private static final int HTTP_MAX_CONNECTIONS_PER_ROUTE = 16;

    static {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(params, HTTP_CONNECTION_TIMEOUT);

        ThreadSafeClientConnManager connectionManager = new ThreadSafeClientConnManager();
        connectionManager.setMaxTotal(HTTP_MAX_CONNECTIONS);
        connectionManager.setDefaultMaxPerRoute(HTTP_MAX_CONNECTIONS_PER_ROUTE);

        httpClient = new ContentEncodingHttpClient(connectionManager, params);
    }

    private TtdbApiImpl() {
        this.mirror = "http://thetvdb.com";
        this.language = "en";
        this.apiKey = System.getProperty("ttdb.api.key");
    }

    public static TtdbApiImpl getInstance() {
        if (instance == null){
            instance = new TtdbApiImpl();
        }
        return instance;
    }

    @Override
    public void setMirror(String mirror) {
        this.mirror = mirror;
    }

    @Override
    public String getMirror() {
        return this.mirror;
    }

    @Override
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String getLanguage() {
        return this.language;
    }

    @Override
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String getApiKey() {
        return this.apiKey;
    }

    @Override
    public List<? extends Mirror> getMirrors() {
        String url = getBaseUrl() + getAndValidateApiKey() + "/mirrors.xml";
        MirrorsDataList result = sendGetRequestAndDeserialize(MirrorsDataList.class, url);
        return result.getData();
    }

    @Override
    public List<? extends Language> getLanguages() {
        String url = getBaseUrl() + getAndValidateApiKey() + "/languages.xml";
        LanguagesDataList result = sendGetRequestAndDeserialize(LanguagesDataList.class, url);
        return result.getData();
    }

    @Override
    public List<? extends Series> searchSeries(String series) {
        //search for series
        if (series == null){
            return null;
        }

        try {
            series = URLEncoder.encode(series.trim(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }

        if (series.length() == 0){
            return null;
        }

        String url = getBaseUrl() + "GetSeries.php?seriesname=" + series + "&language=" + this.language;
        SeriesDataList result = sendGetRequestAndDeserialize(SeriesDataList.class, url);
        return result.getData();

    }

    @Override
    public FullSeries getFullSeries(long seriesId) {
        String url = getBaseUrl() + getAndValidateApiKey() + "/series/" + seriesId + "/all/" + this.language + ".xml";
        return sendGetRequestAndDeserialize(FullSeriesImpl.class, url);
    }

    @Override
    public Series getSeries(long seriesId) {
        String url = getBaseUrl() + getAndValidateApiKey() + "/series/" + seriesId + "/" + this.language + ".xml";
        SeriesDataList dataList = sendGetRequestAndDeserialize(SeriesDataList.class, url);
        return getFirstElementInDataList(dataList);
    }

    @Override
    public Episode getEpisode(long episodeId) {
        String url = getBaseUrl() + getAndValidateApiKey() + "/episodes/" + episodeId + "/" + this.language + ".xml";
        EpisodesDataList dataList = sendGetRequestAndDeserialize(EpisodesDataList.class, url);
        return getFirstElementInDataList(dataList);
    }

    @Override
    public Episode getEpisode(int seriesId, int season, int episode) {
        String url = getBaseUrl() + getAndValidateApiKey() + "/series/" + seriesId + "/default/" + season + "/" + episode + "/" + this.language + ".xml";
        EpisodesDataList dataList = sendGetRequestAndDeserialize(EpisodesDataList.class, url);
        return getFirstElementInDataList(dataList);
    }

    @Override
    public List<? extends Banner> getBanners(long seriesId) {
        //fetch series banners
        String url = getBaseUrl() + getAndValidateApiKey() + "/series/" + seriesId + "/banners.xml";
        BannersDataList dataList = sendGetRequestAndDeserialize(BannersDataList.class, url);
        if(dataList != null){
            return dataList.getData();
        }else{
            return null;
        }
    }

    @Override
    public Updates getUpdates(Date fromDate) {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c.setTime(fromDate);
        long epoch = c.getTimeInMillis() / 1000;

        String url = this.mirror + "/api/Updates.php?type=all&time=" + epoch;
        return sendGetRequestAndDeserialize(UpdatesImpl.class, url);
    }


    private <T> T getFirstElementInDataList(DataList<T> dataList) {
        if (dataList != null) {
            List data = dataList.getData();
            if (data.size() == 1) {
                return (T) data.get(0);
            } else {
                throw new RuntimeException("unexpected list size when fetching data object, expected 1 but got " + data.size());
            }
        }
        return null;
    }

    private <T> T sendGetRequestAndDeserialize(Class<T> classObj, String url) {
        InputStream stream = null;
        try {
            HttpGet getRequest = new HttpGet(url);
            HttpResponse response = httpClient.execute(getRequest);
            stream = response.getEntity().getContent();

            StatusLine responseStatus = response.getStatusLine();
            if (responseStatus.getStatusCode() == 404) {
                log.info("recieved 404 response, returning null");
                return null;
            }

            //TODO remove when bug is fixed
            //The tv database has a 404 bug: http://forums.thetvdb.com/viewtopic.php?f=4&t=6100
            Header[] headers = response.getHeaders("Status");
            if (headers.length == 1 && headers[0].getValue().equals("404"))
                return null;

            return deserialize(classObj, stream);

        } catch (Exception e) {
            throw new RuntimeException("unexpected error", e);
        } finally {
            if (stream != null)
                try {
                    stream.close();
                } catch (IOException e) {
                    log.error("unexpected error when closing stream",e);
                }
        }
    }

    private <T> T deserialize(Class<T> classObj, InputStream stream) throws Exception {
        Serializer serializer = new Persister();
        return serializer.read(classObj, stream);
    }

    private String getBaseUrl() {
        return this.mirror + "/api/";
    }

    private String getAndValidateApiKey() {
        if (this.apiKey == null)
            throw new RuntimeException("apiKey is not set");
        else
            return this.apiKey;
    }

}
