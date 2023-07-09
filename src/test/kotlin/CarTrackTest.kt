import model.CarTrack
import model.FakeEngine
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import util.CarDashboard

class CarTrackTest {
    @Test
    @DisplayName("n대의 자동차 관리 대한 성공 테스트")
    fun testCreateCarsThenTrue() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init("BTS,봉준호,손흥민,제이팍,렛츠고", racingStepCount = 1, FakeEngine(4))
        // then
        Assertions.assertEquals(carTrack.cars.size == 5, true)
    }

    @Test
    @DisplayName("n대의 자동차 관리 대한 실패 테스트")
    fun testCreateCarsThenFalse() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init(inputCarName = "BTS,봉준호,손흥민,제이팍,렛츠고", racingStepCount = 1, FakeEngine(4))
        // then
        Assertions.assertEquals(carTrack.cars.size == 4, false)
    }

    @Test
    @DisplayName("n대의 자동차에 대한 m번 이동하는 것에 대한 성공 테스트")
    fun testInputPlayLoopThenTrue() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init("BTS,봉준호,손흥민,제이팍,렛츠고", racingStepCount = 1, FakeEngine(4))
        // then
        Assertions.assertEquals(carTrack.racingStepCount == 1, true)
    }

    @Test
    @DisplayName("n대의 자동차에 대한 m번 이동하는 것에 대한 실패 테스트")
    fun testInputPlayLoopThenFalse() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init("BTS,봉준호,손흥민,제이팍,렛츠고", racingStepCount = 1, FakeEngine(4))
        // then
        Assertions.assertEquals(carTrack.racingStepCount == 2, false)
    }

    @Test
    @DisplayName("n대의 자동차에 대한 drive 성공 테스트")
    fun testDriveCarsThenTrue() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init(
            inputCarName = "BTS,봉준호,손흥민,제이팍,렛츠고",
            racingStepCount = 1,
            engine = FakeEngine(4)
        )
        carTrack.startRacing()
        // then
        Assertions.assertEquals(carTrack.cars[0].step == 1, true)
    }

    @Test
    @DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력 테스트")
    fun testPrintDriveThenFalse() {
        // given
        val carTrack = CarTrack()
        val carDashboard = CarDashboard()
        // when
        carTrack.init(
            inputCarName = "BTS,봉준호,손흥민,제이팍,렛츠고",
            racingStepCount = 1,
            engine = FakeEngine(4)
        )
        carTrack.startRacing()
        // then
        Assertions.assertEquals(carDashboard.toCurrentStepTemplateMessage(carTrack.cars[0]), "BTS 자동차는 1만큼 이동했습니다.")
    }

    @Test
    @DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력 테스트")
    fun testPrintCarRacingResultThenTrue() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init(
            inputCarName = "BTS,봉준호,손흥민,제이팍,렛츠고",
            racingStepCount = 5,
            engine = FakeEngine(4)
        )
        carTrack.startRacing()

        // then
        Assertions.assertEquals(carTrack.printCarRacingResult(), listOf(
            "BTS 자동차는 5만큼 이동했습니다.",
            "봉준호 자동차는 5만큼 이동했습니다.",
            "손흥민 자동차는 5만큼 이동했습니다.",
            "제이팍 자동차는 5만큼 이동했습니다.",
            "렛츠고 자동차는 5만큼 이동했습니다."
        ))
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    fun testPrintWinnerThenTrue() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init(
            inputCarName = "BTS,봉준호,손흥민,제이팍,렛츠고",
            racingStepCount = 5,
            engine = FakeEngine(4)
        )
        carTrack.startRacing()

        // then
        Assertions.assertEquals(carTrack.printWinnerResult(), "우승자는 [BTS, 봉준호, 손흥민, 제이팍, 렛츠고] 자동차 입니다.")
    }
}