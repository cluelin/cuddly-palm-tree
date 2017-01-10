package com.purelink.cluelin.catalog.vudroid.core.codec;

public interface CodecDocument {
    CodecPage getPage(int pageNumber);

    int getPageCount();

    void recycle();
}
