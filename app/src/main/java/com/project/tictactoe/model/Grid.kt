package com.project.tictactoe.model

import androidx.lifecycle.MutableLiveData

/**
 * This is the model class that keeps track of the moves on the grid
 * @property currentPlayer keeps the value of active player: updated after each move
 * @property cells is a 2D grid that stores the moves of players X and O
 * @property winner is an observer that looks out for the winner of the game
 */
class Grid {

    companion object {
        private const val GRID_SIZE = 3
    }

    var currentPlayer = Player.X
    var cells = Array<Array<Cell?>>(GRID_SIZE) { arrayOfNulls (size = GRID_SIZE) }
    var winner = MutableLiveData<Player>()

    /**
     * Method to update the currentPlayer after each move
     */
    fun switchPlayer() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
    }

    /**
     * Method to check if the game has ended
     * @return boolean
     * Updates winner to X or O if either player has three in a row, horizontally, vertically or diagonally
     * Updates winner to null if game is drawn
     */
    fun hasGameEnded() = when {
        areHorizontalCellsIdentical() || areVerticalCellsIdentical() || areDiagonalCellsIdentical() -> {
            winner.value = currentPlayer
            true
        }
        areAllCellsFilled() -> {
            winner.value = Player.NONE
            true
        }
         else -> false
    }

    /**
     * Method to check if either player has three same horizontal cells
     * @return boolean
     * Iterates through the 2D grid
     * Uses any() testing predicate that returns true if any of the three horizontal cells are identical
     */
    fun areHorizontalCellsIdentical() = (cells.indices).any {
        areCellsIdentical(cells[it][0], cells[it][1], cells[it][2])
    }

    /**
     * Method to check if either player has three same vertical cells
     * @return boolean
     * Iterates through the 2D grid
     * Uses any() testing predicate that returns true if any of the three vertical cells are identical
     */
    fun areVerticalCellsIdentical()  = (cells.indices).any {
        areCellsIdentical(cells[0][it], cells[1][it], cells[2][it] )
    }

    /**
     * Method to check if either player has three same diagonal cells
     * @return boolean
     * Checks if any of the two diagonal cells are identical
     */
    fun areDiagonalCellsIdentical() =
        areCellsIdentical(cells[0][0], cells[1][1], cells[2][2]) ||
                areCellsIdentical(cells[0][2], cells[1][1], cells[2][0])


    /**
     * Method to check if the cells in input array are identical
     * @param cellsInput
     * @return boolean
     * Compares the first element with rest of the elements in input array
     * Uses none() testing predicate that returns true if cells in input array are not null and are identical
     */
    private fun areCellsIdentical(vararg cellsInput: Cell?) =
        (1 until cellsInput.size).none { cellsInput[0] == null || cellsInput[0] != cellsInput[it]}


    /**
     * Method to check if all cells in the grid have been filled
     * @return boolean
     * Uses all() testing predicate that returns true if none of the cells in grid are empty
     */
    fun areAllCellsFilled() = cells.all { it.all {  it != null }}
}