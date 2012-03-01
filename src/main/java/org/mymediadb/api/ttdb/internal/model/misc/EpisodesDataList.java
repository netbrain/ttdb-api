package org.mymediadb.api.ttdb.internal.model.misc;

import org.mymediadb.api.ttdb.internal.model.EpisodeImpl;
import org.mymediadb.api.ttdb.model.Episode;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class EpisodesDataList implements DataList<Episode> {

    @ElementList(entry = "Episode", inline = true)
    private List<EpisodeImpl> episodes;

    @Override
    public List<? extends Episode> getData() {
        return this.episodes;
    }
}
