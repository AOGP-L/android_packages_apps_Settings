/*
 * Copyright (C) 2014 The Android Open Grand Project
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

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.ListPreference;
import android.preference.SwitchPreference;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import java.util.List;
import java.util.ArrayList;

public class AOGPMisc extends SettingsPreferenceFragment {
	private static final String TAG = "AOGP Misc";		 
	
	/** If there is no setting in the provider, use this. */		 
    private static final String DISABLE_IMMERSIVE_MESSAGE = "disable_immersive_message";
    
    private final Configuration mCurConfig = new Configuration();
    private CheckBoxPreference mDisableIM;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         final ContentResolver resolver = activity.getContentResolver();

        addPreferencesFromResource(R.xml.aogp_misc);
        
    PreferenceScreen prefSet = getPreferenceScreen();    
    
    mDisableIM = (CheckBoxPreference) findPreference(DISABLE_IMMERSIVE_MESSAGE);
    mDisableIM.setChecked((Settings.System.getInt(resolver,
            Settings.System.DISABLE_IMMERSIVE_MESSAGE, 0) == 1));
            
    }
    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if  (preference == mDisableIM) {
            boolean checked = ((CheckBoxPreference)preference).isChecked();
            Settings.System.putInt(getActivity().getContentResolver(),
                    Settings.System.DISABLE_IMMERSIVE_MESSAGE, checked ? 1:0);
            return true;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }            
}
