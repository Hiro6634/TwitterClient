package edu.galileo.android.twitterclient.images;

import java.util.List;

import edu.galileo.android.twitterclient.entities.Images;

/**
 * Created by Hiro on 09/07/2016.
 */
public interface ImagesView  {
    void showElements();
    void hideElements();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Images> items);

}
