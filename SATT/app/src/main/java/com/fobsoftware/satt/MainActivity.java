package com.fobsoftware.satt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fobsoftware.satt.Adapters.BoletinAdapter;
import com.fobsoftware.satt.Adapters.EventoAdapter;
import com.fobsoftware.satt.Adapters.SensorAdapter;
import com.fobsoftware.satt.Adapters.TestAdapter;
import com.fobsoftware.satt.Entities.Boletin;
import com.fobsoftware.satt.Entities.Evento;
import com.fobsoftware.satt.Entities.Sensor;
import com.fobsoftware.satt.Entities.Sensores;
import com.fobsoftware.satt.Service.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Service service;
    private RecyclerView recyclerView;
    private String actualType;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View parentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        parentView = findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                refreshItems();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.24.100.36:8080")//TODO Cambiar url
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        service = retrofit.create(Service.class);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        checkUser();
    }

    public void checkUser() {
        if(User.auth==null||User.auth==""){
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }
    }

    private void refreshItems() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_sensor) {
            actualType = "sensor";
            service.adquirirSensores("Basic "+User.auth).enqueue(new Callback<List<Sensor>>() {
                @Override
                public void onResponse(Call<List<Sensor>> call, Response<List<Sensor>> response) {
                    if(response.body()!=null) {
                        Snackbar sb = Snackbar.make(parentView, response.body().size()+"", Snackbar.LENGTH_LONG);
                        sb.show();

                        SensorAdapter ta = new SensorAdapter(response.body());
                        recyclerView.setAdapter(ta);
                    }else
                    {
                        Snackbar sb = Snackbar.make(parentView, response.raw().toString(), Snackbar.LENGTH_LONG);
                        sb.show();
                    }

                }

                @Override
                public void onFailure(Call<List<Sensor>> call, Throwable t) {

                }
             });
        } else if (id == R.id.nav_event) {
            actualType = "evento";
            service.adquirirEventos("Basic "+User.auth).enqueue(new Callback<List<Evento>>() {
                @Override
                public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                    if(response.body()!=null) {
                        Snackbar sb = Snackbar.make(parentView, response.body().size()+"", Snackbar.LENGTH_LONG);
                        sb.show();

                        EventoAdapter ta = new EventoAdapter(response.body());
                        recyclerView.setAdapter(ta);
                    }else
                    {
                        Snackbar sb = Snackbar.make(parentView, response.raw().toString(), Snackbar.LENGTH_LONG);
                        sb.show();
                    }
                }

                @Override
                public void onFailure(Call<List<Evento>> call, Throwable t) {

                }
            });

        } else if (id == R.id.nav_news) {
            actualType="boletin";
            service.adquirirBoletines("Basic "+User.auth).enqueue(new Callback<List<Boletin>>() {
                @Override
                public void onResponse(Call<List<Boletin>> call, Response<List<Boletin>> response) {
                    if(response.body()!=null) {
                        Snackbar sb = Snackbar.make(parentView, response.body().size()+"", Snackbar.LENGTH_LONG);
                        sb.show();

                        BoletinAdapter ta = new BoletinAdapter(response.body());
                        recyclerView.setAdapter(ta);
                    }else
                    {
                        Snackbar sb = Snackbar.make(parentView, response.raw().toString(), Snackbar.LENGTH_LONG);
                        sb.show();
                    }
                }

                @Override
                public void onFailure(Call<List<Boletin>> call, Throwable t) {

                }
            });
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
