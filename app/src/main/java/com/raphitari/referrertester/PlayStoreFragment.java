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
import android.widget.EditText;


/**
 * Created by jim on 4/5/15.
 */
public class PlayStoreFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_play_store, container, false);
        final EditText package_name = (EditText) rootView.findViewById(R.id.editPlayPackageName);
        final EditText source = (EditText) rootView.findViewById(R.id.editPlaySource);
        final EditText medium = (EditText) rootView.findViewById(R.id.editPlayMedium);
        final EditText campaign = (EditText) rootView.findViewById(R.id.editPlayCampaign);
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
                Uri uri = Uri.parse("market://details?id=" + package_name.getText() + "&referrer=utm_source%3D" + source.getText() + "%26utm_medium%3D" + medium.getText() + "%26utm_campaign%3D" + campaign.getText());
                Log.d("Jim", uri.toString());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
