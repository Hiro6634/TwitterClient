package edu.galileo.android.twitterclient.hashtags.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import edu.galileo.android.twitterclient.R;
import edu.galileo.android.twitterclient.entities.Hashtag;
import edu.galileo.android.twitterclient.hashtags.ui.CustomGridLayoutManager;

/**
 * Created by Hiro on 09/07/2016.
 */
public class HashtagsAdapter extends RecyclerView.Adapter<HashtagsAdapter.ViewHolder> {
    private List<Hashtag> dataset;
    private OnItemClickListener clickListener;

    public HashtagsAdapter(List<Hashtag> dataset, OnItemClickListener clickListener) {
        this.dataset = dataset;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_hashtags, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    public void setItems( List<Hashtag> newItems){
        dataset.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hashtag tweet = dataset.get(position);
        holder.setOnClickListener(tweet, clickListener);
        holder.txtTweet.setText(tweet.getTweetText());
        holder.setItems(tweet.getHashtags());
    }

    @Override
    public int getItemCount() {
        return this.dataset.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtTweet)
        TextView txtTweet;
        @Bind(R.id.recyclerView)
        RecyclerView recyclerView;

        private View view;
        private HashtagListAdapter adapter;
        private ArrayList<String> items;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.view = itemView;

            items = new ArrayList<String>();
            adapter = new HashtagListAdapter(items);

            CustomGridLayoutManager layoutManager = new CustomGridLayoutManager(context, 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        public void setItems(List<String> newItems){
            items.clear();
            items.addAll(newItems);
            adapter.notifyDataSetChanged();
        }

        public void setOnClickListener(final Hashtag hastag, final OnItemClickListener listener){
            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    listener.onItemClick(hastag);
                }
            });
        }
    }
}
