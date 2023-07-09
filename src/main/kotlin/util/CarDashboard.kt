package util

import model.Car

class CarDashboard {
    companion object {
        const val CURRENT_STEP_TEMPLATE_MESSAGE = "{name} 자동차는 {step}만큼 이동했습니다."
        const val WINNER_TEMPLATE_MESSAGE = "우승자는 {winner} 자동차 입니다."
    }

    fun toCurrentStepTemplateMessage(car: Car): String {
        return CURRENT_STEP_TEMPLATE_MESSAGE
            .replace("{name}", car.name)
            .replace("{step}", car.step.toString())
    }

    fun toWinnerTemplateMessage(winners: List<String>): String {
        return WINNER_TEMPLATE_MESSAGE.replace("{winner}", winners.toString())
    }
}