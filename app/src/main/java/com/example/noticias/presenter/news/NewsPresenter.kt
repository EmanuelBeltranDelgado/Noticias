package com.example.noticias.presenter.news

// Creamos la actividad abstracta para hacer el código más reutilizable

import com.example.noticias.model.NewsResponse
import com.example.noticias.model.data.NewsDataSource
import com.example.noticias.presenter.ViewHome

class NewsPresenter(
    val view: ViewHome.View,
    private val dataSource: NewsDataSource
) : NewsHome.Presenter {

    override fun requestAl() {
        this.view.showProgressBar()
        this.dataSource.getBreakingNews(this)
    }

    override fun onSuccess(newsResponse: NewsResponse) {
        this.view.showArticles(newsResponse.articles)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }
}
