package br.com.argmax.githubconsumer

import br.com.argmax.githubconsumer.components.ComponentSuiteTest
import br.com.argmax.githubconsumer.viewmodels.ViewModelSuiteTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ComponentSuiteTest::class,
    ViewModelSuiteTest::class
)
class UnitSuiteTest