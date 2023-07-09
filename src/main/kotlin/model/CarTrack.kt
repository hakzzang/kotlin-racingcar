package model

import util.CarCreator
import util.CarNameChecker

class CarTrack {
    private val carNameChecker = CarNameChecker()
    private val carCreator = CarCreator()
    private val _cars: MutableList<Car> = mutableListOf()
    val cars: List<Car> = _cars
    var racingStepCount = 0

    fun init(inputCarName: String, racingStepCount: Int) {
        val cars = carCreator.createCars(inputCarName)
        if (carNameChecker.isValidate(cars)) {
            _cars.addAll(cars)
        }
        this.racingStepCount = racingStepCount
    }
}