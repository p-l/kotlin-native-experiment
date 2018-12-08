# iOS & Android Kotlin/Native boilerplate project

Sharing code between multiple platform is what every multi-plateform framework
tries to do. Strking the right balance between shared code and native
components and performance is what everyone struggles with. The approach in
this sample project is to have the logic driving the applications is written
in Kotlin and shared with both platforms and UI and platform specific behaviour
(e.g. threading, networking, gps) are implemented with native API and language.

## Project Sutructure

`android/src`                : Android specific code
`core/src`                   : Shared code between each platform
`core/build/xcode-framrworks`: Where the ios Framework resides
`ios/src`                    : iOS specific source code

## Renaming the application