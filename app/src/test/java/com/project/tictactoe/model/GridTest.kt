package com.project.tictactoe.model

import org.junit.Assert.*
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

    @Test
    fun givenThreeSameHorizontalCellsInFirstRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[0][1] = cell
        grid.cells[0][2] = cell
        val isHorizontalSame: Boolean = grid.areCellsIdenticalInRow()
        assertTrue(isHorizontalSame)
    }

    @Test
    fun givenThreeSameHorizontalCellsInSecondRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[1][0] = cell
        grid.cells[1][1] = cell
        grid.cells[1][2] = cell
        val isHorizontalSame = grid.areCellsIdenticalInRow()
        assertTrue(isHorizontalSame)
    }

    @Test
    fun givenThreeSameHorizontalCellsInThirdRow_thenReturnTrue() {
        val cell = Cell(Player.O)
        grid.cells[2][0] = cell
        grid.cells[2][1] = cell
        grid.cells[2][2] = cell
        val isHorizontalSame = grid.areCellsIdenticalInRow()
        assertTrue(isHorizontalSame)
    }

    @Test
    fun givenThreeNullHorizontalCells_thenReturnFalse() {
        grid.cells[0][0] = null
        grid.cells[0][1] = null
        grid.cells[0][2] = null
        val hasGameEnded = grid.areCellsIdenticalInRow()
        assertFalse(hasGameEnded)
    }

    @Test
    fun givenThreeDifferentHorizontalCells_thenReturnFalse() {
        val cell = Cell(Player.X)
        grid.cells[2][0] = cell
        grid.cells[1][1] = cell
        grid.cells[0][2] = cell
        val isHorizontalSame  = grid.areCellsIdenticalInRow()
        assertFalse(isHorizontalSame)
    }
}