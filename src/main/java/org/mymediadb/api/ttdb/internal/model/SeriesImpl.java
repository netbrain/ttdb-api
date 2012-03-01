package org.mymediadb.api.ttdb.internal.model;

import org.mymediadb.api.ttdb.model.Series;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

@Root(strict = false, name = "Series")
public class SeriesImpl implements Series {

    @Element
    private long id;

    @Element(name = "Actors", required = false)
    private String actors;

    @Element(name = "Airs_DayOfWeek", required = false)
    private String airsDayOfWeek;

    @Element(name = "Airs_Time", required = false)
    private String airsTime;

    @Element(name = "FirstAired", required = false)
    private Date firstAired;

    @Element(name = "Genre", required = false)
    private String genre;

    @Element(name = "IMDB_ID", required = false)
    private String imdbId;

    @Element(name = "Language", required = false)
    private String language;

    @Element(name = "Network", required = false)
    private String network;

    @Element(name = "Overview", required = false)
    private String overview;

    @Element(name = "Rating", required = false)
    private double rating;

    @Element(name = "RatingCount", required = false)
    private int ratingCount;

    @Element(name = "Runtime", required = false)
    private String runtime;

    @Element(name = "SeriesID", required = false)
    private long seriesID;

    @Element(name = "SeriesName", required = false)
    private String seriesName;

    @Element(name = "Status", required = false)
    private String status;

    @Element(name = "lastupdated", required = false)
    private long lastUpdated;


    @Override
    public String[] getActors() {
        return MiscModelUtils.splitByPipe(this.actors);
    }

    @Override
    public String[] getGenre() {
        return MiscModelUtils.splitByPipe(this.genre);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getAirsDayOfWeek() {
        return airsDayOfWeek;
    }

    @Override
    public String getAirsTime() {
        return airsTime;
    }

    @Override
    public Date getFirstAired() {
        return this.firstAired;
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
    public String getNetwork() {
        return network;
    }

    @Override
    public String getOverview() {
        return overview;
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
    public String getRuntime() {
        return runtime;
    }

    @Override
    public long getSeriesID() {
        return seriesID;
    }

    @Override
    public String getSeriesName() {
        return seriesName;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public long getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "SeriesImpl{" +
                "actors='" + actors + '\'' +
                ", id=" + id +
                ", airsDayOfWeek='" + airsDayOfWeek + '\'' +
                ", airsTime='" + airsTime + '\'' +
                ", firstAired='" + firstAired + '\'' +
                ", genre='" + genre + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", language='" + language + '\'' +
                ", network='" + network + '\'' +
                ", overview='" + overview + '\'' +
                ", rating=" + rating +
                ", ratingCount=" + ratingCount +
                ", runtime='" + runtime + '\'' +
                ", seriesID=" + seriesID +
                ", seriesName='" + seriesName + '\'' +
                ", status='" + status + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
