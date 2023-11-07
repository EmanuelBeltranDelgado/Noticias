package com.example.noticias.presenter.search

import com.example.noticias.model.NewsResponse

interface SearchHome {
    interface Presenter{
        fun search(term: String)
        fun onSuccess(newsResponse: NewsResponse)
        fun onError(message: String)
        fun onComplete()
    }
}