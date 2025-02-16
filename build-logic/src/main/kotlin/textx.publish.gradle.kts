plugins {
    `maven-publish`
    //signing
}

version = rootProject.version
group = rootProject.group

afterEvaluate {
    publishing {
        repositories {
            maven { // TODO: Update to use mavenCentral
                url = uri("https://repo.repsy.io/mvn/mooncloak/public")

                credentials {
                    username = (project.findProperty("mooncloakRepsyUsername")
                        ?: System.getenv("mooncloakRepsyUsername")) as? String

                    password = (project.findProperty("mooncloakRepsyPassword")
                        ?: System.getenv("mooncloakRepsyPassword")) as? String
                }
            }
        }

        if (plugins.hasPlugin("org.jetbrains.kotlin.multiplatform")) {
            // already has publications, just need to add javadoc task
            val javadocJar by tasks.creating(Jar::class) {
                from("javadoc")
                archiveClassifier.set("javadoc")
            }

            publications.all {
                if (this is MavenPublication) {
                    artifact(javadocJar)
                    mavenCentralPom()
                }
            }

            // create task to publish all apple (macos, ios, tvos, watchos) artifacts
            val publishApple by tasks.registering {
                publications.all {
                    if (name.contains(Regex("macos|ios|tvos|watchos"))) {
                        val publicationNameForTask = name.replaceFirstChar(Char::uppercase)
                        dependsOn("publish${publicationNameForTask}PublicationToSonatypeRepository")
                    }
                }
            }
        } else {
            // Need to create source, javadoc & publication
            val java = extensions.getByType<JavaPluginExtension>()

            java.withSourcesJar()
            java.withJavadocJar()

            publications {
                create<MavenPublication>("lib") {
                    from(components["java"])
                    mavenCentralPom()
                }
            }
        }
    }
}

fun MavenPublication.mavenCentralPom() {
    pom {
        name.set("textx")
        description.set("Kotlin multiplatform representations of rich text content.")
        url.set("https://github.com/mooncloak/textx")

        organization {
            url.set("https://mooncloak.com")
            name.set("mooncloak")
        }

        issueManagement {
            url.set("https://github.com/mooncloak/textx/issues")
            system.set("Github Issues")
        }

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("ckeenan")
                name.set("Chris Keenan")
                url.set("https://github.com/chRyNaN")
                roles.set(setOf("Primary textx developer. 💪"))
            }
        }

        scm {
            connection.set("https://github.com/mooncloak/textx.git")
            developerConnection.set("https://github.com/mooncloak/textx.git")
            url.set("https://github.com/mooncloak/textx")
        }
    }
}

/* FIXME: Signing
signing {
    setRequired {
        findProperty("signing.keyId") != null
    }

    publishing.publications.all {
        sign(this)
    }
}

// TODO: remove after https://youtrack.jetbrains.com/issue/KT-46466 is fixed
project.tasks.withType(AbstractPublishToMaven::class.java).configureEach {
    dependsOn(project.tasks.withType(Sign::class.java))
}
*/
