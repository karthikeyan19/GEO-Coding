package com.karthik.geo;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        String result = null;
        TextView location = (TextView) findViewById(R.id.textview_location);

        List<Address> addressList = null;
        try {
            addressList = geocoder.getFromLocation(
                    9.524678699999999, 77.85530889999995, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addressList != null && addressList.size() > 0) {
                Address address = addressList.get(0);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    sb.append(address.getAddressLine(i)).append("\n");
                }
                sb.append(address.getLocality()).append("\n");
                sb.append(address.getPostalCode()).append("\n");
                sb.append(address.getCountryName());
                result = sb.toString();
                location.setText(result);
            }else{

            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
        }

    }
}
