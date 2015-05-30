# cordova-plugin-inappbrowserxwalk

This plugin provides a web browser view, which is using the Crosswalk engine
to render pages.

##Requirements
This plugin requires Cordova build with Crosswalk.


## Installation

    $ cordova plugin add com.shoety.cordova.plugin.inappbrowserxwalk
    

## Example
```js
    var options = {
					toolbarColor: '#FFFFFF', // Background color of the toolbar in #RRGGBB
					toolbarHeight: '40',
					closeButtonText: '< Close',
					closeButtonSize: '25',
					closeButtonColor: '#000000',
				  };

    if( window.cordova && cordova.platformId === "android" ) {
		window.inAppBrowserXwalk.open("http://google.de", options);
	}
	else {
		window.open("http://shoety.de", "_blank");
	}
```

Options is an optional Parameter, leaving it out, opens the browser with standard settings.

