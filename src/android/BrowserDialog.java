package com.example.plugin.InAppBrowserXwalk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import android.widget.TextView;
import android.view.View;

public class BrowserDialog extends Dialog {

    public BrowserDialog(Context context, int theme, TextView closeButton) {
        super(context, theme);
        final BrowserDialog dialog = this;
        closeButton.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 dialog.dismiss();
             }
         });
    }

}
