package com.nexdev.enyason.retrofitgithub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.nexdev.enyason.retrofitgithub.API.GitHubUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    ListView repoListView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        repoListView = findViewById(R.id.repo_list); // set up listview
        progressBar = findViewById(R.id.pb_main); // set up progrssBar


        // set up retrofit builder object
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create());


        //create retrofit object

        Retrofit retrofit = builder.build();

        //time to do the actual request

        //instance of our github user

        GitHubUser gitHubUser = retrofit.create(GitHubUser.class);

        Call<List<GitHubRepo>> call =  gitHubUser.repoForUser("enyason");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {

                progressBar.setVisibility(View.INVISIBLE);


//                Toast.makeText(MainActivity.this,response.message().toString(),Toast.LENGTH_LONG).show();

                List<GitHubRepo> list = response.body(); // return the response to a list object


                MyArrayAdapter arrayAdapter = new MyArrayAdapter(MainActivity.this,list); // setup the adapter

//
                repoListView.setAdapter(arrayAdapter); // attach adapter to list view
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

                progressBar.setVisibility(View.INVISIBLE);

            }
        });

    }
}
