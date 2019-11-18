package com.example.scan.apihelper;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("masuk.php")
    Call<ResponseBody> scanRequest(@Field("id_pesan") String id_pesan);

    @GET("masuk1.php")
    Call<List<list_kursi>> getKursi(
            @Query("item_type") String item_type
    );
}
