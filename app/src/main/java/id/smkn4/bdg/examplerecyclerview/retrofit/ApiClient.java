package id.smkn4.bdg.examplerecyclerview.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 26/11/16.
 */

public class ApiClient {
    ApiInterface mApiInterface;

    public ApiClient(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
        mApiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApiInteface(){
        return mApiInterface;
    }

}
