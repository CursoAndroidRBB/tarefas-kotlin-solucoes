package com.example.solucoestarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.solucoestarefas.databinding.ActivitySorteioDadosBinding

class SorteioDadosActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySorteioDadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorteio_dados)
    }
}