package com.fajaradisetyawan.submission1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    //setter hasil generate
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    //constructor hasil generate
    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder{
        private TextView tvTitle, tvGenre, tvDate, tvRuntime, tvDes;
        private ImageView imgPhoto;
        ViewHolder(View view) {
            tvTitle = view.findViewById(R.id.tv_title_movie);
            tvGenre = view.findViewById(R.id.tv_genre);
            tvDate = view.findViewById(R.id.tv_date);
            tvRuntime = view.findViewById(R.id.tv_time);
            imgPhoto = view.findViewById(R.id.img_item_photo);
        }
        void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvGenre.setText(movie.getGenre());
            tvDate.setText(movie.getDaterelease());
            tvRuntime.setText(movie.getRuntime());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }

}
