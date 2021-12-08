package com.dwc.reachforthenews.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dwc.reachforthenews.repository.ArticleRepository;
import com.dwc.reachforthenews.response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        this.articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashBoardNews();

    }

    public LiveData<ArticleResponse> getBoardNewsResponseLiveData(){
        return articleResponseLiveData;
    }
}
