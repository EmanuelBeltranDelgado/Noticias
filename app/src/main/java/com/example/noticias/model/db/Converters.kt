package com.example.noticias.model.db

// Configurar y regresar a la base de datos del artículo

import androidx.room.TypeConverter
import com.example.noticias.model.Source

class Converters {
    // Este método convierte un objeto Source en una cadena.
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name  // Devuelve el nombre de la fuente como una cadena.
    }

    // Este método convierte una cadena en un objeto Source.
    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)  // Crea un objeto Source con el nombre proporcionado y una ID ficticia igual al nombre.
    }
}

