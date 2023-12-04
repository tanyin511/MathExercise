package com.example.mathexercise.model

import kotlin.random.Random

object Exercises {
    fun addition(min: Int = NumberRange.minNumber, max: Int = NumberRange.maxNumber): Result {
        if (min >= max) return Result.error
        val a = getRandomInt(min, max)
        val b = getRandomInt(min, max - a + min)
        return Result("$a + $b = ", a + b)
    }

    fun subtraction(min: Int = NumberRange.minNumber, max: Int = NumberRange.maxNumber): Result {
        if (min >= max) return Result.error
        val a = getRandomInt(min, max - 1)
        val b = getRandomInt(a, max)
        return Result("$b - $a = ", b - a)
    }

    fun multiplication(
        min: Int = NumberRange.minMultiplier,
        max: Int = NumberRange.maxMultiplier
    ): Result {
        if (min >= max) return Result.error
        val a = getRandomInt(min, max)
        val b = getRandomInt(min, max)
        return Result("$a x $b = ", a * b)
    }

    fun multiplicationAndAddition(
        min: Int = NumberRange.minNumber,
        max: Int = NumberRange.maxNumber,
        minMultiplier: Int = NumberRange.minMultiplier,
        maxMultiplier: Int = NumberRange.maxMultiplier
    ): Result {
        if (min >= max) return Result.error
        if (minMultiplier >= maxMultiplier) return Result.error
        val a = getRandomInt(minMultiplier, maxMultiplier)
        val b = getRandomInt(minMultiplier, maxMultiplier)
        val c = getRandomInt(min, max - a * b - 1)

        return Result(
            "$a X $b + $c= ", a * b + c
        )
    }

    fun additionAndMultiplication(
        min: Int = NumberRange.minNumber,
        max: Int = NumberRange.maxNumber,
        minMultiplier: Int = NumberRange.minMultiplier,
        maxMultiplier: Int = NumberRange.maxMultiplier
    ): Result {
        if (min >= max) return Result.error
        if (minMultiplier >= maxMultiplier) return Result.error
        val a = getRandomInt(minMultiplier, maxMultiplier)
        val b = getRandomInt(minMultiplier, maxMultiplier)
        val c = getRandomInt(min, max - a * b + min)

        return Result(
            "$c + $a X $b = ", c + a * b
        )
    }

    fun multiplicationAndSubtraction(
        min: Int = NumberRange.minNumber,
        max: Int = NumberRange.maxNumber,
        minMultiplier: Int = NumberRange.minMultiplier,
        maxMultiplier: Int = NumberRange.maxMultiplier
    ): Result {
        if (min >= max) return Result.error
        if (minMultiplier >= maxMultiplier) return Result.error
        val a = getRandomInt(minMultiplier, maxMultiplier)
        val b = getRandomInt(minMultiplier, maxMultiplier)
        val c = getRandomInt(min, a * b)

        return Result(
            "$a X $b - $c= ", a * b - c
        )
    }

    fun subtractionAndMultiplication(
        min: Int = NumberRange.minNumber,
        max: Int = NumberRange.maxNumber,
        minMultiplier: Int = NumberRange.minMultiplier,
        maxMultiplier: Int = NumberRange.maxMultiplier
    ): Result {
        if (min >= max) return Result.error
        if (minMultiplier >= maxMultiplier) return Result.error
        val a = getRandomInt(minMultiplier, maxMultiplier)
        val b = getRandomInt(minMultiplier, maxMultiplier)
        val c = getRandomInt(a * b, max)

        return Result(
            "$c - $a X $b = ", c - a * b
        )
    }
}

object NumberRange {
    var minNumber: Int = 1
    var maxNumber: Int = 99
    var minMultiplier: Int = 1
    var maxMultiplier: Int = 9
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

