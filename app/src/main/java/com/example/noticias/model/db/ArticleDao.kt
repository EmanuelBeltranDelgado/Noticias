package com.example.noticias.model.db

// Configurar el DAO y ir a ArticleDataBase

import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import com.example.noticias.model.Article

// Indica que esta es una interfaz de acceso a datos (DAO) para la entidad Article.
@Dao
interface ArticleDao {

    // Este método permite insertar o actualizar un artículo en la base de datos.
    // El parámetro `article` es el objeto Article que se insertará o actualizará.
    // `OnConflictStrategy.REPLACE` se utiliza para reemplazar el artículo si ya existe en la base de datos.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateInsert(article: Article)

    // Este método se utiliza para recuperar todos los artículos de la base de datos.
    // La anotación `@Query` indica que estás definiendo una consulta SQL personalizada.
    // "SELECT * FROM articles" es la consulta SQL para seleccionar todos los registros de la tabla "articles".
    // La función devuelve una lista de objetos Article.
    @Query("SELECT * FROM articles")
    fun getAll(): List<Article>

    // Este método se utiliza para eliminar un artículo de la base de datos.
    // El objeto `article` se eliminará de la base de datos.
    // La anotación `@Delete` indica que estás definiendo una operación de eliminación.
    @Delete
    fun delete(article: Article)
}

