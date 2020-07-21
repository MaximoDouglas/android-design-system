package br.com.argmax.githubconsumer

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private var activityScenario: ActivityScenario<MainActivity>? = null

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun assert_that_nav_host_fragment_is_displayed() {
        onView(withId(R.id.navHostFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun assert_that_select_git_repository_fragment_toolbar_is_displayed() {
        onView(withId(R.id.select_repository_fragment_toolbar)).check(matches(isDisplayed()))
    }

    @Test
    fun assert_that_select_git_repository_fragment_toolbar_title_is_correct() {
        onView(withId(R.id.select_repository_fragment_toolbar_title)).check(matches(withText(R.string.select_repository_fragment_toolbar_text)))
    }

    @Test
    fun assert_that_select_git_repository_fragment_recyclerview_is_displayed() {
        Thread.sleep(2000)
        onView(withId(R.id.select_repository_fragment_recycler_view)).check(matches(isDisplayed()))
    }

}