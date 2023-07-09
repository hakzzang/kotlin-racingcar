package model

import kotlin.random.Random

class RacingEngine : Engine {
    private val randomSeed = 10
    private val random = Random(randomSeed)

    override fun accelerate(): Boolean {
        val randomNumber = random.nextInt()
        return randomNumber >= 4
    }
}