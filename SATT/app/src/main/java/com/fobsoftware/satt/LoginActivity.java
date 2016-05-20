package com.fobsoftware.satt;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.fobsoftware.satt.Entities.LoginBody;
import com.fobsoftware.satt.Entities.Token;
import com.fobsoftware.satt.Service.Service;
import com.rey.material.widget.Button;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText user, pass;
    private Service service;
    private View parentview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.stormpath.com/")//TODO Cambiar url
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);
        parentview = findViewById(R.id.loginParent);
        user= (EditText)findViewById(R.id.edUsername);
        pass = (EditText)findViewById(R.id.txtPass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.btnLogin)
                {
                    byte[] data = (user.getText().toString()+":"+pass.getText().toString()).getBytes();


                    final String base64 = Base64.encodeToString(data, Base64.NO_WRAP);
                    Log.d("Token",base64);
                    LoginBody lb = new LoginBody();
                    lb.type="basic";
                    lb.value=base64;
                    service.login(lb).enqueue(new Callback<Token>() {
                        @Override
                        public void onResponse(Call<Token> call, Response<Token> response) {
                            Log.d("error",call.request().toString());
                            Log.d("Token",response.body()+"");
                            User.auth=base64;
                            if(response.body()!=null) {
                                finish();
                            }else
                            {
                                Snackbar sb = Snackbar.make(parentview, "Datos erroneos", Snackbar.LENGTH_LONG);
                                sb.show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Token> call, Throwable t) {
                            Snackbar sb = Snackbar.make(parentview, "Datos erroneos", Snackbar.LENGTH_LONG);
                            sb.show();
                        }
                    });
                }

            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
