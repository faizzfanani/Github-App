package com.faizzfanani.githubapp.ui.list

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.faizzfanani.githubapp.R
import org.junit.Rule
import org.junit.Test

class ListActivityTest{

    @get:Rule
    var activityRule = ActivityScenarioRule(ListActivity::class.java)

    @Test
    fun loadUserList(){
        Thread.sleep(1000)
        onView(withId(R.id.rv_user)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.rv_user)).perform(scrollToPosition<RecyclerView.ViewHolder>(10))
        Thread.sleep(1000)
        onView(withId(R.id.rv_user)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(9, click()))
    }
}