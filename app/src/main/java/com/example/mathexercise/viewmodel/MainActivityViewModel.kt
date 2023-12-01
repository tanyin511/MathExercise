package com.example.mathexercise.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    val rangeOfMaxNumber = 1f..200f
    var maxNumber = mutableStateOf(99f)


    val rangeOfHybridNumber = 0f..20f
    var hybridNumber = mutableStateOf(10f)

    val rangeOfMultiplicationNumber = 0f..20f
    var minMultiplicationNumber = mutableStateOf(1f)
    var maxMultiplicationNumber = mutableStateOf(9f)

    fun generateExercise() {}
}