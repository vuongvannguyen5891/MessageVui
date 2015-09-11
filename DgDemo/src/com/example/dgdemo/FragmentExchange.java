package com.example.dgdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentExchange extends Fragment {
	private Context mContext;
	private int id;
	private static FragmentExchange instance;
	private static Account account = new Account();

	public static FragmentExchange getInstance(Account account1) {
		if (instance == null) {
			instance = new FragmentExchange();
		}
		account = account1;
		Bundle bundle = new Bundle();
		bundle.putSerializable("data_acc", account);
		if (!instance.isVisible()) {
			instance.setArguments(bundle);
		}
		return instance;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mContext = getActivity();
		View view = inflater.inflate(R.layout.activity_exchange, null);

		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		String idShare = sharedPreferences.getString("id", "0");
		id = Integer.parseInt(idShare);

		return view;

	}

}
