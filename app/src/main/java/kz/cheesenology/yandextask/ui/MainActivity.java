package kz.cheesenology.yandextask.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.cheesenology.yandextask.R;
import kz.cheesenology.yandextask.model.AdapterModel;
import kz.cheesenology.yandextask.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    @BindView(R.id.rv_main)
    RecyclerView recyclerView;

    @BindView(R.id.pb_main)
    ProgressBar progressBar;

    ImagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ButterKnife.bind(this);

        GridLayoutManager gridLayout = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayout);

        if (adapter == null) {
            adapter = new ImagesAdapter();

            adapter.setCallback(model -> {
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                intent.putExtra("image_url", model.getURL());
                startActivity(intent);
            });

            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void showImages(List<AdapterModel> list) {
        adapter.setData(list);
    }

    @Override
    public void toggleProgressBar(boolean isLoading) {
        progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(isLoading ? View.GONE : View.VISIBLE);
    }
}