# cordova-plugin-inappbrowserxwalk

This plugin provides a web browser view, which is using the Crosswalk engine
to render pages.

##Requirements
This plugin requires Cordova build with Crosswalk.


## Installation

    $ cordova plugin add https://github.com/Shoety/cordova-plugin-inappbrowserxwalk

Or if you are using cordova cli version 5.0.0 or higher then you can fetch it from npm :
https://www.npmjs.com/package/com.shoety.cordova.plugin.inappbrowserxwalk

## Methods

### open
```js
	var browser = window.inAppBrowserXwalk.open(url, options);
```
Opens a new Crosswalk Webview in a dialog. The options parameter is optional, possible parameters
are demonstrated under Examples. If you dont pass options, the browser will open with default options.

### close
```js
	browser.close()
```
Closes the browser and destroys dialog and webview.

### hide
```js
	browser.hide()
```
Hides the browser but does not destroy it. You can call the show() function to make the browser
visible again.

### show
```js
	browser.show()
```
Will make a hidden browser visible. Use this after browser.hide() or if the browser was opened
with the openHidden : true option.

### addEventListener
```js
	browser.addEventListener(eventname, callback)
```
Adds a listener for an event from the crosswalk browser.
Possible events: loadstart, loadstop, exit

### removeEventListener
```js
	browser.removeEventListener(eventname)
```
Removes the eventlistener for an event.



## Examples
```js
	var options = {
    				toolbarColor: '#FFFFFF', // Background color of the toolbar in #RRGGBB
    				toolbarHeight: '40',
    				closeButtonText: '< Close',
    				closeButtonSize: '25',
    				closeButtonColor: '#000000',
                    openHidden: false
		          };

    if( window.cordova && cordova.platformId === "android" ) {
		var browser = window.inAppBrowserXwalk.open("http://google.de", options);

		browser.addEventListener("loadstart", function ( url ) {
            console.log(url);
        });

        browser.addEventListener("loadstop", function ( url ) {
            console.log(url);
        });

        browser.addEventListener("exit", function () {
            console.log("browser closed");
        });
	}
	else {
		window.open("http://shoety.de", "_blank");
	}
```

Options is an optional Parameter, leaving it out, opens the browser with standard settings.
