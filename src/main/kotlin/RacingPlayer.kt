import model.CarTrack
import model.RacingEngine
import java.util.*

class RacingPlayer {
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
}

fun main() {
    // TODO : main 부분 로직 보완 필요
    val player = RacingPlayer()
    val sc = Scanner(System.`in`)
    print("자동차 전진을 몇 회 까지 허용하시겠습니까?")
    val racingStepCount = sc.nextInt()

    print("자동차 이름을 입력해주세요. (콤마를 통해서 이름 구분)")
    val inputCarNames = sc.next()
    player.play(inputCarNames, racingStepCount)
}