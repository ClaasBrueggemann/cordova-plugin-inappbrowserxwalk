# cordova-plugin-inappbrowserxwalk

This plugin provides a web browser view, which is using the Crosswalk engine
to render pages.

##Requirements
This plugin requires Cordova build with Crosswalk.


## Installation

    $ cordova plugin add com.shoety.cordova.plugin.inappbrowserxwalk
    
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
Closes the browser.

### addEventListener
```js
	browser.addEventListener(eventname, callback)
```
Adds a listener for an event from the crosswalk browser.
Possible events: loadstart, loadstop

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
			};

    if( window.cordova && cordova.platformId === "android" ) {
		var browser = window.inAppBrowserXwalk.open("http://google.de", options);
		
		browser.addEventListener("loadstart", function ( url ) {
	            console.log(url);
	        });
	        
	        browser.addEventListener("loadstop", function ( url ) {
	            console.log(url);
	        });
	}
	else {
		window.open("http://shoety.de", "_blank");
	}
```

Options is an optional Parameter, leaving it out, opens the browser with standard settings.

