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

}