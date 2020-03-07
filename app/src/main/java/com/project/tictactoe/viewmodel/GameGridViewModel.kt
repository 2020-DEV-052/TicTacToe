package com.project.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.ViewModel
import com.project.tictactoe.model.Grid
import com.project.tictactoe.utility.StringUtility

class GameGridViewModel : ViewModel() {

    lateinit var grid: Grid
    lateinit var cells: ObservableArrayMap<String, String>

    fun onCellClick(row: Int, column: Int) {
        val tag = StringUtility.joinNumbers(row, column)
        cells[tag] = grid.currentPlayer.name
        grid.switchPlayer()
    }

    fun initializeGame() {
        grid = Grid()
        cells = ObservableArrayMap()
    }
}