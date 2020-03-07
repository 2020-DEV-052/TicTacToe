package com.project.tictactoe.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.project.tictactoe.model.Player
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameGridViewModelTest {

    lateinit var viewModel: GameGridViewModel

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

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

    @Test
    fun givenX_whenNextPlayer_thenReturnO() {
        viewModel.onCellClick(0,0)
        viewModel.onCellClick(2,0)
        assertEquals("O", viewModel.cells["20"])
    }

    @Test
    fun givenCellOccupied_whenSameCellClicked_thenDoNotOverride() {
        viewModel.onCellClick(0,0)
        viewModel.onCellClick(0,0)
        assertEquals("X", viewModel.cells["00"])
    }

    @Test
    fun givenCellOccupied_whenSameCellClicked_thenDoNotChangePlayer() {
        viewModel.onCellClick(0,0)
        viewModel.onCellClick(0,0)
        assertEquals("O", viewModel.grid.currentPlayer.name)
    }

    @Test
    fun givenGameFinished_whenXWins_setWinnerX() {
        viewModel.onCellClick(0,0)
        viewModel.onCellClick(1,0)
        viewModel.onCellClick(0,1)
        viewModel.onCellClick(2,0)
        viewModel.onCellClick(0,2)
        viewModel.getWinner()
        assertEquals(Player.X, viewModel.grid.winner.value)
    }

    @Test
    fun givenGameFinished_whenOWins_setWinnerO() {
        viewModel.onCellClick(1,0)
        viewModel.onCellClick(0,0)
        viewModel.onCellClick(2,1)
        viewModel.onCellClick(0,1)
        viewModel.onCellClick(1,1)
        viewModel.onCellClick(0,2)
        viewModel.getWinner()
        assertEquals(Player.O, viewModel.grid.winner.value)
    }

    @Test
    fun givenGameFinished_whenGameDrawn_setWinnerNone() {
        viewModel.onCellClick(1,1)
        viewModel.onCellClick(0,1)
        viewModel.onCellClick(0,2)
        viewModel.onCellClick(2,0)
        viewModel.onCellClick(1,0)
        viewModel.onCellClick(1,2)
        viewModel.onCellClick(0,0)
        viewModel.onCellClick(2,2)
        viewModel.onCellClick(2,1)
        viewModel.getWinner()
        assertEquals(Player.NONE, viewModel.grid.winner.value)

    }

}