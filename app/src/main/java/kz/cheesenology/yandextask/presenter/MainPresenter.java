package kz.cheesenology.yandextask.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import kz.cheesenology.yandextask.model.AdapterModel;
import kz.cheesenology.yandextask.model.ResponseModel;
import kz.cheesenology.yandextask.network.NetworkService;
import kz.cheesenology.yandextask.ui.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    NetworkService service;

    public MainPresenter() {
        if (this.service == null) {
            this.service = new NetworkService();
        }
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getImagesFromNetwork();
    }

    public void getImagesFromNetwork() {
        getViewState().toggleProgressBar(true);

        service.getAPI().getImages()
                .enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        Log.e("response", response.body().toString());
                        List<AdapterModel> list = new ArrayList<>();

                        if (response.body() != null) {
                            List<ResponseModel.Hit> hits = response.body().getHits();
                            for (int i = 0; i < hits.size(); i++) {
                                list.add(new AdapterModel(
                                        hits.get(i).getLargeImageURL(),
                                        hits.get(i).getPreviewURL()));
                            }
                        }
                        getViewState().showImages(list);
                        getViewState().toggleProgressBar(false);
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
