package com.example.noticias.ui

// Creado para hacer el código más reutilizable, con métodos abstractos y fuimos al artículoActividad

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class AbstractActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        onInject()
    }

    @LayoutRes

    protected abstract fun getLayout(): Int
    protected abstract fun onInject()
}
