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

    @Test
    fun givenThreeSameVerticalCellsInFirstRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[1][0] = cell
        grid.cells[2][0] = cell
        val isVerticalSame = grid.areVerticalCellsIdentical()
        assertTrue(isVerticalSame)
    }

    @Test
    fun givenThreeSameVerticalCellsInSecondRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][1] = cell
        grid.cells[1][1] = cell
        grid.cells[2][1] = cell
        val isVerticalSame = grid.areVerticalCellsIdentical()
        assertTrue(isVerticalSame)
    }

    @Test
    fun givenThreeSameVerticalCellsInThirdRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][2] = cell
        grid.cells[1][2] = cell
        grid.cells[2][2] = cell
        val isVerticalSame = grid.areVerticalCellsIdentical()
        assertTrue(isVerticalSame)
    }

    @Test
    fun givenThreeDifferentVerticalCells_thenReturnFalse() {
        val cell = Cell(Player.X)
        grid.cells[2][0] = cell
        grid.cells[1][1] = cell
        grid.cells[0][2] = cell
        val isVerticalSame = grid.areVerticalCellsIdentical()
        assertFalse(isVerticalSame)
    }

    @Test
    fun givenThreeNullVerticalCells_thenReturnFalse() {
        grid.cells[0][2] = null
        grid.cells[1][2] = null
        grid.cells[2][2] = null
        val areVerticalCellsNull = grid.areVerticalCellsIdentical()
        assertFalse(areVerticalCellsNull)
    }

    @Test
    fun givenThreeSameDiagonalCellsLeftSide_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[1][1] = cell
        grid.cells[2][2] = cell
        val isDiagonal = grid.areDiagonalCellsIdentical()
        assertTrue(isDiagonal)
    }

    @Test
    fun givenThreeSameDiagonalCellsRightSide_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][2] = cell
        grid.cells[1][1] = cell
        grid.cells[2][0] = cell
        val isDiagonal = grid.areDiagonalCellsIdentical()
        assertTrue(isDiagonal)
    }

    @Test
    fun givenThreeDifferentDiagonalCells_thenReturnFalse() {
        val cell = Cell(Player.X)
        grid.cells[2][1] = cell
        grid.cells[1][1] = cell
        grid.cells[0][2] = cell
        val isDiagonal = grid.areDiagonalCellsIdentical()
        assertFalse(isDiagonal)
    }

    @Test
    fun givenThreeNullDiagonalCells_thenReturnFalse() {
        grid.cells[0][2] = null
        grid.cells[1][1] = null
        grid.cells[2][0] = null
        val areDiagonalCellsNull = grid.areVerticalCellsIdentical()
        assertFalse(areDiagonalCellsNull)
    }

}