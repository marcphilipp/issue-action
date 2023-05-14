plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.kohsuke:github-api:1.314")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("org.junit.github.App")
}

tasks {
    installDist {
        destinationDir = file("$buildDir/dist")
    }
    test {
        useJUnitPlatform()
    }
}
