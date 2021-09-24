package com.example.solucoestarefas.agenda

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.solucoestarefas.Pessoa
import com.example.solucoestarefas.databinding.ActivityAgendaBinding

/**
 * Regras:
 *     - Não pode haver telefone repetido
 *     - Botão imprimir, ao chegar no final da lista, volta pro primeiro contato
 *     - Botão imprimir, lista vazia: mostra aviso
 *     - Botão salvar, nome vazio, mostra erro
 *     - Botão salvar, telefone vazio, mostra erro
 *     - Botão salvar, telefone já está na lista, mostra erro
 *     - Botão deletar sem selecionar contato: mostrar aviso
 */
class AgendaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaBinding
    private val agenda = Agenda()
    private var contatoAtual: Pessoa? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAgendaBinding.inflate(layoutInflater)

        binding.agendaBtDeletar.setOnClickListener {
            if(deletarContato()) {
                binding.agendaTxtNome.text.clear()
                binding.agendaTxtTelefone.text.clear()
                contatoAtual == null
            }
        }

        binding.agendaBtSalvar.setOnClickListener {
            val nomeDigitado = binding.agendaTxtNome.text.toString()
            val telefoneDigitado = binding.agendaTxtTelefone.text.toString()
            salvarContato(nomeDigitado, telefoneDigitado)
        }

        binding.agendaBtImprimirProx.setOnClickListener {
            if (agenda.temContato()) {
                val proximoContato: Pessoa = agenda.getProximoContato()
                binding.agendaTxtNome.setText(proximoContato.nome)
                binding.agendaTxtTelefone.setText(proximoContato.telefone)
                setTxtAviso("", Color.BLACK)
                contatoAtual = proximoContato
            } else {
                setTxtAviso("Agenda vazia!", COR_LARANJA)
            }
        }

        agenda.salvarContato(Pessoa("Rodrigo", "1111"))
        agenda.salvarContato(Pessoa("João", "22222"))
        agenda.salvarContato(Pessoa("Maria", "33333"))

        setContentView(binding.root)
    }

    fun deletarContato(): Boolean {
        if (contatoAtual == null)
            setTxtAviso("Selecione um contato primeiro!", COR_LARANJA)
        else
            if (!agenda.temContato())
                setTxtAviso("Erro, agenda vazia!", Color.RED)
            else if (agenda.removeContato(contatoAtual!!)) {
                setTxtAviso("Contato ${contatoAtual!!.nome} deletado!", COR_VERDE)
                return true
            }
            else
                setTxtAviso(
                    "Contato ${contatoAtual!!.nome} não existe na agenda!",
                    COR_VERDE
                )
        return false
    }

    fun salvarContato(nome: String, telefone: String) {
        if (nome == "")
            setTxtAviso("Nome vazio, favor digitar um nome", Color.RED)
        else if (telefone == "")
            setTxtAviso("Telefone vazio, favor digitar um telefone", Color.RED)
        else {
            val novoContato = Pessoa(nome, telefone)
            if (agenda.salvarContato(novoContato)) {
                setTxtAviso("Contato \"$nome\" salvo!", COR_VERDE)
                contatoAtual = novoContato
            } else
                setTxtAviso("ERRO: Telefone já existe!", Color.RED)
        }

    }

    fun setTxtAviso(mensagem: String, cor: Int) {
        binding.agendaTxtAvisos.text = mensagem
        binding.agendaTxtAvisos.setTextColor(cor)
    }

    companion object {
        val COR_LARANJA = Color.rgb(214, 127, 0)
        val COR_VERDE = Color.rgb(5, 128, 8)
    }
}
