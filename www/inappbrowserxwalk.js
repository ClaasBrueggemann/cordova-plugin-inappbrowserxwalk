/*global cordova, module*/

function InAppBrowserXwalk() {

}

var callbacks = new Array ();

InAppBrowserXwalk.prototype = {
    close: function () {
        cordova.exec(null, null, "InAppBrowserXwalk", "close", []);
    },
    addEventListener: function (eventname, func) {
        callbacks[eventname] = func;
    },
    removeEventListener: function (eventname) {
        callbacks[eventname] = undefined;
    },
    show: function () {
        cordova.exec(null, null, "InAppBrowserXwalk", "show", []);
    },
    hide: function () {
        cordova.exec(null, null, "InAppBrowserXwalk", "hide", []);
    }
}

var callback = function(event) {
    switch (event.type) {
        case 'loadstart':
            callbacks['loadstart'] !== undefined && callbacks['loadstart'](event);
            break;
        case 'loadstop':
            callbacks['loadstop'] !== undefined && callbacks['loadstop'](event);
            break;
        case 'loaderror':
            callbacks['loaderror'] !== undefined && callbacks['loaderror'](event);
            break;
        case 'exit':
            callbacks['exit'] != undefined && callbacks['exit']();
            break;
    }
}

module.exports = {
    open: function (url, options) {
        options = (options === undefined) ? "{}" : JSON.stringify(options);
        cordova.exec(callback, null, "InAppBrowserXwalk", "open", [url, options]);
        return new InAppBrowserXwalk();
    }
};
