package com.example.noticias.ui

// Configurar actividad_búsqueda - diseño y configuración de searchPresenter

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noticias.R
import com.example.noticias.adapter.MainAdapter
import com.example.noticias.model.Article
import com.example.noticias.model.data.NewsDataSource
import com.example.noticias.presenter.ViewHome
import com.example.noticias.presenter.search.SearchPresenter
import com.example.noticias.util.UtilQueryTextListener
import kotlinx.android.synthetic.main.activity_search.rvProgressBarSearch
import kotlinx.android.synthetic.main.activity_search.rvSearch
import kotlinx.android.synthetic.main.activity_search.searchNews

class SearchActivity : AbstractActivity(), ViewHome.View {
    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: SearchPresenter
    override fun getLayout(): Int = R.layout.activity_search

    override fun onInject() {

        val dataSource = NewsDataSource(this)
        presenter = SearchPresenter(this, dataSource)
        configRecycle()
        search()
        clickAdapter()
    }

    private fun search() {
        searchNews.setOnQueryTextListener(
            UtilQueryTextListener(
                this.lifecycle
            ) { newText ->
                newText?.let { query ->
                    if (query.isNotEmpty()) {
                        presenter.search(query)
                        rvProgressBarSearch.visibility = View.VISIBLE

                    }
                }
            }
        )
    }

    private fun configRecycle() {
        with(rvSearch) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@SearchActivity, DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun clickAdapter() {
        mainAdapter.setOnClickListener { article ->
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("article", article)
            startActivity(intent)
        }
    }

    override fun showProgressBar() {
        rvProgressBarSearch.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        rvProgressBarSearch.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}
