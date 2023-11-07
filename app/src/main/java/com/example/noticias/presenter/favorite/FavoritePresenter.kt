package com.example.noticias.presenter.favorite

// Creado para la integración con favoritos

import com.example.noticias.model.Article
import com.example.noticias.model.data.NewsDataSource
import com.example.noticias.presenter.ViewHome


class FavoritePresenter(
    private val view: ViewHome.Favorite,
    private val dataSource: NewsDataSource
) : FavoriteHome.Presenter {

    fun getAll(){
        this.dataSource.getAllArticle(this)
    }

    fun saveArticle(article: Article) {
        this.dataSource.saveArticle(article)
    }

    fun deleteArticle(article: Article){
        this.dataSource.deleteArticle(article)
    }

    override fun onSuccess(articles: List<Article>) {
        this.view.showArticles(articles)
    }
}
