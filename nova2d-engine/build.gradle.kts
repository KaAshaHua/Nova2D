plugins {
    id("nova2d.java-lib")
}

dependencies {
    api(project(":nova2d-util"))
    api(libs.joml)

    implementation(platform(libs.lwjgl.bom))
    implementation(libs.lwjgl.core)
    implementation(libs.lwjgl.freetype)
    implementation(libs.lwjgl.glfw)
    implementation(libs.lwjgl.openal)
    implementation(libs.lwjgl.opengl)
    implementation(libs.lwjgl.stb)

    implementation(libs.jackson.databind)
}