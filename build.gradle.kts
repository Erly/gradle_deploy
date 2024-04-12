import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.22"
    id("org.hidetake.ssh") version "2.11.2"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

apply("conf.gradle.kts")
apply("deploy.gradle")

group = "net.erlantz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.named<ShadowJar>("shadowJar") {
    isZip64 = true
    manifest {
        attributes(mapOf(
            "Implementation-Title" to "Gradle-Deploy",
            "Implementation-Version" to project.version,
            "Main-Class" to "net.erlantz.MainKt"
        ))
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

