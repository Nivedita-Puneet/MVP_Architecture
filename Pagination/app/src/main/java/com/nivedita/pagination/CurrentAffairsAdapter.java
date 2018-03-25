package com.nivedita.pagination;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.nivedita.pagination.model.News;
import com.nivedita.pagination.model.Row;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by NEETU on 15-03-2018.
 */

public class CurrentAffairsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private List<Row> data;
    private Context context;

    public CurrentAffairsAdapter(Context context) {
        this.context = context;
        data = new LinkedList<>();
    }

    public List<Row> getRows() {
        return data;
    }

    public void setRows(List<Row> movieResults) {
        this.data = movieResults;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingVH(v2);
                break;
        }
        return viewHolder;

    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.news_item, parent, false);
        viewHolder = new CurrentAffairsHolder(v1);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {

            case ITEM:
                final CurrentAffairsHolder currentAffairsHolder = (CurrentAffairsHolder) holder;
                currentAffairsHolder.title.setText(data.get(position).getTitle());
                currentAffairsHolder.description.setText(data.get(position).getDescription());
                Glide
                        .with(context)
                        .load(data.get(position).getImageHref())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)   // cache both original & resized image
                        .centerCrop()
                        .crossFade()
                        .into(currentAffairsHolder.thumbnail);
                break;
            case LOADING:
                break;
        }

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(News Item);
    }

    protected class CurrentAffairsHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView thumbnail;
        ProgressBar mProgressBar;

        public CurrentAffairsHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.news_title);
            description = (TextView) itemView.findViewById(R.id.news_desc);
            thumbnail = (ImageView) itemView.findViewById(R.id.current_affair_poster);
            mProgressBar = (ProgressBar) itemView.findViewById(R.id.load_image_progress);

        }

        public void click(final News newsData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(newsData);
                }
            });
        }
    }

    protected class LoadingVH extends RecyclerView.ViewHolder {

        public LoadingVH(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }


    /*Add helper methods to the adapter*/

    public void addAll(List<Row> rows) {


        data.addAll(rows);

    }
}

