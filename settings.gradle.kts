rootProject.name = "Sberify"

include(":app")

apply(from = "Feature/modules.gradle.kts")
apply(from = "Core/modules.gradle.kts")
apply(from = "Screen/modules.gradle.kts")
