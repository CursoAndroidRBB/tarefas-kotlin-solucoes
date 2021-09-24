package com.example.solucoestarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.solucoestarefas.databinding.ActivitySorteioDadosBinding

class SorteioDadosActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySorteioDadosBinding
    private var dado1: Dado = Dado(4)
    private var dado2: Dado = Dado(6)
    private var dado3: Dado = Dado(8)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySorteioDadosBinding.inflate(layoutInflater)

        atualizarTxtLados()

        binding.dadosBtSortearDados.setOnClickListener {
            sortearDados()
        }

        binding.dadosBtTrocarDado1.setOnClickListener {
            dado1 = Dado(proximoLados(dado1.lados))
            atualizarTxtLados()
        }

        binding.dadosBtTrocarDado2.setOnClickListener {
            dado2 = Dado(proximoLados(dado2.lados))
            atualizarTxtLados()
        }

        binding.dadosBtTrocarDado3.setOnClickListener {
            dado3 = Dado(proximoLados(dado3.lados))
            atualizarTxtLados()
        }

        setContentView(binding.root)
    }

    fun sortearDados() {
        binding.dadosTxtDado1.text = dado1.sortear().toString()
        binding.dadosTxtDado2.text = dado2.sortear().toString()
        binding.dadosTxtDado3.text = dado3.sortear().toString()
    }

    fun atualizarTxtLados() {
        binding.dadosTxtDado1Lados.text = dado1.lados.toString()
        binding.dadosTxtDado2Lados.text = dado2.lados.toString()
        binding.dadosTxtDado3Lados.text = dado3.lados.toString()
    }

    fun proximoLados(ladoAtual: Int): Int {
        val indiceLadoAtual = LADOS_POSSIVEIS.indexOf(ladoAtual)

        var proximoLado = 0

        if(indiceLadoAtual == LADOS_POSSIVEIS.size - 1)
            proximoLado = LADOS_POSSIVEIS[0]
        else
            proximoLado = LADOS_POSSIVEIS[indiceLadoAtual + 1]

        return proximoLado
    }

    companion object {
        val LADOS_POSSIVEIS = listOf(4, 6, 8, 10)
    }
}