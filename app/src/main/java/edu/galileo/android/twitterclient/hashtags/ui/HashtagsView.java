package edu.galileo.android.twitterclient.hashtags.ui;

import java.util.List;

import edu.galileo.android.twitterclient.entities.Hashtag;

/**
 * Created by Hiro on 09/07/2016.
 */
public interface HashtagsView {
    void showHashtags();
    void hideHashtags();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Hashtag> items);

}
