package com.example.noticias.model.data

// Después de configurar fuimos al elemento guardar artículos en la actividad del artículo

import com.example.noticias.model.Article
import com.example.noticias.model.db.ArticleDatabase

class NewsRepository(private val db: ArticleDatabase) {

    suspend fun updateInsert(article: Article) = db.getArticleDao().updateInsert(article)

    fun getAll(): List<Article> = db.getArticleDao().getAll()

    suspend fun delete(article: Article) = db.getArticleDao().delete(article)

}
