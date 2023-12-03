package com.example.mathexercise.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.mathexercise.model.Exercises
import com.example.mathexercise.model.getRandomInt

class ExerciseViewModel : ViewModel() {
    var maxNumber = 99
    var hybridNumber = 10
    var minMultiplicationNumber = 1
    var maxMultiplicationNumber = 9

    fun generateExercise(number: Int): SnapshotStateList<String> {
        var mutableStateList = mutableStateListOf<String>()
        repeat(number - hybridNumber) {
            when (getRandomInt(1, 3)) {
                1 -> mutableStateList.add(Exercises.addition(1, maxNumber).formula)
                2 -> mutableStateList.add(Exercises.subtraction(1, maxNumber).formula)
                else -> mutableStateList.add(
                    Exercises.multiplication(
                        minMultiplicationNumber,
                        maxMultiplicationNumber
                    ).formula
                )
            }
        }
        repeat(hybridNumber) {
            mutableStateList.add(
                Exercises.hybridProblems(
                    1,
                    maxNumber,
                    minMultiplicationNumber,
                    maxMultiplicationNumber
                ).formula
            )
        }
        return mutableStateList
    }
}