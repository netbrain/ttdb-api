package org.mymediadb.api.ttdb.api;

import org.mymediadb.api.ttdb.model.*;

import java.util.Date;
import java.util.List;

public interface TtdbApi {

   /**
     * Sets the tv database mirror to use.
     * @param mirror
     */
    void setMirror(String mirror);

   /**
     * Returns the currently set tv database mirror
     * @return http mirror, ex: http://thetvdb.org
     */
    String getMirror();

   /**
     * Set the language to use when retrieving series information.
     * @param language
     */
    void setLanguage(String language);

   /**
     * Returns the currently set language used to retrieve series information.
     * @return  language code. ex. en
     */
    String getLanguage();

   /**
     * Set the api key
     * @param apiKey
     */
    void setApiKey(String apiKey);

   /**
     * @return the currently set apiKey
     */
    String getApiKey();

   /**
     * @return a list of available thetvdb.com mirrors
     */
    List<? extends Mirror> getMirrors();

   /**
     * @return  a list of available languages
     */
    List<? extends Language> getLanguages();

   /**
     *
     * @param series
     * @return  a list of series matching search query
     */
    List<? extends Series> searchSeries(String series);

   /**
     *  Retrieves series information and a list of all episodes belonging to this series.
     * @param seriesId
     * @return series and episode information
     */
    FullSeries getFullSeries(long seriesId);

   /**
     * Retrieves information on a given series
     * @param seriesId
     * @return  series information
     */
    Series getSeries(long seriesId);

    /**
     * Retrieves information on a given episode
     * @param episodeId
     * @return episode information
     */
    Episode getEpisode(long episodeId);

   /**
     * Retrieves information on a given episode
     * @param seriesId
     * @param season
     * @param episode
     * @return episode information
     */
    Episode getEpisode(int seriesId, int season, int episode);

   /**
     * Retrieves banner information on a given series
     * @param seriesId
     * @return a list of banners
     */
    List<? extends Banner> getBanners(long seriesId);

   /**
     * Retrieves updated series and episodes from a given date.
     * @param fromDate
     * @return update information
     */
    Updates getUpdates(Date fromDate);
}
