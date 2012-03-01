package org.mymediadb.api.ttdb.internal.model;

import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;


public class EpisodeImplTest {
    private EpisodeImpl episode;

    @Before
    public void init() throws Exception {
        Serializer serializer = new Persister();
        String filePath = ClassLoader.getSystemResource("baseEpisode.xml").getFile();
        File source = new File(filePath);

        episode = serializer.read(EpisodeImpl.class, source);
    }

    @Test
    public void testShouldBeAbleToGetValidEpisodeId() {
        assertEquals(332179L, episode.getId());
    }

    @Test
    public void testGetValidDirectors() {
        List<String> listOfDirectors = Arrays.asList("Joseph McGinty Nichol", "Vik Sahay", "Mieko Hillman");
        for (String director : episode.getDirectors())
            assertTrue(listOfDirectors.contains(director));
    }

    @Test
    public void testEpisodeName() {
        assertEquals("Chuck Versus the World", episode.getEpisodeName());
    }

    @Test
    public void testGetFirstAiredDate() {

        assertNotNull(episode.getFirstAired());
        assertEquals(episode.getFirstAired().toString(), "Mon Sep 24 00:00:00 CEST 2007");
    }

    @Test
    public void testGetRating() {
        assertEquals(9.0, episode.getRating());
    }

}
