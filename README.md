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

`TBC`

## Working with Kotlin/Native

### Swift -> Kotlin objects

Any swift class that interacts with Kotlin core needs to implement `NSObject`.
Without this, you'll run into `toKotlin` method errors at runtime. The error
will look something like what's bellow:

```
*** NSForwarding: warning: object 0x600001ee5b90 of class 'ios.HttpClient' does not implement methodSignatureForSelector: -- trouble ahead
Unrecognized selector -[app.SwiftClass toKotlin:]
```