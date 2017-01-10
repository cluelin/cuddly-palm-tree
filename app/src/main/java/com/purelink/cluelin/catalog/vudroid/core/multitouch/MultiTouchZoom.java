package com.purelink.cluelin.catalog.vudroid.core.multitouch;

import android.view.MotionEvent;

public interface MultiTouchZoom {
    boolean onTouchEvent(MotionEvent ev);

    boolean isResetLastPointAfterZoom();

    void setResetLastPointAfterZoom(boolean resetLastPointAfterZoom);
}
