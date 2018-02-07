package com.chinact.mobile.plugin.app;

import java.io.File;

import org.apache.cordova.BuildHelper;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

public class App extends CordovaPlugin {

    private static Activity cordovaActivity;
    private String applicationId;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        cordovaActivity = cordova.getActivity();
    }

    @Override
    public boolean execute(final String action, final JSONArray data, final CallbackContext callbackContext) throws JSONException {
        this.applicationId = (String) BuildHelper.getBuildConfigValue(cordova.getActivity(), "APPLICATION_ID");
        this.applicationId = preferences.getString("applicationId", this.applicationId);
        if ("installApp".equals(action)) {
            String name = data.getString(0);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Uri contentUri = FileProvider.getUriForFile(cordovaActivity, applicationId + ".provider", new File(cordovaActivity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), name));
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
            } else
                intent.setDataAndType(Uri.fromFile(new File(cordovaActivity.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), name)), "application/vnd.android.package-archive");
            cordovaActivity.startActivity(intent); 
        }
        return true;
    }

}