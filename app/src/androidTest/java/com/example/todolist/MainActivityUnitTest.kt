package com.example.todolist

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * a set of tests for the main activity of the application.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityUnitTest {
    /**
     * The starting view of each test.
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * checking the main view
     * finding and clicking the addNewTask button.
     * checking the view of adding a new ToDoK.
     */
    @Test
    fun openNewToDoKFormActivity() {
        onView(withId(R.id.main))
            .check(matches(isDisplayed()))

        onView(withId(R.id.addNewTask))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.addNewFormView))
            .check(matches(isDisplayed()))

    }

    /**
    c* Adding new tasks.
     *
     * checking the main view of the main
     * finding the addNewTask button and clicking on it
     * finding the edTitle and in entering the text "New Task" into it.
     * finding edDescription and in entering the text "New Task Description" into it.
     * finding edtYear and in typing into it the text "2025" and closing the keyboard.
     * finding edtMonth and in typing into it the text "5" and closing the keyboard
     * find edtDay and in it enter the text "5" and close the keyboard
     * find edtMonth and enter there the text "1" and close the keyboard.
     * clicking on the btnSave button and checking if it was clicked.
     * Checking if it shows up in the main task view.
     * Checking if there is an ID such as taskName and then displaying that
     */


    @Test
    fun addNewTask() {
        val title = "New Task"
        val description = "New Task Description"
        val year = "2025"
        val month = "5"
        val day = "1"

        onView(withId(R.id.main))
            .check(matches(isDisplayed()))

        onView(withId(R.id.addNewTask))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.edTitle))
            .check(matches(isDisplayed()))
            .perform(typeText(title))

        onView(withId(R.id.edDescription))
            .check(matches(isDisplayed()))
            .perform(typeText(description))

        onView(withId(R.id.edtYear))
            .check(matches(isDisplayed()))
            .perform(typeText(year))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.edtMonth))
            .check(matches(isDisplayed()))
            .perform(typeText(month))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.edtDay))
            .check(matches(isDisplayed()))
            .perform(typeText(day))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.btnSave))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.main))
            .check(matches(isDisplayed()))

        onView(
            allOf(
                withId(R.id.taskName),
                withText(title)
            )
        )
            .check(matches(isDisplayed()))

    }

    /**
     * deleting a task
     * checking if the main view is there and if it is displayed.
     *Check if addNewTask is there and if it is displayed and clickable.
     * check if it works addNewTitle - edTitle if it is displayed and if it is possible to write.
     * check if it works addNewTaskDescription - edDescription, is it displayed and can it be written
     * Check if it works adding year - edtYear, if it is displayed and if it is possible to write and close the keyboard.
     * Check if adding of month is working - edtMonth, if it is displayed, if it is possible to write and close the keyboard.
     * Check if adding day - edtDay is working, if it is displayed, if it is possible to write and close the keyboard.
     * Check if it works to click save - btnSave - is it displayed, is it possible to write and close the keyboard.
     * Checking if everything has ID taskName and title and if it is displayed.
     * deleteButton - we check if the delete button works and we click on it.
     * at the end we check if the task is if not the test is done
     */


    @Test
    fun removeTask() {
        val title = "New Task"
        val description = "New Task Description"
        val year = "2025"
        val month = "5"
        val day = "1"

        onView(withId(R.id.main))
            .check(matches(isDisplayed()))

        onView(withId(R.id.addNewTask))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.edTitle))
            .check(matches(isDisplayed()))
            .perform(typeText(title))

        onView(withId(R.id.edDescription))
            .check(matches(isDisplayed()))
            .perform(typeText(description))

        onView(withId(R.id.edtYear))
            .check(matches(isDisplayed()))
            .perform(typeText(year))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.edtMonth))
            .check(matches(isDisplayed()))
            .perform(typeText(month))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.edtDay))
            .check(matches(isDisplayed()))
            .perform(typeText(day))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.btnSave))
            .check(matches(isDisplayed()))
            .perform(click())

        onView(withId(R.id.main))
            .check(matches(isDisplayed()))

        onView(
            allOf( // szukamy wszystko co ma ID taskName oraz title
                withId(R.id.taskName),
                withText(title)
            )
        )
            .check(matches(isDisplayed()))

        onView(withId(R.id.deleteButton))
            .check(matches(isDisplayed())) //jeśli - przyciskamy w btn delete
            .perform(click())

        onView(withId(R.id.taskName))
            .check(doesNotExist()) // jeśli - sprawdzamy czy nie istnieje taskName

    }
}

