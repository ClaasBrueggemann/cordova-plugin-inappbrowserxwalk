package com.shoety.plugin;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import android.view.View;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Typeface;
import android.widget.Toast;
import android.app.Activity;

import org.xwalk.core.XWalkView;

public class BrowserDialog extends Dialog {

    public BrowserDialog(Context context, int theme) {
        super(context, theme);
    }
    
}
