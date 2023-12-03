package com.example.mathexercise.model

import kotlin.random.Random

object Exercises {
    fun addition(min: Int, max: Int): Result {
        if (min >= max) return Result.error
        var a = getRandomInt(min, max)
        var b = getRandomInt(min, max - a + 1)
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

    fun multiplicationAndAddition(
        min: Int,
        max: Int,
        minMultiplicationNumber: Int,
        maxMultiplicationNumber: Int
    ): Result {
        if (min >= max) return Result.error
        if (minMultiplicationNumber >= maxMultiplicationNumber) return Result.error
        var multiplication = multiplication(minMultiplicationNumber, maxMultiplicationNumber)
        var a = multiplication.operationResult
        var b = getRandomInt(min, max - a + 1)
        return Result(
            "${multiplication.formula} + $b = ", a + b
        )
    }

    fun additionAndMultiplication(
        min: Int,
        max: Int,
        minMultiplicationNumber: Int,
        maxMultiplicationNumber: Int
    ): Result {
        if (min >= max) return Result.error
        if (minMultiplicationNumber >= maxMultiplicationNumber) return Result.error
        var multiplication = multiplication(minMultiplicationNumber, maxMultiplicationNumber)
        var a = multiplication.operationResult
        var b = getRandomInt(min, max - a + 1)
        return Result(
            "$b + ${multiplication.formula} = ", a + b
        )
    }

    fun multiplicationAndSubtraction(
        min: Int,
        max: Int,
        minMultiplicationNumber: Int,
        maxMultiplicationNumber: Int
    ): Result {
        if (min >= max) return Result.error
        if (minMultiplicationNumber >= maxMultiplicationNumber) return Result.error
        var multiplication = multiplication(minMultiplicationNumber, maxMultiplicationNumber)
        var a = multiplication.operationResult
        var b = getRandomInt(min, multiplication.operationResult)
        return Result(
            "${multiplication.formula} - $b = ", a - b
        )
    }

    fun subtractionAndMultiplication(
        min: Int,
        max: Int,
        minMultiplicationNumber: Int,
        maxMultiplicationNumber: Int
    ): Result {
        if (min >= max) return Result.error
        if (minMultiplicationNumber >= maxMultiplicationNumber) return Result.error
        var multiplication = multiplication(minMultiplicationNumber, maxMultiplicationNumber)
        var a = multiplication.operationResult
        var b = getRandomInt(multiplication.operationResult, max)
        return Result(
            "$b - ${multiplication.formula} = ", b - a
        )
    }

    fun hybridProblems(
        min: Int,
        max: Int,
        minMultiplicationNumber: Int,
        maxMultiplicationNumber: Int
    ): Result {
        return when (getRandomInt(1, 4)) {
            1 -> multiplicationAndAddition(
                min,
                max,
                minMultiplicationNumber,
                maxMultiplicationNumber
            )

            2 -> additionAndMultiplication(
                min,
                max,
                minMultiplicationNumber,
                maxMultiplicationNumber
            )

            3 -> subtractionAndMultiplication(
                min,
                max,
                minMultiplicationNumber,
                maxMultiplicationNumber
            )

            else -> multiplicationAndSubtraction(
                min,
                max,
                minMultiplicationNumber,
                maxMultiplicationNumber
            )
        }
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