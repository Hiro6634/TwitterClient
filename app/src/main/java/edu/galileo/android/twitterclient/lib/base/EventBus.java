package edu.galileo.android.twitterclient.lib.base;

/**
 * Created by Hiro on 08/07/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
