package com.fajaradisetyawan.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailAct extends AppCompatActivity {

    ImageView imgPhoto;
    TextView tvTitle, tvGenre, tvDate, tvTime, tvDes;
    public static final String EXTRA_MOVIE="extra_movie";
    private Movie movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgPhoto = findViewById(R.id.img_item_photo);
        tvTitle = findViewById(R.id.tv_title_movie);
        tvGenre = findViewById(R.id.tv_genre);
        tvDate = findViewById(R.id.tv_date);
        tvTime = findViewById(R.id.tv_time);
        tvDes = findViewById(R.id.tv_description);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        assert movie != null;
        tvTitle.setText(movie.getTitle());
        tvGenre.setText(movie.getGenre());
        tvDate.setText(movie.getDaterelease());
        tvTime.setText(movie.getRuntime());
        tvDes.setText(movie.getDescription());
        int imgfoto = movie.getPhoto();
        imgPhoto.setImageResource(imgfoto);
        Glide.with(this)
                .load(movie.getPhoto())
                .into(imgPhoto);
    }
}
