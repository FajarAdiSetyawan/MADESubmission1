package com.fajaradisetyawan.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();
    private String[] dataTitle;
    private String[] dataGenre;
    private String[] dataDate;
    private String[] dataTime;
    private String[] dataDescription;
    private TypedArray dataPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        // listview click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveDetail = new Intent(MainActivity.this, DetailAct.class);
                moveDetail.putExtra(DetailAct.EXTRA_MOVIE, movies.get(i));
                startActivity(moveDetail);
            }
        });

        prepare();
        addItem();
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataDate = getResources().getStringArray(R.array.date_release);
        dataTime = getResources().getStringArray(R.array.date_time);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void  addItem(){
        for (int i = 0; i < dataTitle.length;i++){
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDescription(dataDescription[i]);
            movie.setDaterelease(dataDate[i]);
            movie.setRuntime(dataTime[i]);
            movie.setGenre(dataGenre[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }


}
