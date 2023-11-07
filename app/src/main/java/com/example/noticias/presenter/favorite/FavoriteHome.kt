package com.example.noticias.presenter.favorite

import com.example.noticias.model.Article

interface FavoriteHome {

    interface Presenter {
        fun onSuccess(articles: List<Article>)

    }
}