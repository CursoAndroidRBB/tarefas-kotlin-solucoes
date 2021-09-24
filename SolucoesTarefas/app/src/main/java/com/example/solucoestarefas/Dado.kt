package com.example.solucoestarefas

class Dado(val lados: Int) {

    fun sortear(): Int {
        return (1..lados).shuffled().first()
    }
}