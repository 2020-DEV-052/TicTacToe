package com.project.tictactoe.model

class Grid {

    var currentPlayer = Player.X
    var cells = Array<Array<Cell?>>(3) { arrayOfNulls(size = 3) }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
    }

    fun areCellsIdenticalInRow() : Boolean {
        for (i in 0 until BOARD_SIZE)
            if (areCellsIdentical(cells[i][0], cells[i][1], cells[i][2])) {
                return true
            }
        return false
    }

    fun areVerticalCellsIdentical() : Boolean {
        for (i in 0 until BOARD_SIZE)
            if (areCellsIdentical(cells[0][i], cells[1][i], cells[2][i])) {
                return true
            }

        return false
    }

    fun areDiagonalCellsIdentical() =
        areCellsIdentical(cells[0][0], cells[1][1], cells[2][2]) ||
                areCellsIdentical(cells[0][2], cells[1][1], cells[2][0])

    private fun areCellsIdentical(vararg cellsInput: Cell?): Boolean {
        val cell = cellsInput[0]
        for (i in 1 until cellsInput.size)
            if (cell == null || cell != cellsInput[i])
                return false
        return true
    }

    companion object {
        private const val BOARD_SIZE = 3
    }
}