package id.smkn4.bdg.examplerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.smkn4.bdg.examplerecyclerview.retrofit.ApiClient;
import id.smkn4.bdg.examplerecyclerview.retrofit.dao.CreateUserBody;
import id.smkn4.bdg.examplerecyclerview.retrofit.dao.UserApiDao;
import id.smkn4.bdg.examplerecyclerview.util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity {
    private ApiClient apiClient;
    private Call<String> call;
    private EditText txt_username, txt_pass, txt_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        apiClient = new ApiClient(Constant.BASE_URL);

        txt_email = (EditText) findViewById(R.id.input_email);
        txt_pass = (EditText) findViewById(R.id.input_passowrd);
        txt_username = (EditText) findViewById(R.id.input_username);

    }

    public void submit(View view) {
        call = apiClient.getApiInteface().createUser(txt_username.getText().toString(), txt_email.getText().toString(), txt_pass.getText().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(), response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


//        call.enqueue(new Callback<UserApiDao>() {
//            @Override
//            public void onResponse(Call<UserApiDao> call, Response<UserApiDao> response) {
//                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<UserApiDao> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Failed "+t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
