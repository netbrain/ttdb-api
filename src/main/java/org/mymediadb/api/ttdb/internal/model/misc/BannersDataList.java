package org.mymediadb.api.ttdb.internal.model.misc;

import org.mymediadb.api.ttdb.internal.model.BannerImpl;
import org.mymediadb.api.ttdb.model.Banner;
import org.simpleframework.xml.ElementList;

import java.util.List;

public class BannersDataList implements DataList<Banner> {

    @ElementList(entry = "Banner", inline = true, required = false)
    private List<BannerImpl> banners;

    @Override
    public List<? extends Banner> getData() {
        return this.banners;
    }
}
