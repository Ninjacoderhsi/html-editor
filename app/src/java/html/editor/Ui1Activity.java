package ir.htmlplus.hsi.ninjacoder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.content.Intent;
import android.net.Uri;
import android.widget.AdapterView;
import android.view.View;
import io.github.rosemoe.editor.*;
import io.github.rosemoe.editor.langs.base.*;
import io.github.rosemoe.editor.langs.python.*;
import io.github.rosemoe.editor.langs.java.*;
import io.github.rosemoe.editor.langs.html.*;
import org.antlr.v4.runtime.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class Ui1Activity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private String subtitle = "";
	private String Folder = "";
	private double position = 0;
	private double UpFolder = 0;
	private String UpFOlder = "";
	
	private ArrayList<String> liststring = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> File_map = new ArrayList<>();
	
	private LinearLayout linear1;
	private ListView listview1;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear3;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear5;
	private TextView _drawer_mark;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_mmm;
	private ImageView _drawer_iconweb;
	private TextView _drawer_web1;
	
	private Intent newint = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ui1);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(Ui1Activity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear1 = findViewById(R.id.linear1);
		listview1 = findViewById(R.id.listview1);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_mark = _nav_view.findViewById(R.id.mark);
		_drawer_vscroll1 = _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_mmm = _nav_view.findViewById(R.id.mmm);
		_drawer_iconweb = _nav_view.findViewById(R.id.iconweb);
		_drawer_web1 = _nav_view.findViewById(R.id.web1);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				position = _position;
				if (FileUtil.isDirectory(liststring.get((int)(_position)))) {
					Folder = liststring.get((int)(_position));
					_RefreshData();
				}
				else {
					if ((liststring.get((int)(_position)).endsWith(".java") || (liststring.get((int)(_position)).endsWith(".js") || (liststring.get((int)(_position)).endsWith(".html") || (liststring.get((int)(_position)).endsWith(".css") || (liststring.get((int)(_position)).endsWith(".py") || ((liststring.get((int)(_position)).endsWith(".cs") || liststring.get((int)(_position)).endsWith(".go")) || (liststring.get((int)(_position)).endsWith(".cpp") || (liststring.get((int)(_position)).endsWith(".lua") || ((liststring.get((int)(_position)).endsWith(".r") || (liststring.get((int)(_position)).endsWith(".php") || (liststring.get((int)(_position)).endsWith(".rb") || liststring.get((int)(_position)).endsWith(".rbw")))) || liststring.get((int)(_position)).endsWith(".sass")))))))))) || true) {
						newint.setClass(getApplicationContext(), EditorActivity.class);
						newint.putExtra("path", liststring.get((int)(_position)));
						newint.putExtra("save", liststring.get((int)(_position)));
						startActivity(newint);
					}
				}
			}
		});
		
		_drawer_mmm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "بزودی......");
			}
		});
	}
	
	private void initializeLogic() {
		try{
			Folder = FileUtil.getExternalStorageDir();
			_RefreshData();
			if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
				Window w =Ui1Activity.this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF1E1E1E);
			}
			_drawer_mark.setText(getResources().getString(R.string.marks));
			_drawer_web1.setText(getResources().getString(R.string.web2));
			_drawer_iconweb.setImageResource(R.drawable.web);
			LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);  androidx.drawerlayout.widget.DrawerLayout .LayoutParams params = (androidx.drawerlayout.widget.DrawerLayout .LayoutParams)_nav_view.getLayoutParams();  params.width = (int)getDip((int)250);  params.height = androidx.drawerlayout.widget.DrawerLayout .LayoutParams.MATCH_PARENT;  _nav_view.setLayoutParams(params);
			 _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
			if (true) {
				     getSupportActionBar().hide();
			}
			else {
						getSupportActionBar().show();
			}
			listview1.setHorizontalScrollBarEnabled(false);
			listview1.setVerticalScrollBarEnabled(false);
			listview1.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
		}catch(Exception e){
			 
		}
	}
	
	@Override
	public void onBackPressed() {
		try{
			if (Folder.equals(FileUtil.getExternalStorageDir())) {
				finishAffinity();
			}
			else {
				UpFOlder = Folder.substring((int)(0), (int)(Folder.lastIndexOf("/")));
				Folder = UpFOlder;
				_RefreshData();
			}
		}catch(Exception e){
			 
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setNavigationBarColor(Color.parseColor("0xFF1E1E1E".replace("0xFF" , "#")));
		}
	}
	public void _RefreshData() {
		listview1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); listview1.setItemsCanFocus(false);
		File_map.clear();
		subtitle = Folder;
		FileUtil.listDir(Folder, liststring);
		Collections.sort(liststring, String.CASE_INSENSITIVE_ORDER);
		position = 0;
		for(int _repeat14 = 0; _repeat14 < (int)(liststring.size()); _repeat14++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("file", liststring.get((int)(position)));
				File_map.add(_item);
			}
			
			position++;
		}
		listview1.setAdapter(new Listview1Adapter(File_map));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.customfolder, null);
			}
			
			final LinearLayout install = _view.findViewById(R.id.install);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setText(Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0x91FFFFFF);SketchUi.setCornerRadius(getDip(6));
				install.setElevation(getDip(3));
				install.setBackground(SketchUi);
			}
			try{
				if (FileUtil.isDirectory(liststring.get((int)(_position)))) {
					imageview1.setImageResource(R.drawable.folder);
				}
				else {
					if (liststring.get((int)(_position)).endsWith(".css")) {
						imageview1.setImageResource(R.drawable.languagecss3);
					}
					else {
						if (liststring.get((int)(_position)).endsWith(".html")) {
							imageview1.setImageResource(R.drawable.languagehtml5);
						}
						else {
							if (liststring.get((int)(_position)).endsWith(".js")) {
								imageview1.setImageResource(R.drawable.languagejavascript);
							}
							else {
								if (liststring.get((int)(_position)).endsWith(".py")) {
									imageview1.setImageResource(R.drawable.languagepython);
								}
								else {
									if (liststring.get((int)(_position)).endsWith(".java")) {
										imageview1.setImageResource(R.drawable.languagejava);
									}
									else {
										if (liststring.get((int)(_position)).endsWith(".go")) {
											imageview1.setImageResource(R.drawable.languagego);
										}
										else {
											if (liststring.get((int)(_position)).endsWith(".lua")) {
												imageview1.setImageResource(R.drawable.languagelua);
											}
											else {
												if (liststring.get((int)(_position)).endsWith(".cs")) {
													imageview1.setImageResource(R.drawable.languagecsharp);
												}
												else {
													if (liststring.get((int)(_position)).endsWith(".c")) {
														imageview1.setImageResource(R.drawable.languagec);
													}
													else {
														if (liststring.get((int)(_position)).endsWith(".cpp")) {
															imageview1.setImageResource(R.drawable.languagecpp);
														}
														else {
															if (liststring.get((int)(_position)).endsWith(".sass")) {
																imageview1.setImageResource(R.drawable.bulma);
															}
															else {
																if (liststring.get((int)(_position)).endsWith(".r")) {
																	imageview1.setImageResource(R.drawable.languager);
																}
																else {
																	if (liststring.get((int)(_position)).endsWith(".rb") || liststring.get((int)(_position)).endsWith(".rbw")) {
																		imageview1.setImageResource(R.drawable.languageruby);
																	}
																	else {
																		
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}catch(Exception e){
				 
			}
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}