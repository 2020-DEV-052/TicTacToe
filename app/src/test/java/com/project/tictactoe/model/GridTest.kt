package com.project.tictactoe.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GridTest {

    lateinit var grid: Grid

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

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
        assertTrue(grid.areHorizontalCellsIdentical())
    }

    @Test
    fun givenThreeSameHorizontalCellsInSecondRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[1][0] = cell
        grid.cells[1][1] = cell
        grid.cells[1][2] = cell
        assertTrue(grid.areHorizontalCellsIdentical())
    }

    @Test
    fun givenThreeSameHorizontalCellsInThirdRow_thenReturnTrue() {
        val cell = Cell(Player.O)
        grid.cells[2][0] = cell
        grid.cells[2][1] = cell
        grid.cells[2][2] = cell
        assertTrue(grid.areHorizontalCellsIdentical())
    }

    @Test
    fun givenThreeNullHorizontalCells_thenReturnFalse() {
        grid.cells[0][0] = null
        grid.cells[0][1] = null
        grid.cells[0][2] = null
        assertFalse(grid.areHorizontalCellsIdentical())
    }

    @Test
    fun givenThreeDifferentHorizontalCells_thenReturnFalse() {
        val cell = Cell(Player.X)
        grid.cells[2][0] = cell
        grid.cells[1][1] = cell
        grid.cells[0][2] = Cell(Player.O)
        assertFalse(grid.areHorizontalCellsIdentical())
    }

    @Test
    fun givenThreeSameVerticalCellsInFirstRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[1][0] = cell
        grid.cells[2][0] = cell
        assertTrue(grid.areVerticalCellsIdentical())
    }

    @Test
    fun givenThreeSameVerticalCellsInSecondRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][1] = cell
        grid.cells[1][1] = cell
        grid.cells[2][1] = cell
        assertTrue(grid.areVerticalCellsIdentical())
    }

    @Test
    fun givenThreeSameVerticalCellsInThirdRow_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][2] = cell
        grid.cells[1][2] = cell
        grid.cells[2][2] = cell
        assertTrue(grid.areVerticalCellsIdentical())
    }

    @Test
    fun givenThreeDifferentVerticalCells_thenReturnFalse() {
        val cell = Cell(Player.X)
        grid.cells[2][0] = cell
        grid.cells[1][1] = cell
        grid.cells[0][2] = Cell(Player.O)
        assertFalse(grid.areVerticalCellsIdentical())
    }

    @Test
    fun givenThreeNullVerticalCells_thenReturnFalse() {
        grid.cells[0][2] = null
        grid.cells[1][2] = null
        grid.cells[2][2] = null
        assertFalse(grid.areVerticalCellsIdentical())
    }

    @Test
    fun givenThreeSameDiagonalCells_whenLeftToRight_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[1][1] = cell
        grid.cells[2][2] = cell
        assertTrue(grid.areDiagonalCellsIdentical())
    }

    @Test
    fun givenThreeSameDiagonalCells_whenRightToLeft_thenReturnTrue() {
        val cell = Cell(Player.X)
        grid.cells[0][2] = cell
        grid.cells[1][1] = cell
        grid.cells[2][0] = cell
        assertTrue(grid.areDiagonalCellsIdentical())
    }

    @Test
    fun givenThreeDifferentDiagonalCells_thenReturnFalse() {
        val cell = Cell(Player.X)
        grid.cells[2][1] = cell
        grid.cells[1][1] = cell
        grid.cells[0][2] = Cell(Player.O)
        assertFalse(grid.areDiagonalCellsIdentical())
    }

    @Test
    fun givenThreeNullDiagonalCells_thenReturnFalse() {
        grid.cells[0][2] = null
        grid.cells[1][1] = null
        grid.cells[2][0] = null
        assertFalse(grid.areDiagonalCellsIdentical())
    }

    @Test
    fun givenThreeSameHorizontalCells_thenGameEnded() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[0][1] = cell
        grid.cells[0][2] = cell
        assertTrue(grid.hasGameEnded())
    }

    @Test
    fun givenThreeSameVerticalCells_thenEndGame() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[1][0] = cell
        grid.cells[2][0] = cell
        assertTrue(grid.hasGameEnded())
    }

    @Test
    fun givenThreeSameDiagonalCells_thenEndGame() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[1][1] = cell
        grid.cells[2][2] = cell
        assertTrue(grid.hasGameEnded())
    }

    @Test
    fun givenAllCellsAreFilled_thenReturnBoardIsFilled(){
        grid.cells[0][0] = Cell(Player.X)
        grid.cells[0][1] = Cell(Player.O)
        grid.cells[0][2] = Cell(Player.X)
        grid.cells[1][0] = Cell(Player.O)
        grid.cells[1][1] = Cell(Player.X)
        grid.cells[1][2] = Cell(Player.O)
        grid.cells[2][0] = Cell(Player.X)
        grid.cells[2][1] = Cell(Player.O)
        grid.cells[2][2] = Cell(Player.X)
        assertTrue(grid.areAllCellsFilled())
    }

    @Test
    fun givenAllCellsAreFilledWithNoResult_thenEndGame(){
        grid.cells[0][0] = Cell(Player.X)
        grid.cells[0][1] = Cell(Player.O)
        grid.cells[0][2] = Cell(Player.X)
        grid.cells[1][0] = Cell(Player.X)
        grid.cells[1][1] = Cell(Player.X)
        grid.cells[1][2] = Cell(Player.O)
        grid.cells[2][0] = Cell(Player.O)
        grid.cells[2][1] = Cell(Player.X)
        grid.cells[2][2] = Cell(Player.O)
        assertTrue(grid.hasGameEnded())
    }

    @Test
    fun givenGameEnded_whenPlayerIsX_thenDeclareTheWinner() {
        val cell = Cell(Player.X)
        grid.cells[0][0] = cell
        grid.cells[1][1] = cell
        grid.cells[2][2] = cell
        grid.hasGameEnded()
        assertEquals(Player.X, grid.winner.value)
    }

    @Test
    fun givenGameEnded_whenPlayerIsO_thenDeclareTheWinner() {
        val cell = Cell(Player.O)
        grid.currentPlayer = Player.O
        grid.cells[0][2] = cell
        grid.cells[1][1] = cell
        grid.cells[2][0] = cell
        grid.hasGameEnded()
        assertEquals(Player.O, grid.winner.value)
    }

    @Test
    fun givenGameEnded_whenNoneIsWinner_thenDrawGame(){
        grid.cells[0][0] = Cell(Player.X)
        grid.cells[0][1] = Cell(Player.O)
        grid.cells[0][2] = Cell(Player.X)
        grid.cells[1][0] = Cell(Player.O)
        grid.cells[1][1] = Cell(Player.X)
        grid.cells[1][2] = Cell(Player.O)
        grid.cells[2][0] = Cell(Player.O)
        grid.cells[2][1] = Cell(Player.X)
        grid.cells[2][2] = Cell(Player.O)

        grid.hasGameEnded()
        assertEquals(Player.NONE, grid.winner.value)
    }


}