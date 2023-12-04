package com.example.mathexercise.viewmodel

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val rangeOfMaxNumber = 1f..200f
    var maxNumber = mutableStateOf(99f)

    val rangeOfHybridNumber = 0f..20f
    var hybridNumber = mutableStateOf(10f)

    val rangeOfMultiplier = 0f..20f
    var minMultiplier = mutableStateOf(1f)
    var maxMultiplier = mutableStateOf(9f)

    fun generateExercise(context: Context) {
        val intent = Intent(context, com.example.mathexercise.view.ExerciseActivity::class.java)
        intent
            .putExtra("maxNumber", maxNumber.value.toInt())
            .putExtra("hybridNumber", hybridNumber.value.toInt())
            .putExtra("minMultiplier", minMultiplier.value.toInt())
            .putExtra("maxMultiplier", maxMultiplier.value.toInt())
        context.startActivity(intent)
    }
}