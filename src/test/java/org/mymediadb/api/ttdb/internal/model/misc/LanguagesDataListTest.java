package org.mymediadb.api.ttdb.internal.model.misc;

import org.junit.Before;
import org.junit.Test;
import org.mymediadb.api.ttdb.model.Language;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


public class LanguagesDataListTest {
    private LanguagesDataList languages;

    @Before
    public void init() throws Exception {
        Serializer serializer = new Persister();
        String filePath = ClassLoader.getSystemResource("languages.xml").getFile();
        File source = new File(filePath);

        languages = serializer.read(LanguagesDataList.class, source);
    }

    @Test
    public void testShouldBeAbleToGetValidLanguageList() {
        assertNotNull(languages.getData());
    }

    @Test
    public void testLanguageListShouldContainElements() {
        assertNotNull(languages.getData().size() > 0);
    }

    @Test
    public void testLanguageFromLanguageListShouldContainValues() {
        Language lang = languages.getData().get(0);
        assertEquals(lang.getId(), 7);
        assertEquals(lang.getName(), "English");
        assertEquals(lang.getAbbreviation(), "en");
    }


}
