package util

import model.Car
import java.security.InvalidParameterException

class CarNameChecker {
    fun isValidate(car: Car): Boolean {
        if (car.name.isBlank() || car.name.length > 5) return false
        return true
    }

    fun isValidate(cars: List<Car>): Boolean {
        val isValidated = cars.all { car -> isValidate(car) }
        if (!isValidated) {
            throw InvalidParameterException("자동차 이름이 규격에 맞지 않습니다.")
        }
        return isValidated
    }
}