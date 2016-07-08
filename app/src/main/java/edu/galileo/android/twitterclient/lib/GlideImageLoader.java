package edu.galileo.android.twitterclient.lib;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import edu.galileo.android.twitterclient.lib.base.ImageLoader;

/**
 * Created by Hiro on 08/07/2016.
 */
public class GlideImageLoader implements ImageLoader {
    private RequestManager gliderRequestManager;

    public GlideImageLoader(RequestManager gliderRequestManager) {
        this.gliderRequestManager = gliderRequestManager;
    }

    @Override
    public void load(ImageView imageView, String URL) {
        gliderRequestManager
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .override(600,400)
                .into(imageView);
    }
}
