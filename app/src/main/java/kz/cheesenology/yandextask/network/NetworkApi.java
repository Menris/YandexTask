package kz.cheesenology.yandextask.network;

import kz.cheesenology.yandextask.model.ResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkApi {

    @GET("api/?key=8749139-a68e3eecc3d8e2c74561060a3&q=yellow+flowers&image_type=photo&pretty=true")
    Call<ResponseModel> getImages();
}
