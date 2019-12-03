package Cleanup9.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*

object Cleanup9_Cleanup9con : BuildType({
    name = "cleanup9con"

    vcs {
        root(Cleanup9.vcsRoots.Cleanup9_HttpsGithubComInnayanClean9, "+:.teamcity111")
        root(AbsoluteId("GitJavaEclipse"), "+:java_eclipse/new2_a")
    }

    cleanup {
        keep {
            id = "KEEP_RULE_119"
            keepAtLeast = allBuilds()
            applyToBuilds {
                inBranches("+:*config")
            }
            dataToKeep = history()
            preserveArtifactsDependencies = true
        }
    }
})
