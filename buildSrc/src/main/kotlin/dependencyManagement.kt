import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

const val junitVersion = "5.6.0"
const val mockkVersion ="1.9.3"
const val exposedVersion = "0.24.1"
const val postgresVersion = "42.2.2"

/**
 * Configures the current project as a Kotlin project by adding the Kotlin `stdlib` as a dependency.
 */
fun Project.kotlinProject() {
    dependencies {
        // Kotlin libs
        "implementation"(kotlin("stdlib"))

        // Mockk
        "testImplementation"("io.mockk:mockk:$mockkVersion")

        // JUnit 5
        "testImplementation"("org.junit.jupiter:junit-jupiter-api:$junitVersion")
        "testImplementation"("org.junit.jupiter:junit-jupiter-params:$junitVersion")
        "runtime"("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    }
}

/**
 * Configures data layer libs needed for interacting with the DB
 */
fun Project.dataLibs() {
    dependencies {
        "implementation" ("org.jetbrains.exposed", "exposed-core", exposedVersion)
        "implementation" ("org.jetbrains.exposed", "exposed-jdbc", exposedVersion)
        "implementation" ("org.jetbrains.exposed", "exposed-dao", exposedVersion)
        "implementation" ("org.postgresql:postgresql:$postgresVersion")
    }
}