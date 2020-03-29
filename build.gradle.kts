buildscript {
    dependencies {
        classpath("com.linkedin.pygradle:pygradle-plugin:0.12.10")
    }
}

apply(plugin="com.linkedin.python")
plugins {
    `java-library`
    jacoco
    id("me.champeau.gradle.jmh") version "0.5.0"
}

repositories {
    jcenter()
    ivy(url = "https://linkedin.jfrog.io/artifactory/pypi-external") {
        patternLayout {
            artifact("pypi/[module]/[revision]/[module]-[revision].[ext]")
            ivy("pypi/[module]/[revision]/[module]-[revision].ivy")
        }
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.1")
}

configure<com.linkedin.gradle.python.PythonExtension> {
    testDir = project.projectDir.absolutePath + "/src/test/python"
    srcDir = project.projectDir.absolutePath + "/src/main/python"
    pinnedFile = project.file("requirements.txt")
    details.setPythonVersion("3.8")
    forceVersion("pypi", "flake8", "3.2.1")
    pythonEnvironment.put("PYTHONPATH", srcDir)
}

tasks {
    test {
        useJUnitPlatform()
    }
    jacocoTestReport {
        reports {
            xml.isEnabled = true
        }
    }
}