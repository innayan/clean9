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

    buildType(Cleanup9con)

    features {
        feature {
            id = "KEEP_RULE_119"
            type = "keepRules"
            param("limit.type", "all")
            param("keepData.1.type", "statistics")
            param("ruleDisabled", "false")
            param("preserveArtifacts", "true")
        }
    }
}

object Cleanup9con : BuildType({
    name = "cleanup9con"

    features {
        feature {
            id = "KEEP_RULE_119"
            type = "keepRules"
            param("limit.type", "all")
            param("keepData.1.type", "statistics")
            param("ruleDisabled", "false")
            param("filters.1.pattern", "+:*config")
            param("filters.1.type", "branchSpecs")
            param("preserveArtifacts", "true")
        }
    }
})
