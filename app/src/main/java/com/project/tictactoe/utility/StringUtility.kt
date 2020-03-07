package com.project.tictactoe.utility

class StringUtility {

    companion object {
        fun joinNumbers(vararg numbers: Int) = numbers.joinTo(StringBuilder(), separator = "").toString()
    }

}