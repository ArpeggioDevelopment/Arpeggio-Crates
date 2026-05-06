plugins {
    id("java")
    id("com.gradleup.shadow") version "9.4.1"
}

group = "dev.blavez"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name = "papermc"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven("https://repo.okaeri.cloud/releases")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")

    implementation("com.google.inject:guice:7.0.0")
    implementation("eu.okaeri:okaeri-configs-yaml-snakeyaml:6.1.0-beta.4")
    implementation("com.j256.ormlite:ormlite-jdbc:6.1")
    implementation("com.zaxxer:HikariCP:7.0.2")
}

tasks.shadowJar {
    archiveFileName.set("ArpeggioCrates-${project.version}.jar")

}