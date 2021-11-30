plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation(group = "org.eclipse.jetty", name ="jetty-server", version="9.4.33.v20201020")
    implementation(group = "org.eclipse.jetty", name ="jetty-servlet", version="9.4.33.v20201020")
    implementation("javax.servlet:javax.servlet-api")
    implementation("org.flywaydb:flyway-core:6.1.4")
    implementation("org.postgresql:postgresql:42.2.9")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
