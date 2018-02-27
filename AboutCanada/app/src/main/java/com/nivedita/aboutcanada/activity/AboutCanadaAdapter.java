package com.nivedita.aboutcanada.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nivedita.aboutcanada.R;
import com.nivedita.aboutcanada.model.Category;
import com.nivedita.aboutcanada.model.News;
import com.squareup.picasso.Picasso;


import java.util.List;

public class AboutCanadaAdapter extends RecyclerView.Adapter<AboutCanadaAdapter.ViewHolder> {
    private List<Category> data;
    private Context context;

    public AboutCanadaAdapter(Context context, List<Category> data) {
        this.data = data;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(data.get(position).getTitle());
        holder.description.setText(data.get(position).getDescription());
        Glide.with(context).load(data.get(position).getImageHref()).into(holder.thumbnail);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(News Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView thumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            description = itemView.findViewById(R.id.news_desc);
            thumbnail = itemView.findViewById(R.id.thumbnail);

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


}
