plugins {
    `java-library`
    id("me.champeau.gradle.jmh") version "0.5.0"
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.1")
}

tasks {
    test {
        useJUnitPlatform()
    }
}