package edu.galileo.android.twitterclient.hashtags.di;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.twitterclient.api.CustomTwitterApiClient;
import edu.galileo.android.twitterclient.entities.Hashtag;
import edu.galileo.android.twitterclient.hashtags.HashtagsInteractor;
import edu.galileo.android.twitterclient.hashtags.HashtagsInteractorImpl;
import edu.galileo.android.twitterclient.hashtags.HashtagsPresenter;
import edu.galileo.android.twitterclient.hashtags.HashtagsPresenterImpl;
import edu.galileo.android.twitterclient.hashtags.HashtagsRepository;
import edu.galileo.android.twitterclient.hashtags.HashtagsRepositoryImpl;
import edu.galileo.android.twitterclient.hashtags.ui.HashtagsView;
import edu.galileo.android.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import edu.galileo.android.twitterclient.hashtags.ui.adapters.OnItemClickListener;
import edu.galileo.android.twitterclient.lib.base.EventBus;

/**
 * Created by Hiro on 09/07/2016.
 */
@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset, OnItemClickListener clickListener){
        return new HashtagsAdapter(dataset, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemList(){
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    HashtagsPresenter providesHashtagsPresenter(EventBus eventBus, HashtagsView view, HashtagsInteractor interactor){
        return new HashtagsPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    HashtagsView providesHashtagView(){
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsInteractor providesHashtagsInteractor(HashtagsRepository repository){
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesHashtagsRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new HashtagsRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session){
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitterSession(){
        return Twitter.getSessionManager().getActiveSession();
    }
}
