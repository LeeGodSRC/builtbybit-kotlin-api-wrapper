import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
    `maven-publish`
}

group = "dev.imanity.bbbapi"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.bundles.ktor.client)
    implementation(libs.coroutines)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "dev.imanity.bbbapi"
            artifactId = "bbbapi"
            version = "1.0.0"

            from(components["java"])
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.17"
}