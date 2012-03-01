package org.mymediadb.api.ttdb.internal.model;

import org.mymediadb.api.ttdb.model.Episode;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

@Root(strict = false, name = "Episode")
public class EpisodeImpl implements Episode {

    @Element
    private long id;

    @Element(name = "DVD_chapter", required = false)
    private String dvdChapter;

    @Element(name = "DVD_discid", required = false)
    private String dvdDiscId;

    @Element(name = "DVD_episodenumber", required = false)
    private String dvdEpisodeNumber;

    @Element(name = "DVD_season", required = false)
    private String dvdSeason;

    @Element(name = "Director", required = false)
    private String director;

    @Element(name = "EpisodeName", required = false)
    private String episodeName;

    @Element(name = "EpisodeNumber", required = false)
    private int episodeNumber;

    @Element(name = "FirstAired", required = false)
    private Date firstAired;

    @Element(name = "GuestStars", required = false)
    private String guestStars;

    @Element(name = "IMDB_ID", required = false)
    private String imdbId;

    @Element(name = "Language", required = false)
    private String language;

    @Element(name = "Overview", required = false)
    private String overview;

    @Element(name = "ProductionCode", required = false)
    private String productionCode;

    @Element(name = "Rating", required = false)
    private double rating;

    @Element(name = "RatingCount", required = false)
    private int ratingCount;

    @Element(name = "SeasonNumber", required = false)
    private int seasonNumber;

    @Element(name = "Writer", required = false)
    private String writer;

    @Element(name = "absolute_number", required = false)
    private int absoluteNumber;

    @Element(name = "airsafter_number", required = false)
    private int airsAfterNumber;

    @Element(name = "airsbefore_episode", required = false)
    private int airsBeforeEpisode;

    @Element(name = "airsbefore_season", required = false)
    private int airsBeforeSeason;

    @Element(name = "filename", required = false)
    private String episodePicture;

    @Element(name = "lastupdated", required = false)
    private long lastUpdated;

    @Element(name = "seasonid", required = false)
    private int seasonId;

    @Element(name = "seriesid", required = false)
    private int seriesId;

    @Override
    public long getLastUpdated() {
        return this.lastUpdated;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getDvdChapter() {
        return dvdChapter;
    }

    @Override
    public String getDvdDiscId() {
        return dvdDiscId;
    }

    @Override
    public String getDvdEpisodeNumber() {
        return dvdEpisodeNumber;
    }

    @Override
    public String getDvdSeason() {
        return dvdSeason;
    }

    @Override
    public String getEpisodeName() {
        return episodeName;
    }

    @Override
    public int getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public Date getFirstAired() {
        return firstAired;
    }

    @Override
    public String getImdbId() {
        return imdbId;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String getOverview() {
        return overview;
    }

    @Override
    public String getProductionCode() {
        return productionCode;
    }

    @Override
    public double getRating() {
        return rating;
    }

    @Override
    public int getRatingCount() {
        return this.ratingCount;
    }

    @Override
    public int getSeasonNumber() {
        return seasonNumber;
    }

    @Override
    public int getAbsoluteNumber() {
        return absoluteNumber;
    }

    @Override
    public int getAirsAfterNumber() {
        return airsAfterNumber;
    }

    @Override
    public int getAirsBeforeEpisode() {
        return airsBeforeEpisode;
    }

    @Override
    public int getAirsBeforeSeason() {
        return airsBeforeSeason;
    }

    @Override
    public String getEpisodePicture() {
        return episodePicture;
    }

    @Override
    public int getSeasonId() {
        return seasonId;
    }

    @Override
    public int getSeriesId() {
        return seriesId;
    }

    @Override
    public String[] getWriter() {
        return MiscModelUtils.splitByPipe(this.writer);
    }

    @Override
    public String[] getGuestStars() {
        return MiscModelUtils.splitByPipe(this.guestStars);
    }

    @Override
    public String[] getDirectors() {
        return MiscModelUtils.splitByPipe(this.director);
    }

    @Override
    public String toString() {
        return "EpisodeImpl{" +
                "absoluteNumber=" + absoluteNumber +
                ", id=" + id +
                ", dvdChapter='" + dvdChapter + '\'' +
                ", dvdDiscId='" + dvdDiscId + '\'' +
                ", dvdEpisodeNumber='" + dvdEpisodeNumber + '\'' +
                ", dvdSeason='" + dvdSeason + '\'' +
                ", director='" + director + '\'' +
                ", episodeName='" + episodeName + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", firstAired=" + firstAired +
                ", guestStars='" + guestStars + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", language='" + language + '\'' +
                ", overview='" + overview + '\'' +
                ", productionCode='" + productionCode + '\'' +
                ", rating=" + rating +
                ", ratingCount=" + ratingCount +
                ", seasonNumber=" + seasonNumber +
                ", writer='" + writer + '\'' +
                ", airsAfterNumber=" + airsAfterNumber +
                ", airsBeforeEpisode=" + airsBeforeEpisode +
                ", airsBeforeSeason=" + airsBeforeSeason +
                ", episodePicture='" + episodePicture + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", seasonId=" + seasonId +
                ", seriesId=" + seriesId +
                '}';
    }
}
