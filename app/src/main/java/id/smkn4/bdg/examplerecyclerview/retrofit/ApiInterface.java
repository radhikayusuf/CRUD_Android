package id.smkn4.bdg.examplerecyclerview.retrofit;

import id.smkn4.bdg.examplerecyclerview.retrofit.dao.CreateUserBody;
import id.smkn4.bdg.examplerecyclerview.retrofit.dao.UserApiDao;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by root on 26/11/16.
 */

public interface ApiInterface {
    @GET("/user/r_user.php")
    Call<UserApiDao> getUser();

    @FormUrlEncoded
    @POST("/user/c_user.php")
    Call<String> createUser(@Field("username") String username, @Field("email") String email, @Field("password") String password);

//    @GET("/user/d_user.php")
//    Call<String> DeleteUser(@Query("username") String username);
}
