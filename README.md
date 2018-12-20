# iOS, Android & Web Kotlin/Native boilerplate project

Sharing code between multiple platform is what every multi-plateform framework tries to strike the right balance between shared code and native components and performance is what everyone struggles with. The approach in this sample project is to have the logic driving the applications written in Kotlin and shared with both platforms and UI and platform specific behaviour (e.g. threading, networking, gps) are implemented with native API and language.

## Project Sutructure

* `android/src` ➡ Android specific code
* `core/src/androidMain` ➡ Android specific implementation of core methods
* `core/src/iosMain` ➡ iOS specific implementation of core methods
* `core/src/commonsMain` ➡ Multi-platform code
* `core/build/xcode-framrworks` ➡ Where the ios Framework resides
* `ios/src` ➡ iOS specific source code
* `web/src` - Web front-end and js specific source
* `wasm/src` ➡ Experimental WebAssembly implementation

### Build the Android application

Start Android Studio and open the root of this project. It'll include the `core` and the `android` project. You're ready to hit **build**.

### Buld the iOS application

Go to the `ios` folder. Run `pod install` to install dependancies. Open Xcode and open the `ios.xcworkspace`. You're ready to hit **build**.

## Buld the web application

You'll npm available on your machine. If you don't have it `brew install npm` on macOS.

To build it: `gradle :web:build` then, to run a local web server and try it `gradle :web:run` and connect your browser to `http://localhost:8080/`

Everything is copied into the `web/build/site/` folder. Changing the source requires to run `gradle :web:assemble` for the moment.

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

## A very imcomplete list of TODO

[ ] Take the `android` client to the same level as `ios` client.
[ ] Structure the `web` project like a proper pipeline that included typescript and dependancy manangement.
[ ] Add `livereload` support for the `web` project.
[ ] Implement the speed test in the `web` client.
[ ] Clean-up the `wasm` portion and place some marsheling example between the WebAssembly and Javascript.
[ ] Document how to add functionnality.
[ ] Extract this in a set of template and library that are usable by other people
 