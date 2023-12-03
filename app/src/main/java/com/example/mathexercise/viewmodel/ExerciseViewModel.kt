package com.example.mathexercise.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.mathexercise.model.Exercises

class ExerciseViewModel : ViewModel() {
    var maxNumber = 99
    var hybridNumber = 10
    var minMultiplicationNumber = 1
    var maxMultiplicationNumber = 9

    fun generateExercise(number: Int): SnapshotStateList<String> {
        var mutableStateList = mutableStateListOf<String>()
        repeat(number - hybridNumber) {
            mutableStateList.add(Exercises.addition(1, maxNumber).formula)
        }
        repeat(hybridNumber) {
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
        }
        return mutableStateList
    }
}