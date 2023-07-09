import model.CarTrack
import model.RacingEngine
import java.util.*

class RacingPlayer {
    companion object {
        const val INPUT_RACING_STEP_COUNT_MESSAGE = "자동차 전진을 몇 회 까지 허용하시겠습니까?"
        const val INPUT_CAR_NAMES_MESSAGE = "자동차 이름을 입력해주세요. (콤마를 통해서 이름 구분)"
    }
    private val scanner = Scanner(System.`in`)
    fun play(inputCarNames: String, racingStepCount: Int) {
        val carTrack = CarTrack()
        carTrack.init(
            inputCarName = inputCarNames,
            racingStepCount = racingStepCount,
            engine = RacingEngine()
        )
        carTrack.startRacing()
        carTrack.printCarRacingResult()
        carTrack.printWinnerResult()
    }

    fun inputRacingStepCount(): Int {
        print(INPUT_RACING_STEP_COUNT_MESSAGE)

        return runCatching { scanner.nextLine().toInt() }
            .onSuccess { it }
            .getOrNull() ?: inputRacingStepCount()
    }

    fun inputCarNames(): String {
        print(INPUT_CAR_NAMES_MESSAGE)

        return runCatching { scanner.nextLine() }
            .onSuccess { it }
            .getOrNull() ?: inputCarNames()
    }
}

fun main() {
    val player = RacingPlayer()

    val stepCount = player.inputRacingStepCount()
    val carNames = player.inputCarNames()

    player.play(carNames, stepCount)
}