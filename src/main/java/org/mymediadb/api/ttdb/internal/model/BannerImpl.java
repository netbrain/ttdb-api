package org.mymediadb.api.ttdb.internal.model;

import org.mymediadb.api.ttdb.model.Banner;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "Banner")
public class BannerImpl implements Banner {

    @Element(name = "id", required = true)
    private int id;

    @Element(name = "BannerPath", required = false)
    private String bannerPath;

    @Element(name = "BannerType", required = false)
    private String bannerType;

    @Element(name = "BannerType2", required = false)
    private String bannerType2;

    @Element(name = "Language", required = false)
    private String language;

    @Element(name = "Colors", required = false)
    private String colors;

    @Element(name = "Rating", required = false)
    private String rating;

    @Element(name = "RatingCount", required = false)
    private String ratingCount;

    @Element(name = "SeriesName", required = false)
    private String seriesName;

    @Element(name = "ThumbnailPath", required = false)
    private String thumbnailPath;

    @Element(name = "ViginettePath", required = false)
    private String viginettePath;


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getBannerPath() {
        return this.bannerPath;
    }

    @Override
    public String getBannerType() {
        return this.bannerType;
    }

    @Override
    public String getBannerType2() {
        return this.bannerType2;
    }

    @Override
    public String getLanguage() {
        return this.language;
    }

    @Override
    public String[] getColors() {
        return MiscModelUtils.splitByPipe(this.colors);
    }

    @Override
    public Float getRating() {
        return Float.parseFloat(this.rating);
    }

    @Override
    public Integer getRatingCount() {
        return Integer.parseInt(this.ratingCount);
    }

    @Override
    public Boolean getSeriesName() {
        return Boolean.parseBoolean(this.seriesName);
    }

    @Override
    public String getThumbnailPath() {
        return this.thumbnailPath;
    }

    @Override
    public String getViginettePath() {
        return this.viginettePath;
    }
}
