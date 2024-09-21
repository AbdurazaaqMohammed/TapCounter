package io.github.abdurazaaqmohammed.TapCounter;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final boolean supportsActionBar = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
        WebView w = findViewById(R.id.web);
        WebSettings settings = w.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        ActionBar ab;
        if(supportsActionBar && (ab = getActionBar()) != null) ab.hide();

        w.loadUrl("file:///android_asset/tapcounter.html");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(getFilesDir().getPath());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
                settings.setDomStorageEnabled(true);
                if (supportsActionBar) {
                    w.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                }
            }
        }
    }
}
