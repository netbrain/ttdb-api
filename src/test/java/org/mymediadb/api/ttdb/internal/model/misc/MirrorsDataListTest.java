package org.mymediadb.api.ttdb.internal.model.misc;

import org.junit.Before;
import org.junit.Test;
import org.mymediadb.api.ttdb.model.Mirror;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


public class MirrorsDataListTest {
    private MirrorsDataList mirrors;

    @Before
    public void init() throws Exception {
        Serializer serializer = new Persister();
        String filePath = ClassLoader.getSystemResource("mirrors.xml").getFile();
        File source = new File(filePath);

        mirrors = serializer.read(MirrorsDataList.class, source);
    }

    @Test
    public void testShouldBeAbleToGetValidMirrorsList() {
        assertNotNull(mirrors.getData());
    }

    @Test
    public void testMirrorsListShouldContainElements() {
        assertNotNull(mirrors.getData().size() > 0);
    }

    @Test
    public void testMirrorFromMirrorListShouldContainValues() {
        Mirror mirror = mirrors.getData().get(0);
        assertEquals(mirror.getId(), 1);
        assertEquals(mirror.getMirrorPath(), "http://thetvdb.com");
        assertEquals(mirror.getTypeMask(), 7);
    }


}
