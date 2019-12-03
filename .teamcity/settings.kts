import jetbrains.buildServer.configs.kotlin.v2019_2.*

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2019.2"

project {

    cleanup {
        keep {
            id = "KEEP_RULE_130"
            keepAtLeast = allBuilds()
            dataToKeep = historyAndStatistics {
                preserveArtifacts = byPattern("+:cleanup9a")
            }
            preserveArtifactsDependencies = true
        }
    }

    subProject(Cleanup9)
}


object Cleanup9 : Project({
    name = "Cleanup9"

    buildType(Cleanup9_Cleanup9con)

    cleanup {
        keep {
            id = "KEEP_RULE_128"
            keepAtLeast = allBuilds()
            dataToKeep = everything()
            preserveArtifactsDependencies = true
        }
    }
})

object Cleanup9_Cleanup9con : BuildType({
    name = "cleanup9con"

    vcs {
        root(DslContext.settingsRoot)
        root(AbsoluteId("GitJavaEclipse"))
    }

    cleanup {
        keep {
            id = "KEEP_RULE_118"
            keepAtLeast = builds(5)
            dataToKeep = everything()
            preserveArtifactsDependencies = true
        }
        keep {
            id = "KEEP_RULE_130"
            keepAtLeast = allBuilds()
            applyToBuilds {
                inBranches("""
                    +:*overrie\den
                    +:*overrie\den
                    +:*overrie\den
                    +:*overrie\den
                    +:*overrie\den
                """.trimIndent())
                inPersonalBuilds = personal()
                withStatus = successful()
            }
            dataToKeep = historyAndStatistics {
                preserveArtifacts = byPattern("""
                    +:cleanup9aconfigoverriden/cleanup9aconfigooverridedn/**.*
                    +:cleanup9aconfigoverriden/cleanup9aconfigoverriden/**.*
                """.trimIndent())
            }
            applyPerEachBranch()
            preserveArtifactsDependencies = true
        }
        option("disableCleanupPolicies", true)
    }
       })
