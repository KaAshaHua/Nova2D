plugins {
    id("nova2d.java-app")
}

val os = System.getProperty("os.name").lowercase()
val arch = System.getProperty("os.arch").lowercase()
val isArm = arch == "aarch64" || arch == "arm64"

val lwjglNatives = when {
    "win" in os -> if (isArm) "natives-windows-arm64" else "natives-windows"
    "mac" in os -> if (isArm) "natives-macos-arm64" else "natives-macos"
    "linux" in os -> if (isArm) "natives-linux-arm64" else "natives-linux"
    else -> throw GradleException("Hệ điều hành chưa hỗ trợ: $os ($arch)")
}

val lwjglModules = listOf(
    "lwjgl",
    "lwjgl-freetype",
    "lwjgl-glfw",
    "lwjgl-openal",
    "lwjgl-opengl",
    "lwjgl-stb",
)

dependencies {
    implementation(project(":nova2d-util"))
    implementation(project(":nova2d-engine"))
    implementation(project(":nova2d-editor"))

    implementation(platform(libs.lwjgl.bom))
    lwjglModules.forEach { module ->
        runtimeOnly("org.lwjgl:$module::$lwjglNatives")
    }
}

application {
    mainClass = "nova2d.launcher.MainLauncher" 

    val jvmArgs = mutableListOf("--enable-native-access=ALL-UNNAMED")

    if ("mac" in os && providers.gradleProperty("startOnFirstThread").isPresent) {
        jvmArgs += "-XstartOnFirstThread"
    }
    applicationDefaultJvmArgs = jvmArgs
}