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
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:26.1.2.build.+")

    implementation("com.google.inject:guice:7.0.0")
}
