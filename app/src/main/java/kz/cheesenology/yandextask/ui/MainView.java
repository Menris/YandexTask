package kz.cheesenology.yandextask.ui;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import kz.cheesenology.yandextask.model.AdapterModel;

public interface MainView extends MvpView {

    void showImages(List<AdapterModel> list);
}
