package com.example.solucoestarefas.agenda

import com.example.solucoestarefas.Pessoa

class Agenda {
    private val listaContatos = mutableListOf<Pessoa>()
    private var indiceAtual = 0
private val mensagem = ""
    fun salvarContato(novoContato: Pessoa): Boolean {
        for(contato in listaContatos) {
            if(contato.telefone == novoContato.telefone) {
                return false
            }
        }
        listaContatos.add(novoContato)
        return true
    }

    fun removeContato(contatoARemover: Pessoa): Boolean {
        val removido = listaContatos.remove(contatoARemover)
        if(removido) {
            if(indiceAtual - 1 <= 0)
                indiceAtual = 0
            else
                indiceAtual--
        }
        return removido
    }

    fun temContato(): Boolean {
        return listaContatos.size > 0
    }

    fun getProximoContato(): Pessoa {
        if(listaContatos.size == 0)
            throw Error("Lista de contatos vazia! Use temContato antes de chamar isso")

        var proximoContato: Pessoa
        proximoContato = listaContatos[indiceAtual]

        if(indiceAtual + 1 == listaContatos.size)
            indiceAtual = 0
        else
            indiceAtual++

        return proximoContato
    }
}