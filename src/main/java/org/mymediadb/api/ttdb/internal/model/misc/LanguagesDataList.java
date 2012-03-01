package org.mymediadb.api.ttdb.internal.model.misc;

import org.mymediadb.api.ttdb.internal.model.LanguageImpl;
import org.mymediadb.api.ttdb.model.Language;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class LanguagesDataList implements DataList<Language> {

    @ElementList(entry = "Language", inline = true)
    private List<LanguageImpl> languages;

    @Override
    public List<? extends Language> getData() {
        return this.languages;
    }
}
