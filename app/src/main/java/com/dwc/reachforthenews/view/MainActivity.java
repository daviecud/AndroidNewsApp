package com.dwc.reachforthenews.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.dwc.reachforthenews.R;
import com.dwc.reachforthenews.adapter.ArticleAdapter;
import com.dwc.reachforthenews.model.Article;
import com.dwc.reachforthenews.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recycler_view;
    private ProgressBar progressBar;
    private LinearLayoutManager layoutManager;
    private ArrayList<Article>articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;
    private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getArticles();

    }

    private void getArticles() {

        articleViewModel.getBoardNewsResponseLiveData().observe(this, articleResponse ->  {
            if (articleResponse != null && articleResponse.getArticles() != null && !articleResponse.getArticles().isEmpty()) {
                progressBar.setVisibility(View.GONE);
                List<Article> articleList = articleResponse.getArticles();
                articleArrayList.addAll(articleList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void init() {
        progressBar = findViewById(R.id.progress_bar);
        recycler_view = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recycler_view.setLayoutManager(layoutManager);

        recycler_view.setHasFixedSize(true);

        adapter = new ArticleAdapter(MainActivity.this, articleArrayList);
        recycler_view.setAdapter(adapter);
        articleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);
    }
}