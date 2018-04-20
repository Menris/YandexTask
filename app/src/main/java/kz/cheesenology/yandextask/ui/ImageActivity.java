package kz.cheesenology.yandextask.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.cheesenology.yandextask.R;

public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.iv_big)
    ImageView imageView;

    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        URL = intent.getStringExtra("image_url");

        Picasso.get()
                .load(URL)
                .into(imageView);
    }
}
