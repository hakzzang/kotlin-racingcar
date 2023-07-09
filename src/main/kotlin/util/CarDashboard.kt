package util

import model.Car

class CarDashboard {
    companion object {
        const val TEMPLATE_MESSAGE = "{name} 자동차는 {step}만큼 이동했습니다."
    }

    fun toTemplateMessage(car: Car): String {
        return TEMPLATE_MESSAGE
            .replace("{name}", car.name)
            .replace("{step}", car.step.toString())
    }
}