package com.example.noticias.presenter.news

import com.example.noticias.model.NewsResponse

interface NewsHome {
    interface Presenter {
        fun requestAl()
        fun onSuccess(newsResponse: NewsResponse)
        fun onError(message: String)
        fun onComplete()

    }
}