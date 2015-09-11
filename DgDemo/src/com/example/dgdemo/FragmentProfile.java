package com.example.dgdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentProfile extends Fragment {

	private String TAG = "FragmentProfile";

	private static FragmentProfile instant;
	private View view;


	public static FragmentProfile getInstant() {
		if (instant == null) {
			instant = new FragmentProfile();
		}
		Bundle bundle = new Bundle();
		if (!instant.isVisible()) {
			instant.setArguments(bundle);
		}
		return instant;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.activity_profile, null);
		return view;
	}

}
