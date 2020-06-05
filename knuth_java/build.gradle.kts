plugins {
    `java-library`
    jacoco
    id("me.champeau.gradle.jmh")
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.1")
}

configure<me.champeau.gradle.JMHPluginExtension> {
    resultFormat = "CSV"
}

tasks {
    test {
        useJUnitPlatform()
    }
}