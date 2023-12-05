package com.example.mathexercise.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathexercise.view.ui.theme.MathExerciseTheme
import com.example.mathexercise.viewmodel.ExerciseViewModel

class ExerciseActivity : ComponentActivity() {
    private val vm: ExerciseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        vm.numberRange.minNumber = 1
        vm.numberRange.maxNumber = intent.getIntExtra("maxNumber", 0)
        vm.numberRange.minMultiplier = intent.getIntExtra("minMultiplier", 0)
        vm.numberRange.maxMultiplier = intent.getIntExtra("maxMultiplier", 0)

        vm.mixedOperations = intent.getIntExtra("mixedOperations", 0)


        setContent {
            MathExerciseTheme {
                // A surface container using the 'background' color from the theme

                val pageWidth = LocalConfiguration.current.screenWidthDp
                val pageHeight = (pageWidth.toFloat() / 210) * 297

                val textHeight = pageHeight / (3 * 12)
                Surface(
                    modifier = Modifier
                        .height(pageHeight.dp)
                        .width(pageWidth.dp)
                        .border(1.dp, color = Color.Black),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column {
                        repeat(3) {
                            val exercise = vm.generateExercise(20)

                            Text("", modifier = Modifier.height(textHeight.dp))
                            repeat(10) { line ->
                                Row(modifier = Modifier.height(textHeight.dp)) {
                                    Text(
                                        text = "  [${2 * line + 1}] ${exercise[2 * line]}",
                                        fontSize = 7.sp,
                                        modifier = Modifier.weight(1f),
                                    )
                                    Text(
                                        "  [${2 * line + 2}] ${exercise[2 * line + 1]}",
                                        fontSize = 7.sp,
                                        modifier = Modifier.weight(1f),
                                    )
                                }
                            }
                            Text(
                                text = "  [ 日期：        年        月        日 ]              " +
                                        "[ 用时：        分        秒 ]              " +
                                        "[ 成绩：        对        错 ]",
                                fontSize = 7.sp,
                                modifier = Modifier.height(textHeight.dp)
                            )
                            Divider()
                        }
                    }
                }
            }
        }
    }
}