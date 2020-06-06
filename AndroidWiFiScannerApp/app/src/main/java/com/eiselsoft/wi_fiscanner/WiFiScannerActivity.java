package com.eiselsoft.wi_fiscanner;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Iterator;
import java.util.List;

public class WiFiScannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_scanner);
    }

    // Scan Results:
    // BSSID: 68:7f:74:cb:e2:38
    // SSID: yourareadildo
    // Frequency: 2412
    // Level: 40
    // Capabilities: [WPA2-PSK-CCMP][WPS]

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public void onStartScanClicked(final View view) {

        int PERMISSION_ALL = 1;

        final String[] PERMISSIONS = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }

        final WifiManager wifi = (WifiManager) getSystemService(WifiManager.class);
        final EditText resultsBox = (EditText) findViewById(R.id.txtResults);
        resultsBox.setText("");

        //System.out.println("Wi-Fi Enabled: " + wifi.isWifiEnabled());

        final List<ScanResult> scanResults = wifi.getScanResults();
        final Iterator<ScanResult> itr = scanResults.iterator();

        while (itr.hasNext()) {

            final ScanResult cur = itr.next();

            final String bssid  = cur.BSSID,
                         ssid = cur.SSID,
                         capabilities = cur.capabilities;

            final int frequency = cur.frequency,
                      level = cur.level;

            final StringBuilder sb = new StringBuilder();

            System.out.print(sb.toString());

            sb.append("BSSID:"  + bssid + "\n");
            sb.append("SSID:"  + ssid + "\n");
            sb.append("Frequency:"  + frequency + "\n");
            sb.append("Level:"  + level + "\n");
            sb.append("Capabilities:"  + capabilities + "\n\n");

            resultsBox.setText(resultsBox.getText() + sb.toString());
        }

    }

}
