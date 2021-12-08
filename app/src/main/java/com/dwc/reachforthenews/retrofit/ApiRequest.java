package com.dwc.reachforthenews.retrofit;

import static com.dwc.reachforthenews.constants.AppConstant.API_KEY;

import com.dwc.reachforthenews.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("top-headlines?country=gb&category=sports&apiKey="+API_KEY)
    Call<ArticleResponse> getTopHeadlines();

}
