package com.project.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.ViewModel
import com.project.tictactoe.model.Cell
import com.project.tictactoe.model.Grid
import com.project.tictactoe.utility.StringUtility.Companion.joinNumbers

/**
 * This is the ViewModel class that keeps track of the UI related data
 * @property grid works as repository to keep track of moves of the two players
 * @property cells is an ObservableArrayMap that saves the state (X/O) for each cell to notify the UI
 */

class GameGridViewModel : ViewModel() {

    lateinit var grid: Grid
    lateinit var cells: ObservableArrayMap<String, String>

    /**
     * This method initializes the properties grid and cells
     * Triggered by UI at the start of the game
     */
    fun initializeGame() {
        grid = Grid()
        cells = ObservableArrayMap()
    }

    /**
     * This method is triggered by UI when a button on the grid is tapped
     * @param row
     * @param column
     * Switches player after each move if game has not ended
     * Saves the value of active player in the ObservableArrayMap
     */
    fun onCellClick(row: Int, column: Int) {
        if (null == grid.cells[row][column]) {
            grid.cells[row][column] = Cell(grid.currentPlayer)
            val tag = joinNumbers(row, column)
            cells[tag] = grid.currentPlayer.name

            if (!grid.hasGameEnded()) {
                grid.switchPlayer()
            }
        }
    }

    /**
     * This method observes the winner from grid repository and notifies UI
     */
    fun getWinner() = grid.winner
}