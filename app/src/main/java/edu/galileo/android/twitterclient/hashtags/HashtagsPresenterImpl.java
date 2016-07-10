package edu.galileo.android.twitterclient.hashtags;

import org.greenrobot.eventbus.Subscribe;

import edu.galileo.android.twitterclient.hashtags.events.HashtagsEvent;
import edu.galileo.android.twitterclient.hashtags.ui.HashtagsView;
import edu.galileo.android.twitterclient.lib.base.EventBus;

/**
 * Created by Hiro on 09/07/2016.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter {
    private EventBus eventBus;
    private HashtagsView view;
    private HashtagsInteractor interactor;

    public HashtagsPresenterImpl(EventBus eventBus, HashtagsView view, HashtagsInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getHashtagsTweets() {
        if(view != null){
            view.hideHashtags();
            view.showProgress();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if( view != null){
            view.showHashtags();
            view.hideProgress();
        }
        if(errorMsg!=null){
            view.onError(errorMsg);
        }
        else{
            view.setContent(event.getHashtags());
        }
    }
}
