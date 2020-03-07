package com.project.tictactoe.model

class Grid {

    var currentPlayer = Player.X

    fun switchPlayer() {
        currentPlayer = if (currentPlayer == Player.X) Player.O else Player.X
    }
}