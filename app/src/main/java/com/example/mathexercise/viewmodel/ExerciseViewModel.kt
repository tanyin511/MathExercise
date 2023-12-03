package com.example.mathexercise.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mathexercise.model.Exercises

class ExerciseViewModel : ViewModel() {
    var maxNumber = 99
    var hybridNumber = 10
    var minMultiplicationNumber = 1
    var maxMultiplicationNumber = 9

    var mutableStateList = mutableStateListOf<String>()
    fun generateExercise(number: Int) {
        repeat(number) {
            mutableStateList.add(Exercises.addition(1, maxNumber).formula)
            //mutableStateList.add("1+1=")
        }
    }
}