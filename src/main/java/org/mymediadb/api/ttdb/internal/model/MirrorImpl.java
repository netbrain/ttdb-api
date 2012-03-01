package org.mymediadb.api.ttdb.internal.model;

import org.mymediadb.api.ttdb.model.Mirror;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false, name = "Mirror")
public class MirrorImpl implements Mirror {

    @Element(name = "id")
    private long id;

    @Element
    private String mirrorpath;

    @Element
    private int typemask;

    public long getId() {
        return this.id;
    }

    public int getTypeMask() {
        return this.typemask;
    }

    public String getMirrorPath() {
        return this.mirrorpath;
    }

    @Override
    public String toString() {
        return "MirrorImpl{" +
                "id=" + id +
                ", mirrorpath='" + mirrorpath + '\'' +
                ", typemask=" + typemask +
                '}';
    }
}
