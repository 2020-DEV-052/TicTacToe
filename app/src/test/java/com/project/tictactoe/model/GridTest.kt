package com.project.tictactoe.model

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GridTest {

    lateinit var grid: Grid

    @Before
    fun setUp() {
        grid = Grid()
    }

    @Test
    fun givenNewGrid_whenGameInitialized_thenReturnX() {
        assertEquals(Player.X, grid.currentPlayer)
    }

    @Test
    fun givenX_whenNextPlayer_thenReturnO() {
        grid.currentPlayer = Player.X
        grid.switchPlayer()
        assertEquals(Player.O, grid.currentPlayer)
    }

    @Test
    fun givenO_whenNextPlayer_thenReturnX() {
        grid.currentPlayer = Player.O
        grid.switchPlayer()
        assertEquals(Player.X, grid.currentPlayer)
    }

}