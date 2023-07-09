import model.FakeEngine
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import util.CarCreator
import util.CarNameChecker
import java.security.InvalidParameterException

class CarTest {
    @Test
    @DisplayName("자동차 객체 추가에 대한 성공 테스트")
    fun testCreateCarThenTrue() {
        // given
        val carCreator = CarCreator()
        // when
        val car = carCreator.create("자동차")
        // then
        assertEquals(car.name == "자동차", true)
    }

    @Test
    @DisplayName("자동차 객체 추가에 대한 실패 테스트")
    fun testCreateCarThenFalse() {
        // given
        val carCreator = CarCreator()
        // when
        val car = carCreator.create("자동차")
        // then
        assertEquals(car.name == "자동차2", false)
    }

    @Test
    @DisplayName("자동차 이름을 체크하는 로직 대한 성공 테스트")
    fun testCheckCarNameThenTrue() {
        // given
        val carCreator = CarCreator()
        val carNameChecker = CarNameChecker()
        // when
        val car = carCreator.create("자동차")
        // then
        assertEquals(carNameChecker.isValidate(car), true)
    }

    @Test
    @DisplayName("자동차 이름을 체크하는 로직 대한 실패 테스트")
    fun testCheckCarNameThenFalse() {
        // given
        val carCreator = CarCreator()
        val carNameChecker = CarNameChecker()
        // when
        val car = carCreator.create("자동차이름5")
        // then
        assertEquals(carNameChecker.isValidate(car), false)
    }

    @Test
    @DisplayName("자동차 이름을 입력하는 로직 대한 성공 테스트")
    fun testInputCheckCarNamesThenTrue() {
        // given
        val carCreator = CarCreator()
        val carNameChecker = CarNameChecker()
        // when
        val cars = carCreator.createCars("BTS,봉준호,손흥민,제이팍,렛츠고")
        // then
        assertEquals(carNameChecker.isValidate(cars), true)
    }

    @Test
    @DisplayName("자동차 이름을 입력하는 로직 대한 실패 테스트")
    fun testInputCheckCarNamesThenFalse() {
        // given
        val carCreator = CarCreator()
        val carNameChecker = CarNameChecker()
        // when
        val cars = carCreator.createCars("BTS,봉준호,손흥민,제이팍,렛츠고오우슛")
        // then
        assertThrows<InvalidParameterException> {
            carNameChecker.isValidate(cars)
        }
    }

    @Test
    @DisplayName("자동차 드라이브에 대한 성공 테스트")
    fun testDriveCarThenTrue() {
        // given
        val carCreator = CarCreator()

        // when
        val car = carCreator.create("자동차")
        car.engine = FakeEngine(4)

        // then
        assertEquals(car.drive(), true)
    }

    @Test
    @DisplayName("자동차 드라이브에 대한 실패 테스트")
    fun testDriveCarThenFalse() {
        // given
        val carCreator = CarCreator()

        // when
        val car = carCreator.create("자동차")
        car.engine = FakeEngine(3)

        // then
        assertEquals(car.drive(), false)
    }

    @Test
    @DisplayName("자동차 드라이브에 대한 엔진 실패 테스트")
    fun testNullCarEngineThenTrue() {
        // given
        val carCreator = CarCreator()

        // when
        val car = carCreator.create("자동차")

        // then
        assertThrows<NullPointerException> {
            car.drive()
        }
    }
}