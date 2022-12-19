package com.aytachuseynli.datastoreusage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aytachuseynli.datastoreusage.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ap = AppPref(this)

        CoroutineScope(Dispatchers.Main).launch {
            //Save
            ap.deleteName()

            //Read
            val resultName = ap.readName()
            Log.e("Result",resultName)

            var counter = ap.readCounter()
            ap.saveCounter(++counter)

            binding.tvResult.text = counter.toString()
        }
    }
}