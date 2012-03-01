package org.mymediadb.api.ttdb.internal.model;

import org.mymediadb.api.ttdb.model.Language;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "Language")
public class LanguageImpl implements Language {

    @Element(name = "id", required = false)
    private int id;

    @Element(name = "name", required = false)
    private String name;

    @Element(name = "abbreviation", required = false)
    private String abbreviation;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getAbbreviation() {
        return this.abbreviation;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "LanguageImpl{" +
                "abbreviation='" + abbreviation + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
