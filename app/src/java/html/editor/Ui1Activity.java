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
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.AdapterView;
import android.view.View;
import io.github.rosemoe.sora.langs.universal.*;
import io.github.rosemoe.sora.langs.textmate.*;
import io.github.rosemoe.sora.langs.python.*;
import io.github.rosemoe.sora.langs.java.*;
import io.github.rosemoe.sora.langs.html.*;
import io.github.rosemoe.sora.langs.css3.*;
import io.github.rosemoe.sora.langs.base.*;
import com.evgenii.jsevaluator.*;
import io.github.rosemoe.sora.*;
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
	private String url = "";
	private String filedir = "";
	
	private ArrayList<String> liststring = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> File_map = new ArrayList<>();
	
	private WebView nanami;
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
	private LinearLayout _drawer_foxse;
	private LinearLayout _drawer_terminal;
	private LinearLayout _drawer_myliner;
	private LinearLayout _drawer_github;
	private LinearLayout _drawer_exit;
	private ImageView _drawer_iconweb;
	private TextView _drawer_web1;
	private ImageView _drawer_fox;
	private TextView _drawer_textview1;
	private ImageView _drawer_terminal_image;
	private TextView _drawer_textview4;
	private ImageView _drawer_my1;
	private TextView _drawer_textview2;
	private ImageView _drawer_icongithub;
	private TextView _drawer_textview5;
	private ImageView _drawer_exit_run;
	private TextView _drawer_textview3;
	
	private Intent newint = new Intent();
	private Intent intent = new Intent();
	private AlertDialog.Builder dialogmain;
	private SharedPreferences reun;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ui1);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		
		nanami = findViewById(R.id.nanami);
		nanami.getSettings().setJavaScriptEnabled(true);
		nanami.getSettings().setSupportZoom(true);
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
		_drawer_foxse = _nav_view.findViewById(R.id.foxse);
		_drawer_terminal = _nav_view.findViewById(R.id.terminal);
		_drawer_myliner = _nav_view.findViewById(R.id.myliner);
		_drawer_github = _nav_view.findViewById(R.id.github);
		_drawer_exit = _nav_view.findViewById(R.id.exit);
		_drawer_iconweb = _nav_view.findViewById(R.id.iconweb);
		_drawer_web1 = _nav_view.findViewById(R.id.web1);
		_drawer_fox = _nav_view.findViewById(R.id.fox);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_terminal_image = _nav_view.findViewById(R.id.terminal_image);
		_drawer_textview4 = _nav_view.findViewById(R.id.textview4);
		_drawer_my1 = _nav_view.findViewById(R.id.my1);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_icongithub = _nav_view.findViewById(R.id.icongithub);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_exit_run = _nav_view.findViewById(R.id.exit_run);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		dialogmain = new AlertDialog.Builder(this);
		reun = getSharedPreferences("reun", Activity.MODE_PRIVATE);
		
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
					if ((liststring.get((int)(_position)).endsWith(".java") || (liststring.get((int)(_position)).endsWith(".js") || (liststring.get((int)(_position)).endsWith(".html") || (liststring.get((int)(_position)).endsWith(".css") || (liststring.get((int)(_position)).endsWith(".py") || ((liststring.get((int)(_position)).endsWith(".cs") || liststring.get((int)(_position)).endsWith(".go")) || (liststring.get((int)(_position)).endsWith(".cpp") || (liststring.get((int)(_position)).endsWith(".lua") || ((liststring.get((int)(_position)).endsWith(".r") || (liststring.get((int)(_position)).endsWith(".php") || (liststring.get((int)(_position)).endsWith(".rb") || liststring.get((int)(_position)).endsWith(".rbw")))) || (liststring.get((int)(_position)).endsWith(".json") || liststring.get((int)(_position)).endsWith(".sass"))))))))))) || (liststring.get((int)(_position)).endsWith(".NET") || (liststring.get((int)(_position)).endsWith(".ts") || (liststring.get((int)(_position)).endsWith(".xml") || (liststring.get((int)(_position)).endsWith(".php") || (liststring.get((int)(_position)).endsWith(".rs") || (liststring.get((int)(_position)).endsWith(".nix") || (liststring.get((int)(_position)).endsWith(".zend") || true)))))))) {
						newint.setClass(getApplicationContext(), EditorActivity.class);
						newint.putExtra("path", liststring.get((int)(_position)));
						newint.putExtra("save", liststring.get((int)(_position)));
						newint.putExtra("masir", Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
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
		
		_drawer_foxse.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				newint.setClass(getApplicationContext(), FoxeeditorActivity.class);
				startActivity(newint);
			}
		});
		
		_drawer_terminal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), TerminalshellActivity.class);
				startActivity(intent);
			}
		});
		
		_drawer_myliner.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				String url= "myket://comment?id=iir.htmlplus.hsi.ninjacoder";
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(url));
				startActivity(intent);
				
			}
		});
		
		_drawer_github.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://github.com/lord-readn/html-editor"));
				startActivity(intent);
			}
		});
		
		_drawer_exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finishAffinity();
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
			LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);  androidx.drawerlayout.widget.DrawerLayout .LayoutParams params = (androidx.drawerlayout.widget.DrawerLayout .LayoutParams)_nav_view.getLayoutParams();  params.width = (int)getDip((int)250);  params.height = androidx.drawerlayout.widget.DrawerLayout .LayoutParams.MATCH_PARENT;  _nav_view.setLayoutParams(params);
			 _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
			if (true) {
				     getSupportActionBar().hide();
			}
			else {
						getSupportActionBar().show();
			}
			_drawer_iconweb.setImageResource(R.drawable.web);
			_drawer_my1.setImageResource(R.drawable.google_play);
			_drawer_exit_run.setImageResource(R.drawable.exitrun);
			
			listview1.setHorizontalScrollBarEnabled(false);
			listview1.setVerticalScrollBarEnabled(false);
			listview1.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
			_drawer_fox.setImageResource(R.drawable.firefox);
			_drawer_terminal_image.setImageResource(R.drawable.terminal_shell);
			_drawer_icongithub.setImageResource(R.drawable.github);
		}catch(Exception e){
			 
		}
		try{
			nanami.loadUrl("file:///android_asset/namnam/ribbon.html");
			nanami.getSettings().setJavaScriptEnabled(true);
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
		dialogmain = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setNavigationBarColor(Color.parseColor("0xFF1E1E1E".replace("0xFF" , "#")));
		}
		int notifyId = 001;
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		Notification.Builder mbuilder = new Notification.Builder(Ui1Activity.this);
		mbuilder.setSmallIcon(R.drawable.mylego);
		mbuilder.setContentTitle("Html Go");
		mbuilder.setContentText("خوش امدید نسخه مورد استفاده شده از برنامه 1.5.6Fj2kmodbyloradreiden");
		mbuilder.setDefaults( Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
		
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			String channelId1 = "1";
			String channelName1 = "channel1";
			NotificationChannel channel = new NotificationChannel(channelId1, channelName1, NotificationManager.IMPORTANCE_DEFAULT);
			channel.enableLights(true);
			channel.setLightColor(Color.BLUE);
			channel.setShowBadge(true);
			channel.enableVibration(true);
			mbuilder.setChannelId(channelId1);
			if (mNotificationManager != null) {
				mNotificationManager.createNotificationChannel(channel);
			}
		} else {
			mbuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
		}
		
		if (mNotificationManager != null) {
			mNotificationManager.notify(notifyId, mbuilder.build());
		}
		
		if (reun.getString("key", "").equals("")) {
			 if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
					      
				dialogmain.setTitle("HTML GO");
				dialogmain.setMessage("اندروید شما 11 است و طبق مجوز های گوگل ما نیاز مند دست رسی به فایل هستیم اگر با گزینه لغو را بزنید ممکن است برنامه به خوبی اجرا نشود توجه این دیالوگ یک بار فقط نمایش داده میشود از تنظیمات موبایل در صورت تمایل فعال کنید");
				dialogmain.setIcon(R.drawable.mylego);
				dialogmain.setPositiveButton("قبول", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						filedir = "/sdcard/";
						if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
							    try {
								        
								       if (permission()) {	   
									if (FileUtil.isExistFile(filedir)) {
										FileUtil.makeDir(filedir);
									}          
											                } else {
											                  RequestPermission_Dialog();
									
											                }
								        
								        
								    } catch (Exception e) {
								               
								    }
									                
								         } else {
							
							if (FileUtil.isExistFile(filedir)) {
								FileUtil.makeDir(filedir);
							}
							
						}
					}
				});
				dialogmain.setNegativeButton("لغو", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				dialogmain.create().show();
						        
					    } else {
					      
					       
					    }
			reun.edit().putString("key", "1").commit();
		}
		else {
			
		}
		if (!getApplicationContext().getPackageName().equals("ir.htmlplus.hsi.ninjacoder")) {
			
			dialogmain.setTitle("HTML GO");
			dialogmain.setMessage("ببخشید لطفان از نسخه اصلی برنامه استفاده کنید برنامه را از مایکت فقط دانلود کنید این نسخه منسوخ شده است");
			dialogmain.setIcon(R.drawable.mylego);
			dialogmain.setPositiveButton("خروج", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finishAffinity();
				}
			});
			dialogmain.create().show();
			    
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
	
	
	public void _ifgetandroidfull() {
	}
	/*
Code Edited by Hichem Soft
The Code Fixed By Ninja Coder
youtube channel : Hichem Soft
*/
	@Override
	    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		  super.onActivityResult(_requestCode, _resultCode, _data);
		            
		if (_requestCode == new_folder){
			    if (_resultCode == Activity.RESULT_OK) {
				            if (_data != null) {
					              final Uri uri2 = _data.getData();
					if (Uri.decode(uri2.toString()).endsWith(":")) {
						SketchwareUtil.showMessage(getApplicationContext(), "⛔");
						askPermission(uri2.toString());
					}
					else {
						final int takeFlags = i.getFlags()
						            & (Intent.FLAG_GRANT_READ_URI_PERMISSION
						            | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
						// Check for the freshest data.
						getContentResolver().takePersistableUriPermission(uri2, takeFlags);
						
						
						 
						
						
					}
					
					       } else {
					        
					   }
				       } else {
				      
				 
				 
				   }
		}
		
		
		if (_requestCode == 2000) {
				      if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
						        if (Environment.isExternalStorageManager()) {
								          
								        } else {
								
								        }
						      }
				    
		}
		
		
		
		       
		
	}
	
	// solve android 11 sdcard permissions
	
	
	 public void RequestPermission_Dialog() {
		    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
				      try {
						        Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
						        intent.addCategory("android.intent.category.DEFAULT");
						        intent.setData(Uri.parse(String.format("package: ", new Object[]{getApplicationContext().getPackageName()})));
						        startActivityForResult(intent, 2000);
						      } catch (Exception e) {
						        Intent obj = new Intent();
						        obj.setAction(android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
						        startActivityForResult(obj, 2000);
						      }
				    } else {
				      androidx.core.app.ActivityCompat.requestPermissions(Ui1Activity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
				    }
		  }
	
	  public boolean permission() {
		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) { // R is Android 11
				      return Environment.isExternalStorageManager();
				    } else {
				      int write = androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
				      int read = androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE);
				
				      return write == android.content.pm.PackageManager.PERMISSION_GRANTED
				          && read == android.content.pm.PackageManager.PERMISSION_GRANTED;
				    }
	} 
	
	// ask permissions request
	
	public void askPermission(final String _uri) {
			
		if (fromStorage) {
			i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
		}
			i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
						i.setAction(Intent.ACTION_OPEN_DOCUMENT_TREE);
						    i.putExtra(android.provider.DocumentsContract.EXTRA_INITIAL_URI, Uri.parse(_uri));
						        startActivityForResult(i, new_folder);
		}
	
	// check permissions of path if accepted 
	
	
	public boolean checkPermission(final String _uri) {
				Uri muri = Uri.parse(_uri);
				    dFile = androidx.documentfile.provider.DocumentFile.fromTreeUri(getApplicationContext(), muri);
				                    
				if (dFile.canRead() && dFile.canWrite()) {
						return true ;
				}
				return false ;
		}
	
	// simple path to UriTree path
	
	
	public String pathToRealUri( String _path) {
				uriFor1 = "content://com.android.externalstorage.documents/tree/primary%3A";
		
		if ( _path.endsWith("/")) {
			_path = _path.substring(0, _path.length()-1);
		}
		
		
				if (_path.contains("/sdcard/")) {
						uriFor2 = _path.replace("/sdcard/", "").replace("/", "%2F");
						
						if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
								
								uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
								
						}
						
				}
				else {
						if (_path.contains("/storage/") && _path.contains("/emulated/")) {
								uriFor2 = _path.replace("/storage/emulated/0/", "").replace("/", "%2F");
								
								if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
										
										uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
										
								}	
								
						}
						else {
								
						}
				}
				return uriFor1 = uriFor1 + uriFor2;
		}
	
	
	// simple path to UriTree path 2
	
	public String pathToUri( String _path) {
				uriFor1 = "content://com.android.externalstorage.documents/tree/primary%3AAndroid/document/primary%3A";
		
		if ( _path.endsWith("/")) {
			_path = _path.substring(0, _path.length()-1);
		}
		
				if (_path.contains("/sdcard/")) {
						uriFor2 = _path.replace("/sdcard/", "").replace("/", "%2F");
						
						if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
								
								uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
								
						}
						
						
				}
				else {
						if (_path.contains("/storage/") && _path.contains("/emulated/")) {
								uriFor2 = _path.replace("/storage/emulated/0/", "").replace("/", "%2F");
								
								if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
										
										uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
										
								}
								
						}
						else {
								
						}
				}
				return uriFor1 = uriFor1 + uriFor2;
		}
	
	// ccopy file from path to path
	
	private boolean copyAsset(final String assetFilename, final Uri targetUri) {
		  			try{
			  				int count;
			  				InputStream input = null;
					OutputStream output = null;
			  				
			  				ContentResolver content = getApplicationContext().getContentResolver();
						  
			            input = getApplicationContext().getAssets().open(assetFilename);
						
			            output = content.openOutputStream(targetUri);
			            
			            
			  				byte data[] = new byte[1024];
			  				while ((count = input.read(data))>0) {
				  					output.write(data, 0, count);
				  			}
			  				output.flush();
			  				output.close();
			  				input.close();
			  				
			  				SketchwareUtil.showMessage(getApplicationContext(), "success ✔️ نجاح ");
							 
			  		}catch(Exception e){
			  				
			  				SketchwareUtil.showMessage(getApplicationContext(), e.toString());
							  return false;
			  		}
		
		return true;
	}
	
	
	public boolean copyFiles(Context context, Uri fileUri, Uri targetUri)
	    {
		        		InputStream is = null;
				OutputStream os = null;
		
		
		try {
					try {
							
				ContentResolver content = context.getContentResolver();
				            is = content.openInputStream(fileUri);
				            os = content.openOutputStream(targetUri);
							           
				        byte[] buffer = new byte[1024];
				        int length;
				        while ((length = is.read(buffer)) > 0) {
					            os.write(buffer, 0, length);
					        }
							
				    } finally {
				        is.close();
				        os.close();
				    } 
		} catch (IOException e) {
								return false;
					}
			
		return true;
	}
	
	
	private boolean fromStorage = false;
	  final static int REQUEST_CODE = 333;
	  final static  int OLD_REQUEST = 2000;
	  private SharedPreferences sha;
	private Intent ninjacoderuser = new Intent();
		private  Uri muri;
		private String uriFor1 = "";
		private String uriFor2 = "";
		private  
		androidx.documentfile.provider.DocumentFile dFile;
		private double PermissionNumber;
		private  static final int new_folder = 43;
	{
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
			
			textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview1.setMarqueeRepeatLimit(-1);
			textview1.setSingleLine(true);
			textview1.setSelected(true); 
			textview1.setText(Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0x601C1C1C);SketchUi.setCornerRadius(getDip(6));
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
																		if (liststring.get((int)(_position)).endsWith(".json")) {
																			imageview1.setImageResource(R.drawable.jsonfiler);
																		}
																		else {
																			if (liststring.get((int)(_position)).endsWith(".NET")) {
																				imageview1.setImageResource(R.drawable.lu_net);
																			}
																			else {
																				if (liststring.get((int)(_position)).endsWith(".php")) {
																					imageview1.setImageResource(R.drawable.laphp);
																				}
																				else {
																					if (liststring.get((int)(_position)).endsWith(".xml")) {
																						imageview1.setImageResource(R.drawable.laxml);
																					}
																					else {
																						if (liststring.get((int)(_position)).endsWith(".zend")) {
																							imageview1.setImageResource(R.drawable.lazend);
																						}
																						else {
																							if (liststring.get((int)(_position)).endsWith(".rs")) {
																								imageview1.setImageResource(R.drawable.larust);
																							}
																							else {
																								if (liststring.get((int)(_position)).endsWith(".nix")) {
																									imageview1.setImageResource(R.drawable.lanix);
																								}
																								else {
																									if (liststring.get((int)(_position)).endsWith(".ts")) {
																										imageview1.setImageResource(R.drawable.latypescript);
																									}
																									else {
																										if ("ADM".startsWith(liststring.get((int)(_position)))) {
																											imageview1.setImageResource(R.drawable.tea);
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