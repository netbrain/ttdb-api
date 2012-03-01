package org.mymediadb.api.ttdb.internal.model;

import org.mymediadb.api.ttdb.model.Episode;
import org.mymediadb.api.ttdb.model.FullSeries;
import org.mymediadb.api.ttdb.model.Series;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false, name = "Data")
public class FullSeriesImpl implements FullSeries {

    @Element(name = "Series")
    private SeriesImpl series;

    @ElementList(entry = "Episode", inline = true, required = false)
    private List<EpisodeImpl> episodes;

    @Override
    public Series getSeries() {
        return this.series;
    }

    @Override
    public List<? extends Episode> getEpisodes() {
        return this.episodes;
    }

    @Override
    public String toString() {
        return "FullSeriesImpl{" +
                "episodes=" + episodes +
                ", series=" + series +
                '}';
    }
}
