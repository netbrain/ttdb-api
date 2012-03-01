package org.mymediadb.api.ttdb.internal.model.misc;

import org.junit.Before;
import org.junit.Test;
import org.mymediadb.api.ttdb.model.Banner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


public class BannersDataListTest {
    private BannersDataList banners;

    @Before
    public void init() throws Exception {
        Serializer serializer = new Persister();
        String filePath = ClassLoader.getSystemResource("banners.xml").getFile();
        File source = new File(filePath);

        banners = serializer.read(BannersDataList.class, source);
    }

    @Test
    public void testShouldBeAbleToGetValidLanguageList() {
        assertNotNull(banners.getData());
    }

    @Test
    public void testLanguageListShouldContainElements() {
        assertNotNull(banners.getData().size() > 0);
    }

    @Test
    public void testLanguageFromLanguageListShouldContainValues() {
        Banner banner = banners.getData().get(0);
        assertEquals(banner.getId(), 14820);
        assertEquals(banner.getBannerPath(), "text/80348.jpg");
        assertEquals(banner.getBannerType(), "series");
        assertEquals(banner.getBannerType2(), "text");
        assertEquals(banner.getLanguage(), "en");
    }


}
