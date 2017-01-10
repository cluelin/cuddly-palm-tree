package com.purelink.cluelin.catalog.vudroid.core.events;

public interface Event<T>
{
    void dispatchOn(Object listener);
}
