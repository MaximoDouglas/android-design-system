package br.com.argmax.githubconsumer.components.repositorycard

import br.com.argmax.githubconsumer.components.repositorycard.context.*
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    RepositoryCardRepositoryNameTest::class,
    RepositoryCardRepositoryDescriptionTest::class,
    RepositoryCardRepositoryStarsTest::class,
    RepositoryCardRepositoryForksTest::class,
    RepositoryCardUserImageTest::class,
    RepositoryCardUserNameTest::class
)
class RepositoryCardSuiteTest