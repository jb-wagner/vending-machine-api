group = "com.jb.wagner"
version = "1.0-SNAPSHOT"

buildscript {
    var versions: Map<String, String> by extra
    versions = mapOf(
        "javalin" to "1.3.0",
        "slf4j" to "1.7.24",
        "jackson" to "2.9.4"
    )

    repositories {
        mavenCentral()
    }
}

val versions: Map<String, String> by extra

plugins {
    application
    kotlin("jvm") version "1.2.21"
}

application {
    mainClassName = "com.jb.wagner.Application"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib"))
    compile("io.javalin:javalin:${versions["javalin"]}")
    compile("org.slf4j:slf4j-simple:${versions["slf4j"]}")
    compile("com.fasterxml.jackson.core:jackson-databind:${versions["jackson"]}")
    compile("com.fasterxml.jackson.core:jackson-core:${versions["jackson"]}")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:${versions["jackson"]}")
}

