package com.example.noticias.model.db

// Configurar e ir a la fuente en db
// Posteriormente configuramos el repositorio en repositorio, yendo a repositorio de noticias

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noticias.model.Article

// Anotación que indica que esta clase es una base de datos.
@Database(entities = [Article::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    // Método abstracto que devuelve un objeto ArticleDao.
    abstract fun getArticleDao(): ArticleDao

    // Define un compañero de objeto (companion object) para acceder a métodos y propiedades de la clase de manera estática.
    companion object {

        // La anotación @Volatile asegura que esta variable sea siempre visible para otros hilos de ejecución.
        @Volatile
        private var instance: ArticleDatabase? = null

        // Un objeto de bloqueo que se utiliza para sincronizar el acceso a la instancia de la base de datos.
        private val Lock = Any()

        // Este es un operador de invocación que permite crear o recuperar una instancia de la base de datos.
        operator fun invoke(context: Context) = instance ?: synchronized(Lock) {
            instance ?: createDatabase(context).also { articleDatabase ->
                instance = articleDatabase
            }
        }

        // Método privado para crear la instancia de la base de datos.
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            )
                .allowMainThreadQueries()  // Permite ejecutar consultas en el hilo principal (solo para fines de depuración).
                .build()
    }
}

