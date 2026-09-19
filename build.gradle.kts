plugins {
    id("org.jetbrains.kotlin.jvm") version "2.4.20"
    id("com.google.devtools.ksp") version "2.3.3"
    id("io.micronaut.application") version "5.0.2"
    id("io.micronaut.aot") version "5.0.2"
}

version = "0.1"
group = "com.example"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

dependencies {
    ksp("io.micronaut:micronaut-http-validation")
    ksp("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("tools.jackson.module:jackson-module-kotlin")
    testImplementation("io.micronaut:micronaut-http-client")
}


application {
    mainClass = "com.example.ApplicationKt"
}
java {
    sourceCompatibility = JavaVersion.toVersion("25")
}


graalvmNative.toolchainDetection = false

micronaut {
    runtime("netty")
    testRuntime("junit5")
    coreVersion.set("5.2.2")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading = false
        convertYamlToJava = false
        precomputeOperations = true
        cacheEnvironment = true
        optimizeClassLoading = true
        deduceEnvironment = true
        optimizeNetty = true
        replaceLogbackXml = true
    }
}


tasks.named<io.micronaut.gradle.docker.NativeImageDockerfile>("dockerfileNative") {
    jdkVersion = "21"
}


