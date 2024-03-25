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

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

