package br.com.argmax.githubconsumer.modules.gitrepositories

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import br.com.argmax.githubconsumer.MainActivity
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.ui.modules.gitpullrequests.SelectGitPullRequestFragment
import br.com.argmax.githubconsumer.utils.FileUtils.getJsonFromFile
import br.com.argmax.githubconsumer.utils.RecyclerViewMatcher
import kotlinx.android.synthetic.main.main_activity.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SelectGitRepositoryFragmentTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    private val mMockWebServer = MockWebServer()

    @Before
    fun setup() {
        setupMockWebServer()
        val fragment = SelectGitPullRequestFragment()

        activityTestRule.activity.navHostFragment.onAttachFragment(fragment)
        activityTestRule.launchActivity(Intent())
    }

    @After
    fun tearDown() {
        mMockWebServer.close()
    }

    @Test
    fun test_if_toolbar_is_displayed() {
        onView(withId(R.id.select_repository_fragment_toolbar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_if_toolbar_title_is_set_correctly() {
        onView(withId(R.id.select_repository_fragment_toolbar_title))
            .check(matches(withText(R.string.select_repository_fragment_toolbar_text)))
    }

    @Test
    fun test_if_recyclerview_is_displayed() {
        Thread.sleep(3000)
        onView(withId(R.id.select_repository_fragment_recycler_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun test_if_click_on_repository_item_navigate_to_pull_request_fragment() {
        Thread.sleep(3000)
        onView(
            RecyclerViewMatcher.withRecyclerView(R.id.select_repository_fragment_recycler_view)
                .atPositionOnView(
                    0,
                    R.id.gitRepositoryCard
                )
        ).perform(ViewActions.click())

        onView(withId(R.id.select_git_pull_request_fragment_toolbar)).check(matches(isDisplayed()))
    }

    private fun setupMockWebServer() {
        val mockedApiResponse = MockResponse().setBody(
            getJsonFromFile("jsonfiles/repositories/git_repository_api_response.json")
        )

        mockedApiResponse.setResponseCode(200)
        mMockWebServer.enqueue(mockedApiResponse)
        mMockWebServer.start(8500)
    }

}