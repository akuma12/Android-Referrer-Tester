package com.raphitari.referrertester;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by jim on 4/5/15.
 */
public class PlayStoreFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_play_store, container, false);

        Button play_store = (Button) rootView.findViewById(R.id.play_store);

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

        return rootView;
    }
}
