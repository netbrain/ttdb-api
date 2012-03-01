package org.mymediadb.api.ttdb.model;

import java.util.Date;
import java.util.List;

public interface Updates {

    Date getTime();

    List<Integer> getSeriesIds();

    List<Integer> getEpisodesIds();

}
