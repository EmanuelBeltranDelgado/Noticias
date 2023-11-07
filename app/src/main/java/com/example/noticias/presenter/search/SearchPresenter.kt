package com.example.noticias.presenter.search

// Creamos la actividad abstracta para hacer el código más reutilizable
// Después de configurar el presentador de búsqueda, fuimos a crear webView en ArticleActivity

import com.example.noticias.model.NewsResponse
import com.example.noticias.model.data.NewsDataSource
import com.example.noticias.presenter.ViewHome

class SearchPresenter(
    val view: ViewHome.View,
    private val dataSource: NewsDataSource
) : SearchHome.Presenter {
    override fun search(term: String) {
        this.view.showProgressBar()
        this.dataSource.searchNews(term, this)
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
