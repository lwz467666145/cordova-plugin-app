var exec = require('cordova/exec');

exports.installApp = function (name, error) {
    if (device.platform === 'Android')
        exec(null, error, 'App', 'installApp', [name]);
};

exports.openApp = function (package, scheme, error) {
    if (device.platform === 'Android')
        exec(null, error, 'App', 'openApp', [package]);
    else
        exec(null, error, 'App', 'openApp', [scheme]);
};
               
exports.hasApp = function (package, scheme, success) {
    if (device.platform === 'Android')
        exec(success, null, 'App', 'hasApp', [package]);
    else
        exec(success, null, 'App', 'hasApp', [scheme]);
};

exports.exitApp = function () {
    exec(null, null, 'App', 'exitApp', []);
};