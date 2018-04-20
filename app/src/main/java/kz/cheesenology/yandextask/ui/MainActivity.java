package kz.cheesenology.yandextask.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.cheesenology.yandextask.R;
import kz.cheesenology.yandextask.model.AdapterModel;
import kz.cheesenology.yandextask.presenter.ImagePresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    ImagePresenter presenter;

    @BindView(R.id.rv_main)
    RecyclerView recyclerView;

    ImagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        GridLayoutManager gridLayout = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayout);

        if (adapter == null) {
            adapter = new ImagesAdapter();

            adapter.setCallback(model -> {
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                intent.putExtra("image_url", model.getImgURL());
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
}