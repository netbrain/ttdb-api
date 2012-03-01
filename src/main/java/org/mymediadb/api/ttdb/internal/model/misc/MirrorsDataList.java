package org.mymediadb.api.ttdb.internal.model.misc;

import org.mymediadb.api.ttdb.internal.model.MirrorImpl;
import org.mymediadb.api.ttdb.model.Mirror;
import org.simpleframework.xml.ElementList;

import java.util.List;


public class MirrorsDataList implements DataList<Mirror> {

    @ElementList(entry = "Mirror", inline = true)
    private List<MirrorImpl> mirror;

    @Override
    public List<? extends Mirror> getData() {
        return this.mirror;
    }
}
