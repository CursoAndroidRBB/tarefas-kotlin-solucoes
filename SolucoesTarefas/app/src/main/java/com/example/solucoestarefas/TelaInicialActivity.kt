package com.example.solucoestarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.solucoestarefas.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Toast.makeText(this, "Teste", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_tela_inicial)
    }
}