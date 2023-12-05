package com.example.mathexercise.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.mathexercise.model.Exercises
import com.example.mathexercise.model.RangeConfig
import com.example.mathexercise.model.Result


class ExerciseViewModel : ViewModel() {

    var mixedOperations: Int = 10
    var numberRange = RangeConfig

    fun generateExercise(number: Int): SnapshotStateList<String> {
        val mutableStateList = mutableStateListOf<String>()
        val list = mutableListOf<() -> Result>()
        list.add {
            Exercises.addition()
        }
        list.add {
            Exercises.subtraction()
        }
        list.add {
            Exercises.multiplication()
        }

        repeat(number - mixedOperations) {
            mutableStateList.add(list.shuffled()[0].invoke().formula)
        }

        list.clear()
        list.add {
            Exercises.additionAndMultiplication()
        }
        list.add {
            Exercises.multiplicationAndAddition()
        }
        list.add {
            Exercises.subtractionAndMultiplication()
        }
        list.add {
            Exercises.multiplicationAndSubtraction()
        }

        repeat(mixedOperations) {
            mutableStateList.add(list.shuffled()[0].invoke().formula)
        }

        return mutableStateList
    }
}