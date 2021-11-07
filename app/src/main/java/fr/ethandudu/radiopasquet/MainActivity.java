package fr.ethandudu.radiopasquet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PowerManager;
import android.service.media.MediaBrowserService;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView myWebView = (WebView) findViewById(R.id.webview);

        //WebView
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.loadUrl("https://radiopasquet.tk/public/radio_pasquet");
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setBackgroundColor(Color.parseColor("#1e88e5"));

        //Anti veille CPU
        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "radiopasquet::Wakelock");
        wakeLock.acquire();

        //myWebView.loadUrl("https://radiopasquet.tk/public/radio_pasquet");
        //WebSettings webSettings = myWebView.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        //myWebView.setBackgroundColor(Color.parseColor("#1e88e5"));
        }
    }
