package com.project.tictactoe.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.project.tictactoe.R
import org.junit.Rule
import org.junit.Test

class GameGridActivityTest{

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<GameGridActivity> = ActivityTestRule(GameGridActivity::class.java)

    @Test
    fun givenGameStarted_whenUserTaps_testIfButtonTapped_andTextDisplayed() {

        onView(withId(R.id.cell_00)).perform(click())
            .check(matches(isDisplayed()))
            .check(matches(withText("X")))
    }

    @Test
    fun givenHorizontalCellsAreSame_thenWinnerAlertDisplayed() {

        onView(withId(R.id.cell_00)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_10)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_02)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_11)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_01)).perform(click())

        onView(withText("X has won!"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenVerticalCellsAreSame_thenWinnerAlertDisplayed() {

        onView(withId(R.id.cell_22)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_00)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_11)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_10)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_12)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_20)).perform(click())

        onView(withText("O has won!"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenDiagonalCellsAreSame_thenWinnerAlertDisplayed() {

        onView(withId(R.id.cell_20)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_00)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_11)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_10)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_02)).perform(click())

        onView(withText("X has won!"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenGameIsDrawn_thenGameDrawnIsDisplayed() {

        onView(withId(R.id.cell_11)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_01)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_02)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_20)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_10)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_12)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_00)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_22)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_21)).perform(click())

        onView(withText("Game Drawn"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun givenAlertIsDisplayed_whenUserTapsPlayAgain_thenResetGrid() {

        onView(withId(R.id.cell_00)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_10)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_02)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_11)).perform(click())
            .check(matches(isDisplayed()))

        onView(withId(R.id.cell_01)).perform(click())

        onView(withText("X has won!"))
            .check(matches(isDisplayed()))

        onView(withText("Play Again")).inRoot(isDialog())
            .check(matches(isDisplayed())).perform(click())

        onView(withId(R.id.cell_00))
            .check(matches(withText("")))

        onView(withId(R.id.cell_01))
            .check(matches(withText("")))

        onView(withId(R.id.cell_02))
            .check(matches(withText("")))
        onView(withId(R.id.cell_10)).check(matches(withText("")))

        onView(withId(R.id.cell_11))
            .check(matches(withText("")))

        onView(withId(R.id.cell_12))
            .check(matches(withText("")))

        onView(withId(R.id.cell_20))
            .check(matches(withText("")))

        onView(withId(R.id.cell_21))
            .check(matches(withText("")))

        onView(withId(R.id.cell_22))
            .check(matches(withText("")))
    }
}