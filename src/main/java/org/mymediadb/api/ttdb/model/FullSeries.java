package org.mymediadb.api.ttdb.model;

import java.util.List;

public interface FullSeries {
    public Series getSeries();

    public List<? extends Episode> getEpisodes();
}
