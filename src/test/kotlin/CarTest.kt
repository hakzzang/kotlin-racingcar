import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    @DisplayName("자동차 객체 추가에 대한 성공 테스트")
    fun testCreateCarThenTrue() {
        // given
        val carCreator = CarCreator()
        // when
        val car = carCreator.create("자동차")
        // then
        assert(car.name == "자동차")
    }

    @Test
    @DisplayName("자동차 객체 추가에 대한 실패 테스트")
    fun testCreateCarThenFalse() {
        // given
        val carCreator = CarCreator()
        // when
        val car = carCreator.create("자동차")
        // then
        assert(car.name != "자동차2")
    }
}