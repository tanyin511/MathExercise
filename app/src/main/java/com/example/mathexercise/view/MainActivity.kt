package com.example.mathexercise.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mathexercise.ui.theme.MathExerciseTheme
import com.example.mathexercise.viewmodel.MainActivityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm: MainActivityViewModel by viewModels()
        setContent {
            MathExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(" 计算题范围(${vm.maxNumber.value.toInt()})")
                        Slider(
                            valueRange = vm.rangeOfMaxNumber,
                            value = vm.maxNumber.value,
                            onValueChange = { vm.maxNumber.value = it }
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Text(
                            " 乘法题范围(${vm.minMultiplicationNumber.value.toInt()} ~ " +
                                    "${vm.maxMultiplicationNumber.value.toInt()})"
                        )
                        Slider(
                            valueRange = vm.rangeOfMultiplicationNumber,
                            value = vm.minMultiplicationNumber.value,
                            onValueChange = {
                                if (it.toInt() < vm.maxMultiplicationNumber.value.toInt())
                                    vm.minMultiplicationNumber.value = it
                            }
                        )
                        Slider(
                            valueRange = vm.rangeOfMultiplicationNumber,
                            value = vm.maxMultiplicationNumber.value,
                            onValueChange = {
                                if (it.toInt() > vm.minMultiplicationNumber.value.toInt())
                                    vm.maxMultiplicationNumber.value = it
                            }
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Text(" 混合运算题范围(${vm.hybridNumber.value.toInt()})")
                        Slider(
                            valueRange = vm.rangeOfHybridNumber,
                            value = vm.hybridNumber.value,
                            onValueChange = { vm.hybridNumber.value = it }
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Button(
                            onClick = { vm.generateExercise() },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(text = "生成练习题", textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MathExerciseTheme {
        Greeting("Android")
    }
}