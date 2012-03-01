package org.mymediadb.api.ttdb.internal.model;

import org.mymediadb.api.ttdb.model.Updates;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Date;
import java.util.List;

@Root(strict = false, name = "Items")
public class UpdatesImpl implements Updates {

    @Element(name = "Time", required = true)
    private long time;

    @ElementList(entry = "Series", inline = true, required = false)
    private List<Integer> series;

    @ElementList(entry = "Episode", inline = true, required = false)
    private List<Integer> episodes;

    @Override
    public Date getTime() {
        return new Date(this.time * 1000);
    }

    @Override
    public List<Integer> getSeriesIds() {
        return this.series;
    }

    @Override
    public List<Integer> getEpisodesIds() {
        return this.episodes;
    }
}
