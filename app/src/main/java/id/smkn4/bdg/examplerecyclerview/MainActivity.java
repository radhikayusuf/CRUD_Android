package id.smkn4.bdg.examplerecyclerview;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.smkn4.bdg.examplerecyclerview.model.UserModel;
import id.smkn4.bdg.examplerecyclerview.retrofit.ApiClient;
import id.smkn4.bdg.examplerecyclerview.retrofit.dao.UserApiDao;
import id.smkn4.bdg.examplerecyclerview.util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rc_main;
    private ApiClient apiClient;
    private UserAdapter adapter;
    private LinearLayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    private List<UserModel> list = new ArrayList<>();
    private SwipeRefreshLayout refreshLayout;
    private Call<UserApiDao> call;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rc_main = (RecyclerView) findViewById(R.id.rc_main);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        apiClient = new ApiClient(Constant.BASE_URL);


        adapter = new UserAdapter(list);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        gridLayoutManager = new GridLayoutManager(getApplicationContext(),4);


        rc_main.setAdapter(adapter);
        rc_main.setLayoutManager(layoutManager);

        call = apiClient.getApiInteface().getUser();
        call.enqueue(new Callback<UserApiDao>() {
            @Override
            public void onResponse(Call<UserApiDao> call, Response<UserApiDao> response) {
                //Log.wtf("onResponse: ", String.valueOf(response.body().getResult().size()));
                for (UserApiDao.ResponseDao data : response.body().getResult()) {
                    list.add(new UserModel(data.getId_user(), data.getUsername(), data.getPassword(), data.getEmail()));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<UserApiDao> call, Throwable t) {

            }
        });


        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                call.clone().enqueue(new Callback<UserApiDao>() {
                    @Override
                    public void onResponse(Call<UserApiDao> call, Response<UserApiDao> response) {
                        list.clear();
                        for (UserApiDao.ResponseDao data : response.body().getResult()) {
                            list.add(new UserModel(data.getId_user(), data.getUsername(), data.getPassword(), data.getEmail()));
                        }
                        adapter.notifyDataSetChanged();
                        refreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onFailure(Call<UserApiDao> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Please Check Your Connection", Toast.LENGTH_SHORT).show();
                        refreshLayout.setRefreshing(false);
                    }
                });
            }
        });
    }

    public void Insert(View view) {
        startActivity(new Intent(this, CreateUserActivity.class));
    }
}
