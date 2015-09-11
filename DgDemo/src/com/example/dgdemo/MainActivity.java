package com.example.dgdemo;

import java.util.Date;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	private Context mContext;
	private boolean isSelected = false;
	// private ListView lvMenu;
	private LinearLayout lldrawer, btMenu;
	private TextView tvTitle;
	private PopupWindow mPopupMenu;
	private ImageButton mMenuRight, mMenuSearch;
	private TextView btnProfiles, btnSetting, btnExchange, btnSelectCard;
	public static LinearLayout btnSelectall;
	public static TextView txtSelectall;
	private ImageView btnCapture;
	private View llActionBar;
	private ImageView btnCloseSearch;
	private RelativeLayout llMenuBarMain, rlMenuSelect;
	private ListView listMenu;
	private String[] navMenuTitles;
	private LinearLayout llViewSearch;
	private EditText editTextSearch;
	private FragmentListCard mFragmentListCard = new FragmentListCard(this);
	private FragmentProfile mFragmentProfile = new FragmentProfile();
	private TypedArray navMenuIcons;
	private Menu menu;
	private DrawerLayout drawerLayout;
	private static Uri cameraPicUri = null;
	private static Date dateCameraIntentStarted = null;
	private final static int REQUEST_CODE_MAKE_PHOTO = 0;

	private final static int REQUEST_CODE_PICK_PHOTO = 1;
	private final static int REQUEST_CODE_CROP_PHOTO = 2;

	protected final static int REQUEST_CODE_OCR = 3;
	private final static int REQUEST_CODE_LOAD_PHOTO = 4;

	public final static String EXTRA_NATIVE_PIX = "pix_pointer";
	public final static String EXTRA_IMAGE_URI = "image_uri";
	public final static String EXTRA_ROTATION = "rotation";

	private static boolean sIsInSelectionMode = false;
	private ActionBarDrawerToggle mDrawerToggle;
	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;
	int count;

	private static int rotateXDegrees = 0;
	private SharedPreferences prefs;
	private Drawable mActionBarBackgroundDrawableDigi;

	private Account account;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
		} catch (Exception e) {
			listCard();
		}

		setContentView(R.layout.activity_menucard);
		btMenu = (LinearLayout) findViewById(R.id.ivAbLeft);
		tvTitle = (TextView) findViewById(R.id.txtBackEdit);
		mMenuRight = (ImageButton) findViewById(R.id.menu_item_right);

		btnSelectall = (LinearLayout) findViewById(R.id.btnRightShare);
		txtSelectall = (TextView) findViewById(R.id.tvRight);
		btnSelectCard = (TextView) findViewById(R.id.btnSelectCard);
		btnProfiles = (TextView) findViewById(R.id.btnProfiles);
		btnSetting = (TextView) findViewById(R.id.btnSetting);
		btnCapture = (ImageView) findViewById(R.id.btnCapture);
		btnExchange = (TextView) findViewById(R.id.btnExchange);
		btnSelectCard.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				if (!mFragmentListCard.isVisible()) {
					listCard();
					tvTitle.setText("All Cards");
				}
			}
		});
		btnProfiles.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				proFile();

			}
		});
		btnSetting.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
			}
		});
		btnExchange.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				exChangeFragment();
			}
		});
	}

	public void listCard() {
		isSelected = false;
		mFragmentListCard.isLongClicked(isSelected);
		tvTitle.setText("All Cards");
		tvTitle.setCompoundDrawablesWithIntrinsicBounds(
				R.drawable.ic_menu_left, 0, 0, 0);
		btnCapture.setVisibility(View.VISIBLE);

		btnSelectCard.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_listcard_btn, 0, 0);
		btnProfiles.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_profile, 0, 0);
		btnExchange.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_exchange, 0, 0);

		FragmentManager fm = MainActivity.this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		ft.replace(R.id.activity_main_content_fragment, mFragmentListCard);
		ft.commit();

	}

	public void proFile() {
		btnCapture.setVisibility(View.VISIBLE);
		// btnSelectall.setVisibility(View.GONE);
		txtSelectall.setVisibility(View.GONE);
		tvTitle.setText("Profile");
		tvTitle.setCompoundDrawablesWithIntrinsicBounds(
				R.drawable.ic_back_arrow, 0, 0, 0);

		btnSelectCard.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_listcard_nomal, 0, 0);
		btnProfiles.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_profile_selected, 0, 0);
		btnExchange.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_exchange, 0, 0);

		FragmentManager fm = MainActivity.this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		// if (mFragmentProfile.isAdded()) {
		// ft.show(mFragmentProfile);
		// } else {
		//
		// ft.addToBackStack("mFragmentProfile");
		ft.replace(R.id.activity_main_content_fragment,
				FragmentProfile.getInstant());

		// }
		ft.commit();
	}

	public void exChangeFragment() {

		tvTitle.setText("Exchange");

		btnSelectCard.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_listcard_nomal, 0, 0);
		btnProfiles.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_profile, 0, 0);
		btnExchange.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.ic_exchange_selected, 0, 0);

		FragmentManager fm = MainActivity.this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.activity_main_content_fragment,
				FragmentExchange.getInstance(account));

		ft.commit();

	}
}
