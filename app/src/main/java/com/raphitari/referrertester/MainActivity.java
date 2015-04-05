package com.raphitari.referrertester;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.adwave.referrertester.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button send_referrer = (Button) findViewById(R.id.send_referrer);

        send_referrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.android.vending.INSTALL_REFERRER");
                intent.setComponent(new ComponentName("adwave.coreapi", "adwave.coreapilibrary.ReferrerReceiver"));
                intent.putExtra("referrer", "utm_source%3Dtest_source2%26utm_medium%3Dtest_medium2%26utm_campaign%3Dtest_campaign2");
                sendBroadcast(intent);
                Toast.makeText(getApplicationContext(), "Sent broadcast!", Toast.LENGTH_SHORT).show();
            }
        });

        Button play_store = (Button) findViewById(R.id.play_store);

        play_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri.Builder builder = new Uri.Builder();
//                builder.scheme("market")
//                    .authority("details")
//                    .appendQueryParameter("id", "com.adwave.soundboard")
//                    .appendQueryParameter("referrer", "utm_source=test_source_3&utm_medium=test_medium_3&utm_campaign=test_campaign_3");
//                Uri uri = builder.build();
                Uri uri = Uri.parse("https://145066.api-05.com/serve?action=click&publisher_id=145066&site_id=92396&ref_id=[[Sub-Id]]&device_id=36ED7822CC4A3108&android_id=[[AndroidId]]&mac_address=[[MacAddress]]&mac_address_md5=[[Md5Mac]]&mac_address_sha1=[[Sha1Mac]]&device_ip=[[IP]]&country_code=[[CountryCode]]&google_aid=[[GAID]]&sub_site=[[AppId]]&sub_campaign=FyberMAT&sub_placement=cpi");
                Log.d("Jim", uri.toString());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
