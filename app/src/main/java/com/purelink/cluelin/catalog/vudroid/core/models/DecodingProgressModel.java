package com.purelink.cluelin.catalog.vudroid.core.models;

import com.purelink.cluelin.catalog.vudroid.core.events.DecodingProgressListener;
import com.purelink.cluelin.catalog.vudroid.core.events.EventDispatcher;

public class DecodingProgressModel extends EventDispatcher
{
    private int currentlyDecoding;

    public void increase()
    {
        currentlyDecoding++;
        dispatchChanged();
    }

    private void dispatchChanged()
    {
        dispatch(new DecodingProgressListener.DecodingProgressEvent(currentlyDecoding));
    }

    public void decrease()
    {
        currentlyDecoding--;
        dispatchChanged();
    }
}
