package Cleanup9.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

object Cleanup9_HttpsGithubComInnayanClean9 : GitVcsRoot({
    uuid = "fe18fcaa-b301-4c3e-953b-c321f37c2096"
    name = "https://github.com/innayan/clean9"
    pollInterval = 30000000
    url = "https://github.com/innayan/clean9"
    authMethod = password {
        userName = "innayan"
        password = "credentialsJSON:7d09fc8e-75f2-4c22-8ac4-e2bd1f007480"
    }
})
