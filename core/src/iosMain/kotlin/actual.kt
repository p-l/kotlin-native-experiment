package com.sample.core.shared

import platform.UIKit.UIDevice

actual fun platformName(): String {
  var platformString = UIDevice.currentDevice.systemName() +
          " " +
          UIDevice.currentDevice.systemVersion

  return platformString
}



//https://stackoverflow.com/a/24505884