package org.mymediadb.api.ttdb.model;

import java.util.Date;

public interface Episode {

    public long getLastUpdated();

    public long getId();

    public String getDvdChapter();

    public String getDvdDiscId();

    public String getDvdEpisodeNumber();

    public String getDvdSeason();

    public String getEpisodeName();

    public int getEpisodeNumber();

    public Date getFirstAired();

    public String getImdbId();

    public String getLanguage();

    public String getOverview();

    public String getProductionCode();

    public double getRating();

    public int getRatingCount();

    public int getSeasonNumber();

    public int getAbsoluteNumber();

    public int getAirsAfterNumber();

    public int getAirsBeforeEpisode();

    public int getAirsBeforeSeason();

    public String getEpisodePicture();

    public int getSeasonId();

    public int getSeriesId();

    public String[] getWriter();

    public String[] getGuestStars();

    public String[] getDirectors();
}
