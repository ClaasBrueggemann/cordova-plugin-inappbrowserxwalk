package com.example.plugin.InAppBrowserXwalk;

import com.example.plugin.InAppBrowserXwalk.BrowserDialog;

import android.content.res.Resources;
import org.apache.cordova.*;
import org.json.JSONArray;
import org.xwalk.core.XWalkView;
import org.json.JSONObject;
import org.json.JSONException;

import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Typeface;
import android.widget.Toast;

public class InAppBrowserXwalk extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        final String url = action;

        String toolbarColor = "#FFFFFF";
        int toolbarHeight = 80;
        String closeButtonText = "< Close";
        int closeButtonSize = 25;
        String closeButtonColor = "#000000";

        if(data != null && data.length() > 0) {
            JSONObject options = new JSONObject(data.getString(0));

            if(!options.isNull("toolbarColor")) {
                toolbarColor = options.getString("toolbarColor");
            }
            if(!options.isNull("toolbarHeight")) {
                toolbarHeight = options.getInt("toolbarHeight");
            }
            if(!options.isNull("closeButtonText")) {
                closeButtonText = options.getString("closeButtonText");
            }
            if(!options.isNull("closeButtonSize")) {
                closeButtonSize = options.getInt("closeButtonSize");
            }
            if(!options.isNull("closeButtonColor")) {
                closeButtonColor = options.getString("closeButtonColor");
            }
        }

        final String _toolbarColor = toolbarColor;
        final int _toolbarHeight = toolbarHeight;
        final String _closeButtonText = closeButtonText;
        final int _closeButtonSize =  closeButtonSize;
        final String _closeButtonColor = closeButtonColor;


        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                XWalkView xWalkWebView = new XWalkView(cordova.getActivity(), cordova.getActivity());
                xWalkWebView.load(url, "");

                LinearLayout main = new LinearLayout(cordova.getActivity());
                main.setOrientation(LinearLayout.VERTICAL);

                RelativeLayout toolbar = new RelativeLayout(cordova.getActivity());
                toolbar.setBackgroundColor(android.graphics.Color.parseColor(_toolbarColor));
                toolbar.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, _toolbarHeight));
                toolbar.setPadding(5, 5, 5, 5);

                TextView closeButton = new TextView(cordova.getActivity());
                closeButton.setText(_closeButtonText);
                closeButton.setTextSize(_closeButtonSize);
                closeButton.setTextColor(android.graphics.Color.parseColor(_closeButtonColor));
                closeButton.setTypeface(Typeface.create("sans-serif-thin", Typeface.NORMAL));
                toolbar.addView(closeButton);

                main.addView(toolbar);
                main.addView(xWalkWebView);

                BrowserDialog dialog = new BrowserDialog(cordova.getActivity(), android.R.style.Theme_NoTitleBar, closeButton);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().getAttributes().windowAnimations = android.R.style.Animation_Dialog;
                dialog.setCancelable(true);
                LayoutParams layoutParams = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
                dialog.addContentView(main, layoutParams);
                dialog.show();
            }
        });
        return true;
    }
}
