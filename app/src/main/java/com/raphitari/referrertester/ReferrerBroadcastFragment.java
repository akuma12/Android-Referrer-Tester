package com.raphitari.referrertester;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jim on 4/5/15.
 */
public class ReferrerBroadcastFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_referrer_broadcast, container, false);

        Button send_referrer = (Button) rootView.findViewById(R.id.send_referrer);
        final EditText package_name = (EditText) rootView.findViewById(R.id.editReferrerPackageName);
        final EditText source = (EditText) rootView.findViewById(R.id.editReferrerSource);
        final EditText medium = (EditText) rootView.findViewById(R.id.editReferrerMedium);
        final EditText campaign = (EditText) rootView.findViewById(R.id.editReferrerCampaign);

        send_referrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageName = package_name.getText().toString();
                Intent intent = new Intent("com.android.vending.INSTALL_REFERRER");
                intent.setComponent(new ComponentName(packageName, "adwave.coreapilibrary.ReferrerReceiver"));
                intent.putExtra("referrer", "utm_source%3D" + source.getText() + "%26utm_medium%3D" + medium.getText() + "%26utm_campaign%3D" + campaign.getText());
                getActivity().sendBroadcast(intent);
                Toast.makeText(getActivity().getApplicationContext(), "Sent broadcast!", Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }
}
