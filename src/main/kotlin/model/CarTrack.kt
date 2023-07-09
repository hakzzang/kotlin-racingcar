package model

import util.CarCreator
import util.CarDashboard
import util.CarNameChecker

class CarTrack {
    private val carNameChecker = CarNameChecker()
    private val carCreator = CarCreator()
    private val _cars: MutableList<Car> = mutableListOf()
    private val carDashboard = CarDashboard()
    val cars: List<Car> = _cars
    var racingStepCount = 0

    fun init(inputCarName: String, racingStepCount: Int, engine: Engine) {
        val cars = carCreator.createCars(inputCarName, engine)
        if (carNameChecker.isValidate(cars)) {
            _cars.addAll(cars)
        }
        this.racingStepCount = racingStepCount
    }

    fun startRacing() {
        repeat(racingStepCount) {
            cars.map { it.drive() }
        }
    }

    fun printCarRacingResult(): List<String> {
        val carRacingResult = cars.map { carDashboard.toCurrentStepTemplateMessage(it) }.toList()
        println(carRacingResult)

        return carRacingResult
    }

    fun printWinnerResult(): String {
        val maxStep = cars.maxOf { it.step }
        val winners = cars.filter { it.step == maxStep }.map { it.name }.toList()
        val winnerTemplateMessage = carDashboard.toWinnerTemplateMessage(winners)
        println(winnerTemplateMessage)

        return winnerTemplateMessage
    }
}