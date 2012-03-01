package org.mymediadb.api.ttdb.internal.api;


import org.junit.Before;
import org.junit.Test;
import org.mymediadb.api.ttdb.api.TtdbApi;
import org.mymediadb.api.ttdb.model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static junit.framework.Assert.*;

public class TtdbApiImplTest {

    private TtdbApi ttdbApi;


    @Before
    public void setup() {
        ttdbApi = TtdbApiImpl.getInstance();
    }

    @Test
    public void testSearchSeries() {
        List<? extends Series> series = ttdbApi.searchSeries("Stargate");
        assertNotNull(series);
        assertTrue(series.size() > 0);
    }

    @Test
    public void testSearchSeriesWhereQueryIsNull() {
        List<? extends Series> series = ttdbApi.searchSeries(null);
        assertNull(series);
    }

    @Test
    public void testSearchSeriesWhereQueryIsEmptyString() {
        List<? extends Series> series = ttdbApi.searchSeries("");
        assertNull(series);
    }

    @Test
    public void testSearchSeriesWhereQueryIsSpacedEmptyString() {
        List<? extends Series> series = ttdbApi.searchSeries("   ");
        assertNull(series);
    }

    @Test
    public void testGetLanguages() {
        List<? extends Language> languages = ttdbApi.getLanguages();
        assertNotNull(languages);
        assertTrue(languages.size() > 0);
    }

    @Test
    public void testGetMirrors() {
        List<? extends Mirror> mirrors = ttdbApi.getMirrors();
        assertNotNull(mirrors);
        assertTrue(mirrors.size() > 0);
    }

    @Test
    public void testGetFullSeries() {
        FullSeries series = ttdbApi.getFullSeries(74205);
        assertNotNull(series);
        assertNotNull(series.getSeries());
        assertNotNull(series.getEpisodes());
        assertTrue(series.getEpisodes().size() > 0);
    }

    @Test
    public void testGetFullSeriesWithNonExistingSeriesId() {
        FullSeries series = ttdbApi.getFullSeries(0);
        assertNull(series);
    }

    @Test
    public void testGetEpisode() {
        Episode episode = ttdbApi.getEpisode(312666);
        assertNotNull(episode);
    }

    @Test
    public void testGetEpisodeWithNonExistingEpisodeId() {
        Episode episode = ttdbApi.getEpisode(0);
        assertNull(episode);
    }

    @Test
    public void testGetEpisodeWithSeasonAndEpisodeId() {
        Episode episode = ttdbApi.getEpisode(74205, 1, 1);
        assertNotNull(episode);
    }

    @Test
    public void testGetEpisodeWithInvalidSeasonAndEpisodeId() {
        Episode episode = ttdbApi.getEpisode(74205, 99, 99);
        assertNull(episode);
    }

    @Test
    public void testGetSeries() {
        Series series = ttdbApi.getSeries(74205);
        assertNotNull(series);
    }

    @Test
    public void testGetSeriesWithNonExistingId() {
        Series series = ttdbApi.getSeries(0);
        assertNull(series);
    }

    @Test
    public void testGetBanners() {
        List<? extends Banner> banners = ttdbApi.getBanners(74205);
        assertNotNull(banners);
        assertTrue(banners.size() > 0);
    }

    @Test
    public void testGetBannersWhereSeriesIdNotExists() {
        List<? extends Banner> banners = ttdbApi.getBanners(0);
        assertNull(banners);
    }

    @Test
    public void testGetUpdates() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        c.setTimeInMillis(System.currentTimeMillis() - 86400 * 1000);
        Date fromDate = c.getTime();

        Updates updates = ttdbApi.getUpdates(fromDate);
        assertNotNull(updates);
        assertNotNull(updates.getTime());
        assertNotNull(updates.getSeriesIds());
        assertTrue(updates.getSeriesIds().size() > 0);
        assertNotNull(updates.getEpisodesIds());
        assertTrue(updates.getEpisodesIds().size() > 0);
    }
}
