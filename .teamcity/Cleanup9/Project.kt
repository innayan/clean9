package Cleanup9

import Cleanup9.buildTypes.*
import Cleanup9.vcsRoots.*
import Cleanup9.vcsRoots.Cleanup9_HttpsGithubComInnayanClean9
import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.Project
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.versionedSettings

object Project : Project({
    id("Cleanup9")
    parentId("_Root")
    name = "Cleanup9"

    vcsRoot(Cleanup9_HttpsGithubComInnayanClean9)

    buildType(Cleanup9_Cleanup9con)

    features {
        versionedSettings {
            id = "PROJECT_EXT_1"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = "${Cleanup9_HttpsGithubComInnayanClean9.id}"
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }

    cleanup {
        keep {
            id = "KEEP_RULE_119"
            keepAtLeast = allBuilds()
            dataToKeep = history()
            preserveArtifactsDependencies = true
        }
    }
})
