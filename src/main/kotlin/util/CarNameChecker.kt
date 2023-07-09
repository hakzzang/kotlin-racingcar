package util

import model.Car

class CarNameChecker {
    fun isValidate(car: Car): Boolean {
        if (car.name.isBlank() || car.name.length > 5) return false
        return true
    }
}