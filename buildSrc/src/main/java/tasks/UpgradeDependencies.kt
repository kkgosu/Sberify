package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.logging.LogLevel
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

/**
 * @author Konstantin Koval
 * @since 20.01.2021
 */
class UpgradeDependencies : DefaultTask() {

    @get:Input
    var logLevel: LogLevel? = LogLevel.DEBUG

    @get:Internal
    protected lateinit var commandExecutor: CommandExecutor

    init {
        description = "Upgrade dependencies"
    }

    @TaskAction
    fun runUpgradeDependencies() {
        commandExecutor = CommandExecutor(project, logLevel!!)
        commandExecutor.execute("gradlew.bat upgradeDependencies")
    }
}