package com.example.sampleproject;

import com.example.sampleproject.Model.Asset;
import com.example.sampleproject.Model.AssetDescriptor;
import com.example.sampleproject.Model.Map;
import com.example.sampleproject.Model.RealmAccessible;
import com.example.sampleproject.Model.User;
import com.example.sampleproject.Model.UserRoles;
import com.example.sampleproject.Model.ValueDescriptor;
import com.example.sampleproject.Model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @GET ("weather")
    Call<Weather> getweather(@Query("lat") String lat,
                             @Query("lon") String lon,
                             @Query("appid") String apikey);
    @GET("api/master/map")
    Call<Map> getMap();

    @GET("api/master/realm/accessible")
    Call<List<RealmAccessible>> getRealmAccessible();

    @GET("api/master/user/userRoles")
    Call<List<UserRoles>> getUserRoles();


    @GET ("api/master/model/assetDescriptors")
    Call<List<AssetDescriptor>> getAssetDescriptor();

    @GET("api/master/user/user")
    Call<User> getUser();

    @GET("api/master/asset/{assetID}")
    Call<Asset> getAsset(@Path("assetID") String assetID);//, @Header("Authorization") String auth);

    @GET("api/master/model/valueDescriptors")
    Call<List<ValueDescriptor>> getValueDescriptor();

}
