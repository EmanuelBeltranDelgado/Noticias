package com.example.noticias.model

// Desde aquí creamos convertidores y fuimos a configurarlos

import java.io.Serializable

data class Source(
    val id: Any,       // Identificador de la fuente (puede ser de cualquier tipo, ya que se utiliza 'Any')
    val name: String   // Nombre de la fuente de la noticia
) : Serializable     // Implementa la interfaz Serializable para permitir la serialización de objetos Source


