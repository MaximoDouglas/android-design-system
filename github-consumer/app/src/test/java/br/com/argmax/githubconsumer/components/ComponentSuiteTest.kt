package br.com.argmax.githubconsumer.components

import br.com.argmax.githubconsumer.components.gitpullrequestcard.GitPullRequestCardSuiteTest
import br.com.argmax.githubconsumer.components.repositorycard.RepositoryCardSuiteTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    RepositoryCardSuiteTest::class,
    GitPullRequestCardSuiteTest::class
)
class ComponentSuiteTest