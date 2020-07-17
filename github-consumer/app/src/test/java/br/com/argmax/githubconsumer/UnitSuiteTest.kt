package br.com.argmax.githubconsumer

import br.com.argmax.githubconsumer.components.ComponentSuiteTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ComponentSuiteTest::class
)
class UnitSuiteTest