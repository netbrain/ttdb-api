package org.mymediadb.api.ttdb.internal.model;

import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class SeriesImplTest {

    private SeriesImpl series;

    @Before
    public void init() throws Exception {
        Serializer serializer = new Persister();
        String filePath = ClassLoader.getSystemResource("baseSeries.xml").getFile();
        File source = new File(filePath);

        series = serializer.read(SeriesImpl.class, source);
    }

    @Test
    public void testGetValidEpisodeId() {
        assertEquals(80348L, series.getId());
    }

    @Test
    public void testGetImdbId() {
        assertEquals("tt0934814", series.getImdbId());
    }

}
