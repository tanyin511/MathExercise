package com.example.mathexercise.model

import android.util.Range
import kotlin.random.Random

object Exercises {
    fun addition(min: Int, max: Int): Result {
        if (min >= max) return Result.error
        var a = getRandomInt(min, max)
        var b = getRandomInt(min, max - a)
        return Result("$a + $b = ", a + b)
    }

    fun subtraction(min: Int, max: Int): Result {
        if (min >= max) return Result.error
        var a = getRandomInt(min, max - 1)
        var b = getRandomInt(a, max)
        return Result("$b - $a = ", b - a)
    }

    fun multiplication(min: Int, max: Int): Result {
        if (min >= max) return Result.error
        var a = getRandomInt(min, max)
        var b = getRandomInt(min, max)
        return Result("$a x $b = ", a * b)
    }

    fun multiplicationAndAddition(min: Int, max: Int): Result {
        if (min >= max) return Result.error
        var multiplication = multiplication(min, max)
        var a = multiplication.operationResult
        var b = getRandomInt(a, max)
        when (getRandomInt(1, 2)) {
            1 -> return Result(
                "${multiplication.formula} + $b = ",
                multiplication.operationResult + b
            )

            2 -> return Result(
                "$b + ${multiplication.formula} = ",
                multiplication.operationResult + b
            )
        }
        return Result.error
    }

    fun multiplicationAndSubtraction(min: Int, max: Int): Result {
        if (min >= max) return Result.error
        var multiplication = multiplication(min, max)
        var a = multiplication.operationResult
        when (getRandomInt(1, 2)) {
            1 -> {
                var b = getRandomInt(a, max)
                return Result(
                    "$b - $a = ", b - a
                )
            }

            2 -> {
                var b = getRandomInt(min, a)
                return Result(
                    "$a - $b = ", a - b
                )
            }
        }
        return Result.error
    }
}

class Result(
    val formula: String, val operationResult: Int
) {

    companion object {
        val error = Result("error", 0)
    }
}

/**
 * 获取从min（包含）到max（包含）的随机数
 */
fun getRandomInt(min: Int, max: Int): Int {
    return Random.nextInt(min, max + 1)
}