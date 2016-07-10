package edu.galileo.android.twitterclient.images.ui;

import java.util.List;

import edu.galileo.android.twitterclient.entities.Image;

/**
 * Created by Hiro on 09/07/2016.
 */
public interface ImagesView  {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);

}
