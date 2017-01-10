package com.purelink.cluelin.catalog.vudroid.pdfdroid.codec;

import android.content.ContentResolver;

import com.purelink.cluelin.catalog.vudroid.core.VuDroidLibraryLoader;
import com.purelink.cluelin.catalog.vudroid.core.codec.CodecContext;
import com.purelink.cluelin.catalog.vudroid.core.codec.CodecDocument;

public class PdfContext implements CodecContext
{
    static
    {
        VuDroidLibraryLoader.load();
    }

    public CodecDocument openDocument(String fileName)
    {
        return PdfDocument.openDocument(fileName, "");
    }

    public void setContentResolver(ContentResolver contentResolver)
    {
        //TODO
    }

    public void recycle() {
    }
}
