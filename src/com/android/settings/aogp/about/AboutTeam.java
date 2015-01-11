package com.android.settings.aogp.about;

import com.android.settings.R;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AboutTeam extends PreferenceFragment implements OnPreferenceClickListener {

	private String KEY_K2WL = "key_k2wl";
	private String KEY_TRACH = "key_trach";
	private String KEY_JACK = "key_jack";
	private String KEY_AS = "key_ashishs";
	private String KEY_AB = "key_ashishb";
	private String KEY_RUTVIK = "key_rutvik";
	private String KEY_NITIN = "key_nitin";

	private Preference mk2wl, 
	mtrach, 
	mjack,
	mrutvik,
	mashishs,
	mashishb,
	mnitin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.aogp_team);

		mk2wl = (Preference) findPreference(KEY_K2WL);
		mtrach = (Preference) findPreference(KEY_TRACH);
		mjack = (Preference) findPreference(KEY_JACK);
		mashishs = (Preference) findPreference(KEY_AS);
		mashishb = (Preference) findPreference(KEY_AB);
		mrutvik = (Preference) findPreference(KEY_RUTVIK);
		mnitin = (Preference) findPreference(KEY_NITIN);

        mk2wl.setIcon(R.drawable.k2wl)
		mtrach.setIcon(R.drawable.trach);
		mjack.setIcon(R.drawable.jack);
		mashishs.setIcon(R.drawable.ashishshekar);
		mashishb.setIcon(R.drawable.ashishbansal);
		mrutvik.setIcon(R.drawable.rutvik);
		mnitin.setIcon(R.drawable.nitin);

		mk2wl.setOnPreferenceClickListener(this);
		mtrach.setOnPreferenceClickListener(this);
		mjack.setOnPreferenceClickListener(this);
		mashishs.setOnPreferenceClickListener(this);
		mashishb.setOnPreferenceClickListener(this);
		mrutvik.setOnPreferenceClickListener(this);
		mnitin.setOnPreferenceClickListener(this);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.team_layout, container,false);
		ListView listView = (ListView) v.findViewById(android.R.id.list);
		View header = inflater.inflate(R.layout.header, null, false);
		listView.addHeaderView(header);
		return v;
	}

	@Override
	public boolean onPreferenceClick(Preference pref) {
		// TODO Auto-generated method stub
		String url = "";
		if(pref == mk2wl) {
			url = "https://plus.google.com/u/0/107619935962076164449/posts";
		}
		if(pref == mtrach) {
			url = "https://plus.google.com/u/0/+TrippyRex18/posts";
		}
		if(pref == mjack) {
			url = "https://plus.google.com/u/0/108711103787588822407/posts";
		}
		if(pref == mashishs) {
			url = "https://plus.google.com/u/0/+AshishShekar/posts";
		}
		if(pref == mashishb) {
			url = "https://plus.google.com/u/0/+AshishBansal77/posts";
		}
		if(pref == mrutvik) {
			url = "https://plus.google.com/u/0/+RutvikRajagopal/posts";
		}
		if(pref == mnitin) {
			url = "https://plus.google.com/u/0/106851499829540192411/posts";
		}
		Uri uri = Uri.parse(url);
		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
		startActivity(intent);

		return false;
	}



}
