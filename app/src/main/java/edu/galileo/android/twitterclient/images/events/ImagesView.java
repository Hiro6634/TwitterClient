package edu.galileo.android.twitterclient.images.events;

import java.util.List;

import edu.galileo.android.twitterclient.entities.Image;

/**
 * Created by Hiro on 09/07/2016.
 */
public interface ImagesView  {
    void showElements();
    void hideElements();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);

}
