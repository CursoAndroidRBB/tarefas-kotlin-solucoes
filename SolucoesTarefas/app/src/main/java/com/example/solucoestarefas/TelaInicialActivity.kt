package com.example.solucoestarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.solucoestarefas.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialBinding.inflate(layoutInflater)

        binding.btSorteioDados.setOnClickListener {
            val intent = Intent(this, SorteioDadosActivity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}