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

val pyGradleConfig = the<com.linkedin.gradle.python.PythonExtension>()
pyGradleConfig.testDir = project.projectDir.absolutePath + "/src/test/python"
pyGradleConfig.srcDir = project.projectDir.absolutePath + "/src/main/python"
pyGradleConfig.pinnedFile = project.file("requirements.txt")
pyGradleConfig.forceVersion("pypi", "flake8", "3.2.1")
pyGradleConfig.pythonEnvironment.put("PYTHONPATH", project.projectDir.absolutePath + "/src/main/python")

configure<me.champeau.gradle.JMHPluginExtension> {
    resultFormat = "CSV"
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
    pytest {
        doFirst {
            pyGradleConfig.details.setPythonVersion("3.8")
        }
    }
    coverage {
        doFirst {
            pyGradleConfig.details.setPythonVersion("3.8")
        }
    }
}

val TaskContainer.pytest: TaskProvider<com.linkedin.gradle.python.tasks.PyTestTask>
    get() = named<com.linkedin.gradle.python.tasks.PyTestTask>("pytest")

val TaskContainer.coverage: TaskProvider<com.linkedin.gradle.python.tasks.PyCoverageTask>
    get() = named<com.linkedin.gradle.python.tasks.PyCoverageTask>("coverage")