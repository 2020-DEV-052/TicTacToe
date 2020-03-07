package com.project.tictactoe.utility

class StringUtility {

    companion object {

        /**
         * @param numbers
         * @return String
         * Appends the string from all the numbers in the input
         */
        fun joinNumbers(vararg numbers: Int) = numbers.joinTo(StringBuilder(), separator = "").toString()
    }

}