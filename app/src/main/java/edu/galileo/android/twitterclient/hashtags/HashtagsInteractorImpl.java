package edu.galileo.android.twitterclient.hashtags;

/**
 * Created by Hiro on 09/07/2016.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor {
    private HashtagsRepository repository;

    public HashtagsInteractorImpl(HashtagsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getHashtags();
    }
}
