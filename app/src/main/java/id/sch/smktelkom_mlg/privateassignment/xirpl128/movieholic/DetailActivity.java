package id.sch.smktelkom_mlg.privateassignment.xirpl128.movieholic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView tvVoteAverage,tvVoteCount,tvPopularity,tvLanguage,tvRelease,tvOverView;
    ImageView ivBackDrop,ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle(getIntent().getStringExtra(MainActivity.RESULTTITLE));

        tvVoteAverage = (TextView) findViewById(R.id.VoteAverage);
        tvVoteCount = (TextView) findViewById(R.id.VoteCount);
        tvPopularity = (TextView) findViewById(R.id.Popularity);
        tvLanguage = (TextView) findViewById(R.id.Language);
        tvRelease = (TextView) findViewById(R.id.ReleaseDate);
        tvOverView = (TextView) findViewById(R.id.Description);
        ivBackDrop = (ImageView) findViewById(R.id.imageViewBack);
        ivPoster = (ImageView) findViewById(R.id.imageViewPoster);

        tvVoteAverage.setText(getIntent().getStringExtra(MainActivity.RESULTVOTE));
        tvVoteCount.setText(getIntent().getStringExtra(MainActivity.RESULTVOTECOUNT));
        tvPopularity.setText(getIntent().getStringExtra(MainActivity.RESULTPOPULARITY));
        tvLanguage.setText(getIntent().getStringExtra(MainActivity.RESULTLANGUAGE));
        tvRelease.setText(getIntent().getStringExtra(MainActivity.RESULTRELEASE));
        tvOverView.setText(getIntent().getStringExtra(MainActivity.RESULTOVER));
        Glide.with(DetailActivity.this)
                .load("https://image.tmdb.org/t/p/w500"+getIntent().getStringExtra(MainActivity.RESULTBACK))
                .into(ivBackDrop);
        Glide.with(DetailActivity.this)
                .load("https://image.tmdb.org/t/p/w500"+getIntent().getStringExtra(MainActivity.RESULTPOSTER))
                .into(ivPoster);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}
