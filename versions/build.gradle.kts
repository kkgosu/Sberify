plugins {
    id("java-platform")
}

//App dependencies
val activity = "1.2.0-beta01"
val adapterDelegates = "4.3.0"
val appCompat = "1.2.0"
val cardView = "1.0.0"
val constraintlayout = "2.0.2"
val coordiantorLayout = "1.1.0"
val core = "1.3.2"
val coreCommon = "2.1.0"
val coroutines = "1.3.7"
val fragment = "1.3.0-beta01"
val glide = "4.11.0"
val glidePalette = "2.1.2"
val gson = "2.8.2"
val hilt = Versions.HILT
val hiltJetPack = "1.0.0-alpha01"
val jsoup = "1.10.1"
val lifecycle = "2.3.0-beta01"
val lottie = "3.3.0"
val material = "1.3.0-alpha03"
val navigation = "2.3.1"
val okhttp = "3.12.0"
val preference = "1.1.1"
val recyclerView = "1.1.0"
val retrofit = "2.6.2"
val room = "2.2.5"
val spotifyAuth = "1.2.2"
val swipeRefresh = "1.1.0"
val transition = "1.3.1"

// Testing dependencies
val coreTesting = "2.1.0"
val espresso = "3.3.0"
val hamcrest = "1.3"
val junit = "4.13"
val mockito = "2.25.0"
val mockitoKotlin = "2.2.0"
val testCore = "1.1.0"

dependencies {
    constraints {
        api("${Libs.ACTIVITY_KTX}:$activity")
        api("${Libs.ADAPTER_DELEGATES}:$adapterDelegates")
        api("${Libs.ADAPTER_DELEGATES_VIEW_BINDING}:$adapterDelegates")
        api("${Libs.ANDROIDX_HILT_COMPILER}:$hiltJetPack")
        api("${Libs.APPCOMPAT}:$appCompat")
        api("${Libs.ARCH_CORE_COMMON}:$core")
        api("${Libs.ARCH_TESTING}:$coreTesting")
        api("${Libs.ARCH_LIFECYCLE_EXTENSIONS}:$coreTesting")
        api("${Libs.CARDVIEW}:$cardView")
        api("${Libs.CONSTRAINT_LAYOUT}:$constraintlayout")
        api("${Libs.COORDINATOR_LAYOUT}:$coordiantorLayout")
        api("${Libs.CORE_KTX}:$core")
        api("${Libs.COROUTINES}:$coroutines")
        api("${Libs.ESPRESSO_CORE}:$espresso")
        api("${Libs.ESPRESSO_CONTRIB}:$espresso")
        api("${Libs.ESPRESSO_INTENTS}:$espresso")
        api("${Libs.FRAGMENT_KTX}:$fragment")
        api("${Libs.GLIDE}:$glide")
        api("${Libs.GLIDE_PALETTE}:$glidePalette")
        api("${Libs.GSON}:$gson")
        api("${Libs.HAMCREST}:$hamcrest")
        api("${Libs.HILT_ANDROID}:$hilt")
        api("${Libs.HILT_COMPILER}:$hilt")
        api("${Libs.HILT_COMMON}:$hilt")
        api("${Libs.HILT_VIEWMODEL}:$hiltJetPack")
        api("${Libs.JUNIT}:$junit")
        api("${Libs.JSOUP}:$jsoup")
        api("${Libs.EXT_JUNIT}:$junit")
        api("${Libs.KOTLIN_STDLIB}:${Versions.KOTLIN}")
        api("${Libs.LIFECYCLE_LIVE_DATA_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_COMMON}:$lifecycle")
        api("${Libs.LIFECYCLE_RUNTIME_KTX}:$lifecycle")
        api("${Libs.LIFECYCLE_VIEW_MODEL_SAVED_STATE}:$lifecycle")
        api("${Libs.LIFECYCLE_VIEW_MODEL_KTX}:$lifecycle")
        api("${Libs.LOTTIE}:$lottie")
        api("${Libs.MATERIAL}:$material")
        api("${Libs.MOCKITO_CORE}:$mockito")
        api("${Libs.MOCKITO_INLINE}:$mockito")
        api("${Libs.MOCKITO_KOTLIN}:$mockitoKotlin")
        api("${Libs.NAVIGATION_COMMON_KTX}:${Versions.NAVIGATION}")
        api("${Libs.NAVIGATION_FRAGMENT_KTX}:${Versions.NAVIGATION}")
        api("${Libs.NAVIGATION_RUNTIME_KTX}:${Versions.NAVIGATION}")
        api("${Libs.PREFERENCES}:$preference")
        api("${Libs.RECYCLER}:$recyclerView")
        api("${Libs.RETROFIT}:$retrofit")
        api("${Libs.RETROFIT_GSON}:$retrofit")
        api("${Libs.ROOM_KTX}:$room")
        api("${Libs.ROOM_RUNTIME}:$room")
        api("${Libs.ROOM_COMPILER}:$room")
        api("${Libs.ROOM_COMMON}:$room")
        api("${Libs.OKHTTP}:$okhttp")
        api("${Libs.SPOTIFY_AUTH}:$spotifyAuth")
        api("${Libs.SWIPE_REFRESH_LAYOUT}:$swipeRefresh")
        api("${Libs.TRANSITION}:$transition")
    }
}