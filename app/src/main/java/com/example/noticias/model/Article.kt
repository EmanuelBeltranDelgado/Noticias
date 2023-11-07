package com.example.noticias.model

// Serializable se usa para pasar el objeto a otra actividad, luego configuramos newsResponse
// Configura la entidad y ve al artículoDao

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null, // Identificador único autoincremental de la base de datos

    val author: String?, // Nombre del autor del artículo (puede ser nulo)
    val content: String?, // Contenido del artículo (puede ser nulo)
    val description: String?, // Descripción del artículo (puede ser nulo)
    val publishedAt: String?, // Fecha de publicación del artículo (puede ser nulo)
    val source: Source?, // Objeto que representa la fuente del artículo (puede ser nulo)
    val title: String?, // Título del artículo (puede ser nulo)
    val url: String?, // URL del artículo (puede ser nulo)
    val urlToImage: String? // URL de la imagen asociada al artículo (puede ser nulo)
) : Serializable
