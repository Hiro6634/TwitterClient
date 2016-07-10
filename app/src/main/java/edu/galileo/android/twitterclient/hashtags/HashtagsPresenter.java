package edu.galileo.android.twitterclient.hashtags;

import edu.galileo.android.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by Hiro on 09/07/2016.
 */
public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagsTweets();
    void onEventMainThread(HashtagsEvent event);

}
