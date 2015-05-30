/*global cordova, module*/

module.exports = {
    open: function (url, options) {
        options = (options === undefined) ? "{}" : JSON.stringify(options);
        cordova.exec(null, null, "InAppBrowserXwalk", url, [options]);
    }
};
