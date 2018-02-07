var exec = require('cordova/exec');

exports.installApp = function (name, success, error) {
    exec(success, error, 'App', 'installApp', [name]);
};
