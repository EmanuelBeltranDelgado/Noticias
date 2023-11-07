package com.example.noticias.ui

// Tomamos el constructor, implementamos los métodos necesarios y fuimos a la actividad favorita para configurarlo.
// Aquí creamos la vista web y vamos a la actividad principal
// terminamos de configurar el intent y luego vamos a la sala de configuración en el artículo en la base de datos
// pasamos a la lista de noticias favoritas en FavorityActivity

import android.webkit.WebViewClient
import com.example.noticias.R
import com.example.noticias.model.Article
import com.example.noticias.model.data.NewsDataSource
import com.example.noticias.presenter.ViewHome
import com.example.noticias.presenter.favorite.FavoritePresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_article.fab
import kotlinx.android.synthetic.main.activity_article.webView

class ArticleActivity : AbstractActivity(), ViewHome.Favorite {
    private lateinit var article: Article
    private lateinit var presenter: FavoritePresenter

    override fun getLayout(): Int = R.layout.activity_article

    override fun onInject() {
        getArticle()
        val dataSource = NewsDataSource(this)
        presenter = FavoritePresenter(this, dataSource)

        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { url ->
                loadUrl(url)
            }
        }

        fab.setOnClickListener {
            presenter.saveArticle(article)
            Snackbar.make(
                it, R.string.article_saved_successful,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    private fun getArticle() {
        intent.extras?.let { articleSend ->
            article = articleSend.get("article") as Article
        }
    }

    override fun showArticles(articles: List<Article>) {}
}
