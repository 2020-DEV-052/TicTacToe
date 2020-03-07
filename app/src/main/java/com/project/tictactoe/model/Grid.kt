package com.project.tictactoe.model

class Grid {

    var currentPlayer = Player.X
    var cells = Array<Array<Cell?>>(3) { arrayOfNulls(size = 3) }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
    }
}