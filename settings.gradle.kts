rootProject.name = "Sberify"

include(":app")

apply(from = "Feature/Spotify/modules.gradle.kts")
apply(from = "Feature/Genius/modules.gradle.kts")
apply(from = "Core/modules.gradle.kts")
