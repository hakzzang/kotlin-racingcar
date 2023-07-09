import model.CarTrack
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTrackTest {
    @Test
    @DisplayName("n대의 자동차 관리 대한 성공 테스트")
    fun testCreateCarsThenTrue() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init("BTS,봉준호,손흥민,제이팍,렛츠고", racingStepCount = 1)
        // then
        Assertions.assertEquals(carTrack.cars.size == 5, true)
    }

    @Test
    @DisplayName("n대의 자동차 관리 대한 실패 테스트")
    fun testCreateCarsThenFalse() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init(inputCarName = "BTS,봉준호,손흥민,제이팍,렛츠고", racingStepCount = 1)
        // then
        Assertions.assertEquals(carTrack.cars.size == 4, false)
    }

    @Test
    @DisplayName("n대의 자동차에 대한 m번 이동하는 것에 대한 성공 테스트")
    fun testInputPlayLoopThenTrue() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init("BTS,봉준호,손흥민,제이팍,렛츠고", racingStepCount = 1)
        // then
        Assertions.assertEquals(carTrack.racingStepCount == 1, true)
    }

    @Test
    @DisplayName("n대의 자동차에 대한 m번 이동하는 것에 대한 실패 테스트")
    fun testInputPlayLoopThenFalse() {
        // given
        val carTrack = CarTrack()
        // when
        carTrack.init("BTS,봉준호,손흥민,제이팍,렛츠고", racingStepCount = 1)
        // then
        Assertions.assertEquals(carTrack.racingStepCount == 2, false)
    }
}