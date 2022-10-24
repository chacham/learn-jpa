plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.7.20"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.7.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.google.guava:guava:31.0.1-jre")

    implementation("org.hibernate:hibernate-entitymanager:5.6.12.Final")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation("com.h2database:h2:2.1.214")
}

application {
    mainClass.set("me.chacham.learnjpa.AppKt")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
