package com.project.tictactoe.viewmodel

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameGridViewModelTest {

    lateinit var viewModel: GameGridViewModel

    @Before
    fun setUp() {
        viewModel = GameGridViewModel()
        viewModel.initializeGame()
    }

    @Test
    fun givenNewGrid_whenFirstTimeClicked_thenReturnX() {
        viewModel.onCellClick(0,0)
        assertEquals("X", viewModel.cells["00"])
    }

}