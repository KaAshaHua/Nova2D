plugins {
    id("nova2d.java-lib")
    alias(libs.plugins.javafx)
}

val javafxVersion = libs.versions.javafx.get()

javafx {
    version = javafxVersion
    modules("javafx.controls", "javafx.fxml")
}

dependencies {
    api(project(":nova2d-util"))
    api(project(":nova2d-engine"))
    // implementation("org.openjfx:javafx-controls:27")
    // implementation("org.openjfx:javafx-fxml:27")
}