package org.mymediadb.api.ttdb.internal.model.misc;

import org.mymediadb.api.ttdb.internal.model.SeriesImpl;
import org.mymediadb.api.ttdb.model.Series;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class SeriesDataList implements DataList<Series> {

    @ElementList(entry = "Series", inline = true)
    private List<SeriesImpl> series;

    @Override
    public List<? extends Series> getData() {
        return this.series;
    }
}
