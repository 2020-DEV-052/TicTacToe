package com.project.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.ViewModel
import com.project.tictactoe.model.Grid
import com.project.tictactoe.model.Player

class GameGridViewModel : ViewModel() {

    lateinit var grid: Grid
    lateinit var cells: ObservableArrayMap<String, Player>

    fun onCellClick(row: Int, column: Int) {
    }

    fun initializeGame() {
        grid = Grid()
        cells = ObservableArrayMap()
    }
}