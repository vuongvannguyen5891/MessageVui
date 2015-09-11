package com.example.dgdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentListCard extends Fragment {

	private TextView txtDateLine;
	static MainActivity menuCardActivity;
	List<Object[]> alphabets = new ArrayList<Object[]>();
	// public static ItemCardMenuAdapter menuAdapter;

	private LinearLayout llIndex;
	private LayoutInflater inflater;
	private ArrayList<String> lstSection = new ArrayList<String>();
	private boolean isCheck = false;

	public FragmentListCard(MainActivity menuCardActivity) {
		this.menuCardActivity = menuCardActivity;
	}

	public void isLongClicked(boolean b) {
		this.isCheck = b;
	}

	private static FragmentListCard instance;

	public static FragmentListCard getInstance() {
		if (instance == null) {
			instance = new FragmentListCard(menuCardActivity);
		}
		return instance;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_listcard, null);

		this.inflater = LayoutInflater.from(getActivity());

		return view;

	}

}
