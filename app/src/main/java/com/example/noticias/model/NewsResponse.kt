package com.example.noticias.model

// Después de eso fuimos a estudiar corrutinas (que es una característica de Kotlin,
// utilizada para escribir código asincrónico sin usar el patrón callbak
// después de eso fuimos a configurar la modernización creando el paquete de red y la API de noticias dentro de él

data class NewsResponse(
    val articles: MutableList<Article>,  // Lista de artículos de noticias
    val status: String,                 // Estado de la respuesta de la API (por ejemplo, "ok" o "error")
    val totalResults: Int               // Número total de resultados disponibles
)
