package com.example.mathexercise.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mathexercise.view.ui.theme.MathExerciseTheme
import com.example.mathexercise.viewmodel.ExerciseViewModel

class ExerciseActivity : ComponentActivity() {
    private val vm: ExerciseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        vm.numberRange.minNumber = 1
        vm.numberRange.maxNumber = intent.getIntExtra("maxNumber", 0)
        vm.numberRange.minMultiplier = intent.getIntExtra("minMultiplicationNumber", 0)
        vm.numberRange.maxMultiplier = intent.getIntExtra("maxMultiplicationNumber", 0)

        vm.hybridNumber = intent.getIntExtra("hybridNumber", 0)
        val exercise = vm.generateExercise(20)

        setContent {
            MathExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        repeat(20) {
                            Text(text = " [${it + 1}] ${exercise[it]}")
                        }
                    }
                    //Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MathExerciseTheme {
        Greeting2("Android")
    }
}