/**
 * After-Work Java Coding Dojo - 12.7.2017
 * Software Craftsmanship Meetup Softwerkskammer München
 *
 * Kata of the day:
 * Write a program to search for the "saddle points" in
 * a 5 by 5 array of integers. A saddle point is a cell
 * whose value is greater than or equal to any in its
 * row, and less than or equal to any in its column.
 * There may be more than one saddle point in the array.
 * Print out the coordinates of any saddle points your
 * program finds. Print out "No saddle points" if there
 * are none.
 *
 * Team:
 * - Alex, Tim, Olaf
 */
class SaddlePointCalc(private val spArray: Array<Array<Int>>) {

    // lazily initialized cache for column minimum values
    private val columnMinimum: IntArray by lazy {
        val colMin = IntArray(spArray[0].size)
        for (colIdx in spArray[0].indices) {
            colMin[colIdx] = spArray.map { it[colIdx] }.min() ?: Int.MIN_VALUE
        }
        colMin
    }

    fun calculate(): Set<Coordinate> {
        val result = mutableSetOf<Coordinate>()

        for (rowIdx in spArray.indices) {
            val row = spArray[rowIdx]
            val maxRowValue = row.max()

            result.addAll(
                    // all column indices
                    row.indices
                            // only the maximum indices
                            .filter { colIdx -> row[colIdx] == maxRowValue }
                            // only the ones being also minimum in its column
                            .filter { colIdx -> maxRowValue == columnMinimum[colIdx] }
                            // and mapped to Coordinate
                            .map { colIdx -> Coordinate(rowIdx, colIdx) }
            )
        }

        return result
    }

}

data class Coordinate(val x: Int, val y: Int)

fun main(args: Array<String>) {
    print("Hallo")
}