package com.nexdev.enyason.retrofitgithub.API;

import com.nexdev.enyason.retrofitgithub.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by enyason on 5/23/18.
 */

public interface GitHubUser {

    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> repoForUser(@Path("user") String user);
}
