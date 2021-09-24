package com.example.solucoestarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.solucoestarefas.databinding.ActivityCicloDeVidaBinding

class CicloDeVidaActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCicloDeVidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCicloDeVidaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Log.i("TESTE", "*********** onCreate rodou!! **********")
    }

    override fun onStart() {
        super.onStart()
        Log.i("TESTE", "*********** onStart rodou!! **********")
    }

    override fun onResume() {
        super.onResume()
        Log.i("TESTE", "*********** onResume rodou!! **********")
    }

    override fun onPause() {
        super.onPause()
        Log.i("TESTE", "*********** onPause rodou!! **********")
    }

    override fun onStop() {
        super.onStop()
        Log.i("TESTE", "*********** onStop rodou!! **********")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TESTE", "*********** onDestroy rodou!! **********")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TESTE", "*********** onRestart rodou!! **********")
    }
}