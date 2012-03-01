package org.mymediadb.api.ttdb.model;

import java.util.Date;

public interface Series {
    public String[] getActors();

    public String[] getGenre();

    public long getId();

    public String getAirsDayOfWeek();

    public String getAirsTime();

    public Date getFirstAired();

    public String getImdbId();

    public String getLanguage();

    public String getNetwork();

    public String getOverview();

    public double getRating();

    public int getRatingCount();

    public String getRuntime();

    public long getSeriesID();

    public String getSeriesName();

    public String getStatus();

    public long getLastUpdated();
}
