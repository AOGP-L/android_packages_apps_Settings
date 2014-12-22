/*
 * Copyright (C) 2014 The AOGP Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.aogp;

import android.widget.Toast;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.R;
import android.provider.Settings;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.ListPreference;
import android.preference.PreferenceScreen;

import java.util.ArrayList;
import java.util.List;

public class AOGPSettings extends SettingsPreferenceFragment implements 
         Preference.OnPreferenceChangeListener, OnPreferenceClickListener {
	private static final String TAG = "AOGPSettings";
	
	private static final String KEY_TOAST_ANIMATION = "toast_animation";
	
	private ListPreference mToastAnimation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.aogp_settings);

     PreferenceScreen prefSet = getPreferenceScreen();

     mToastAnimation = (ListPreference) prefSet.findPreference(KEY_TOAST_ANIMATION);
     mToastAnimation.setSummary(mToastAnimation.getEntry());
     int CurrentToastAnimation = Settings.System.getInt(
     getContentResolver(),Settings.System.TOAST_ANIMATION, 1);
     mToastAnimation.setValueIndex(CurrentToastAnimation);
     mToastAnimation.setOnPreferenceChangeListener(this);
     
     }
           
      @Override
      public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
           // If we didn't handle it, let preferences handle it.
           return super.onPreferenceTreeClick(preferenceScreen, preference);
      }
      
      @Override
      public boolean onPreferenceChange(Preference preference, Object objValue) {
          final String key = preference.getKey();
          if (KEY_TOAST_ANIMATION.equals(key)) {
              int index = mToastAnimation.findIndexOfValue((String) objValue);
              Settings.System.putString(getContentResolver(),
                      Settings.System.TOAST_ANIMATION, (String) objValue);
              mToastAnimation.setSummary(mToastAnimation.getEntries()[index]);
              Toast.makeText(getActivity(), "Toast animation test!!!",
              Toast.LENGTH_SHORT).show();
              return true;
		  }
		  return false;
	  }
}
