package util

import model.Car
import model.Engine
import model.FakeEngine

class CarCreator {
    fun create(name: String): Car {
        return Car(name)
    }

    fun createCars(inputCarName: String, engine: Engine = FakeEngine(4)): List<Car> {
        return inputCarName.split(",").map { name ->
            create(name).apply { this.engine = engine }
        }.toList()
    }
}