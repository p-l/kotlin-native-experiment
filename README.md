# iOS & Android Kotlin/Native boilerplate project

Sharing code between multiple platform is what every multi-plateform framework tries to do. Strking the right balance between shared code and native components and performance is what everyone struggles with. The approach in this sample project is to have the logic driving the applications is written in Kotlin and shared with both platforms and UI and platform specific behaviour (e.g. threading, networking, gps) are implemented with native API and language.

## Project Sutructure

`android/src`                : Android specific code
`core/src`                   : Shared code between each platform
`core/build/xcode-framrworks`: Where the ios Framework resides
`ios/src`                    : iOS specific source code

### Build the Android application

Start Android Studio and open the root of this project. It'll include the `core` and the `android` project. You're ready to hit **build**.

### Buld the iOS application

Go to the `ios` folder. Run `pod install` to install dependancies. Open Xcode and open the `ios.xcworkspace`. You're ready to hit **build**.

## Working with Kotlin/Native

### Debuging Kotlin code within iOS project

You'll need [AppCode **2018.2**](https://www.jetbrains.com/objc/download/previous.html) not the current 2018.3 as the  [Kotlin/Native plugin](https://plugins.jetbrains.com/plugin/10619-kotlin-native-for-appcode) isn't compatible with 2018.3 at the moment of this writing (2018-12-09).

If you have the proper version of AppCode and the Kotlin/Native plugin you can place a breakpoint like in any Swift class.

### Swift -> Kotlin objects

Any swift class that interacts with Kotlin core needs to implement `NSObject`. Without this, you'll run into `toKotlin` method errors at runtime. The error will look something like what's bellow:

```
*** NSForwarding: warning: object 0x600001ee5b90 of class 'ios.HttpClient' does not implement methodSignatureForSelector: -- trouble ahead
Unrecognized selector -[app.SwiftClass toKotlin:]
```

## Renaming the application

`TBC`