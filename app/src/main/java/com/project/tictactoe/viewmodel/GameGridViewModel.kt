package com.project.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.ViewModel
import com.project.tictactoe.model.Cell
import com.project.tictactoe.model.Grid
import com.project.tictactoe.utility.StringUtility

class GameGridViewModel : ViewModel() {

    lateinit var grid: Grid
    lateinit var cells: ObservableArrayMap<String, String>

    fun onCellClick(row: Int, column: Int) {
        if (null == grid.cells[row][column]) {
            grid.cells[row][column] = Cell(grid.currentPlayer)
            val tag = StringUtility.joinNumbers(row, column)
            cells[tag] = grid.currentPlayer.name

            if (!grid.isGameEnded()) {
                grid.switchPlayer()
            }
        }
    }

    fun initializeGame() {
        grid = Grid()
        cells = ObservableArrayMap()
    }

    fun getWinner() = grid.winner
}