package org.mymediadb.api.ttdb.model;

public interface Banner {
    public int getId();

    public String getBannerPath();

    public String getBannerType();

    public String getBannerType2();

    public String getLanguage();

    public String[] getColors();

    public Float getRating();

    public Integer getRatingCount();

    public Boolean getSeriesName();

    public String getThumbnailPath();

    public String getViginettePath();
}
