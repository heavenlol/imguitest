plugins {
    id("fabric-loom") version "1.17-SNAPSHOT"
    java
}

version = property("mod.version") as String
group = property("mod.group") as String

base.archivesName.set(property("mod.id") as String)

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
    maven("https://maven.spair.dev/releases")
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings(loom.layered {})
    modImplementation("net.fabricmc:fabric-loader:${property("fabric_loader_version")}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_api_version")}")
    include(implementation("io.github.spair:imgui-java-binding:${property("imgui_version")}")!!)
    include(implementation("io.github.spair:imgui-java-natives-linux:${property("imgui_version")}")!!)
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("mod_id", property("mod.id"))
    inputs.property("mod_name", property("mod.name"))
    inputs.property("fabric_loader_version", property("fabric_loader_version"))
    filteringCharset = "UTF-8"
    filesMatching("fabric.mod.json") {
        expand(
            "version" to project.version,
            "mod_id" to property("mod.id"),
            "mod_name" to property("mod.name"),
            "fabric_loader_version" to property("fabric_loader_version")
        )
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(25)
}

tasks.jar {
    from("LICENSE")
}
