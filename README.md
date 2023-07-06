
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
# Full Stack [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform) Template



## Set up the environment
you need the following:

* [Android Studio](https://developer.android.com/studio) and the [Kotlin Multiplatform Mobile plugin](https://plugins.jetbrains.com/plugin/14936-kotlin-multiplatform-mobile)
* [Intellij IDEA]() for the web development version
* 
## Project structure

This Full Stack compose Template includes 4 modules: `shared`, `backend`,   `frontend`, and `mobile`.


### `shared`

This is a Kotlin module that contains the logic common for web browsers, mobile devices, or the backend server, that is, the code you
share between platforms.

This `shared` module is also where you'll write your Compose Multiplatform code.
In `shared/src/commonMain/kotlin/App.kt`, you can find the shared root `@Composable` function for your app.

It uses Gradle as the build system. You can add dependencies and change settings in `shared/build.gradle.kts`.
The `shared` module builds into a JavaScript library, Java library, an Android library.

### `backend`

The backend module represents the Server side handling functionality of the Multiplatform Application, initially, it 
is configured to use the Ktor Asynchronous Kotlin framework, However, this can be switched and changed to any other framework like
Spring boot or Vertx. 
In the case of Compose Multiplatform. the backend module is configured to serve a single Page Application and hence, some 
task must be created to transfer build assets and configurations from the `jsWebApp` module and into the resources folder 
of the serverside module

### `mobile`

This is a Kotlin module that builds Mobile application. It uses Gradle as the build system.
The `androidApp` module depends on and uses the `shared` module as a regular Android library.
Also, IOS applications can be targetted, however, a mac is needed for the IOS configurations.

### `Front End Modules`
When building a multiplatform Application with compose multiplatform, there are 2 versions that are offered

(1) `ComposeHTML`: This module provides web dom elements for building front end application

(2)  `ComposeWeb`: This module provides a means of sharing ui across multiple platforms using web-canvas

### `Module setup versioning`
   The `jsWebApp` module is setup to use the `ComposeWeb` version while the `jsDOMApp` is configured to use 
   the `composeHTML`. You can choose either versions, in which case the other can be deleted.

It uses Gradle dependency build and
compiles the Compose Multiplatform Web framework into js, which then targets the browser. Also, since this 
is a multiplatform setup, the `jsWebApp` module depends on and uses the `shared` module as a regular js Library.

### `composeHTML`


## Run your application

### On Web browser

To run the application in the browser, either the `composeWebJs` 
or the `composeHTML` module should be run. 

Since both of these modules are Kotlin Multiplatform applications with
Kotlin/Js compiler, they contain the `jsBrowserRun` task, which can be used to target the browser.

You can also run Gradle tasks in the terminal:

* `./gradlew run` to run application
* `./gradlew package` to store native distribution into `build/compose/binaries`

### On Android

To run your application on an Android emulator:

1. Ensure you have an Android virtual device available.
   Otherwise, [create one](https://developer.android.com/studio/run/managing-avds#createavd).
2. In the list of run configurations, select `androidApp`.
3. Choose your virtual device and click **Run**:

    <img src="readme_images/run_on_android.png" height="60px"><br />      

    <img src="readme_images/android_app_running.png" height="300px">


### On Server

The  `backend` 
You can also run Gradle tasks in the terminal:
<details>
  <summary>When Serving Single Page Applications with Ktor some tasks must be configured</summary>

Due to the fact that the Ktor configuration for serving Single Page Applications
involves having the framework inside the resources folder, it is necessary to transfer the project build binaries from the
`frontend` module to the resources folder of the `ktorServer` module
</details>


* `./gradlew run` to run application
* `./gradlew package` to store native distribution into `build/compose/binaries`
