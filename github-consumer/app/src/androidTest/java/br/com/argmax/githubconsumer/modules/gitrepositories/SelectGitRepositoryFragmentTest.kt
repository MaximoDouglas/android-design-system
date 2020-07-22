package br.com.argmax.githubconsumer.modules.gitrepositories

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import br.com.argmax.githubconsumer.MainActivity
import br.com.argmax.githubconsumer.R
import br.com.argmax.githubconsumer.utils.FileUtils.getJsonFromFile
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class SelectGitRepositoryFragmentTest {

    private val mMockWebServer = MockWebServer()
    private var mActivityScenario: ActivityScenario<MainActivity>? = null

    @Before
    fun setup() {
        setupMockWebServer()
        mActivityScenario = ActivityScenario.launch(MainActivity::class.java)
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
        Thread.sleep(1000)
        onView(withId(R.id.select_repository_fragment_recycler_view))
            .check(matches(isDisplayed()))
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