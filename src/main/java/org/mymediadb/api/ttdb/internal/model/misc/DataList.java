package org.mymediadb.api.ttdb.internal.model.misc;

import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false, name = "Data")
public interface DataList<T> {

    public List<? extends T> getData();

}
