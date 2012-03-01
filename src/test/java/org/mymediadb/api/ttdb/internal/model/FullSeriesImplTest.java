package org.mymediadb.api.ttdb.internal.model;

import org.junit.Before;
import org.junit.Test;
import org.mymediadb.api.ttdb.model.Episode;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


public class FullSeriesImplTest {
    private FullSeriesImpl data;

    @Before
    public void init() throws Exception {
        Serializer serializer = new Persister();
        String filePath = ClassLoader.getSystemResource("fullSeries.xml").getFile();
        File source = new File(filePath);

        data = serializer.read(FullSeriesImpl.class, source);
    }

    @Test
    public void testShouldBeAbleToGetValidSeriesObject() {
        assertNotNull(data.getSeries());
    }

    @Test
    public void testShouldBeAbleToGetValidCollectionOfEpisodes() {
        List<? extends Episode> episodes = data.getEpisodes();
        assertNotNull(episodes);
        assertTrue(episodes.size() > 0);
        assertTrue(episodes.size() == 75);
    }


}
