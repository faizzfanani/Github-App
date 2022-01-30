package com.faizzfanani.githubapp.ui.detail

import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.faizzfanani.githubapp.R
import com.faizzfanani.githubapp.ui.list.ListActivity
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

class DetailActivityTest{

    @get:Rule
    var activityRule = ActivityScenarioRule(ListActivity::class.java)

    @Test
    fun loadUserDetail(){
        Thread.sleep(1000)
        onView(withId(R.id.rv_user)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.rv_user)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_name)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_username)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_avatar)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_bio)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_follower)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_following)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_location)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.rv_repos)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        pressBack()
        Thread.sleep(1000)
    }
    @Test
    fun searchByUsername(){
        Thread.sleep(1000)
        onView(withId(R.id.rv_user)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.searchView)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.searchView)).perform(typeSearchView())
        Thread.sleep(1000)
        onView(withId(R.id.detail_name)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_username)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_avatar)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_bio)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_follower)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_following)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.detail_location)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.rv_repos)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        pressBack()
        Thread.sleep(1000)
    }
    private fun typeSearchView(): ViewAction {
        return object : ViewAction {
            override fun getDescription(): String {
                return "Change view text"
            }

            override fun getConstraints(): Matcher<View> {
                return allOf(isDisplayed(), isAssignableFrom(SearchView::class.java))
            }

            override fun perform(uiController: UiController?, view: View?) {
                (view as SearchView).setQuery("faizzfanani", true)
            }
        }
    }
}