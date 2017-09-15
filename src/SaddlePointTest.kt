/**
 * TDD & Rubber Duck Debugging
 */

import org.testng.Assert
import org.testng.annotations.Test

class SaddlePointTest {

    @Test
    fun `array without saddle points`() {
        val a = arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 2),
                arrayOf(7, 8, 1)
        )
        val sp = SaddlePointCalc(a)
        Assert.assertEquals(sp.calculate(), setOf<Coordinate>())
    }

    @Test
    fun `big array with one saddle point`() {
        val a = arrayOf(
                arrayOf(3, 4, 5, 4, 3),
                arrayOf(2, 3, 4, 3, 2),
                arrayOf(1, 2, 3, 2, 1),
                arrayOf(2, 3, 4, 3, 2),
                arrayOf(3, 4, 5, 4, 3)
        )
        val sp = SaddlePointCalc(a)
        Assert.assertEquals(sp.calculate(), setOf(
                Coordinate(2, 2)
        ))
    }

    @Test
    fun `array with nothing but saddle points`() {
        val a = arrayOf(
                arrayOf(1, 1, 1),
                arrayOf(1, 1, 1),
                arrayOf(1, 1, 1)
        )
        val sp = SaddlePointCalc(a)
        Assert.assertEquals(sp.calculate(), setOf(
                Coordinate(2, 2),
                Coordinate(0, 0),
                Coordinate(1, 0),
                Coordinate(2, 0),
                Coordinate(0, 1),
                Coordinate(1, 1),
                Coordinate(2, 1),
                Coordinate(0, 2),
                Coordinate(1, 2)
        ))
    }

    @Test
    fun `array with only one saddle point`() {
        val a = arrayOf(
                arrayOf(0, 42, 0)
        )
        val sp = SaddlePointCalc(a)
        Assert.assertEquals(sp.calculate(), setOf(
                Coordinate(0, 1)
        ))
    }

    @Test
    fun `multiline array with only one saddle point`() {
        val a = arrayOf(
                arrayOf(44, 43, 44),
                arrayOf(0, 42, 0),
                arrayOf(44, 43, 44)
        )
        val sp = SaddlePointCalc(a)
        Assert.assertEquals(sp.calculate(), setOf(
                Coordinate(1, 1)
        ))
    }

}