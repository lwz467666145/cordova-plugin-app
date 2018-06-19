# cordova-plugin-app
Install Application for Android

# Install
cordova plugin add https://github.com/lwz467666145/cordova-plugin-app.git

# Use

### installApp 安装应用
仅用于 Android 平台
```javascript
// name - 文件名（文件需下载至 Environment.DIRECTORY_DOWNLOADS 目录下才可安装）
navigator.app.installApp(name, function () {
    // 安装失败回调方法
});
```

### openApp 打开应用
```javascript
// package - 应用包名，适用于 Android 平台
// scheme  - 应用访问协议，适用于 iOS 平台
navigator.app.openApp(package, scheme, function () {
    // 打开失败回调方法
});
```

### hasApp 验证是否安装了应用
```javascript
// package - 应用包名，适用于 Android 平台
// scheme  - 应用访问协议，适用于 iOS 平台
navigator.app.hasApp(package, scheme, function (flag) {
    // 验证成功回调方法
    // flag - true: 已安装; false: 未安装
});
```
