package br.com.argmax.githubconsumer

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import br.com.argmax.githubconsumer.utils.FileUtils.getJson
import br.com.argmax.githubconsumer.utils.RecyclerViewMatcher.Companion.withRecyclerView
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private var activityScenario: ActivityScenario<MainActivity>? = null
    private val mockWebServer = MockWebServer()

    @Before
    fun setup() {
        setupMockWebServer()
        activityScenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.close()
    }

    private fun setupMockWebServer() {
        val endpointToRepositories = "/search/repositories?q=language%3AJava&sort=stars&page=1"
        val endpointToPullRequests = "/repos/CyC2018/CS-Notes/pulls"

        val dispatcher = object : Dispatcher() {
            @Throws(InterruptedException::class)
            override fun dispatch(request: RecordedRequest): MockResponse {
                when (request.path) {
                    endpointToRepositories -> return MockResponse()
                        .setResponseCode(200)
                        .setBody(getJson("jsonfiles/repositories/git_repository_api_response.json"))

                    endpointToPullRequests -> return MockResponse()
                        .setResponseCode(200)
                        .setBody(getJson("jsonfiles/pullrequests/git_pull_request_api_response_cyc2018_cs_notes.json"))
                }

                return MockResponse().setResponseCode(404)
            }
        }

        mockWebServer.dispatcher = dispatcher
        mockWebServer.start(8500)
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
        Thread.sleep(3000)
        onView(withId(R.id.select_repository_fragment_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun assert_that_click_on_repository_item_navigate_to_pull_request_fragment() {
        Thread.sleep(3000)
        onView(
            withRecyclerView(R.id.select_repository_fragment_recycler_view).atPositionOnView(
                0,
                R.id.gitRepositoryCard
            )
        ).perform(click())

        onView(withId(R.id.select_git_pull_request_fragment_toolbar)).check(matches(isDisplayed()))
    }

}