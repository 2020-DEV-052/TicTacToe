package com.project.tictactoe.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
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

        Espresso.onView(ViewMatchers.withId(R.id.cell_00)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText("X")))
    }

    @Test
    fun givenHorizontalCellsAreSame_thenWinnerAlertDisplayed() {

        Espresso.onView(ViewMatchers.withId(R.id.cell_00)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_10)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_02)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_11)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_01)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("X has won!"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun givenVerticalCellsAreSame_thenWinnerAlertDisplayed() {

        Espresso.onView(ViewMatchers.withId(R.id.cell_22)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_00)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_11)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_10)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_12)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_20)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("O has won!"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun givenDiagonalCellsAreSame_thenWinnerAlertDisplayed() {

        Espresso.onView(ViewMatchers.withId(R.id.cell_20)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_00)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_11)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_10)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_02)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("X has won!"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun givenGameIsDrawn_thenGameDrawnIsDisplayed() {

        Espresso.onView(ViewMatchers.withId(R.id.cell_11)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_01)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_02)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_20)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_10)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_12)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_00)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_22)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.cell_21)).perform(ViewActions.click())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withText("Game Drawn"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}