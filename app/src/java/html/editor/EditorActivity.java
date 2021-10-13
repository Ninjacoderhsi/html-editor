package ir.htmlplus.hsi.ninjacoder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.HorizontalScrollView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import org.antlr.v4.runtime.*;
import io.github.rosemoe.sora.*;
import com.evgenii.jsevaluator.*;
import io.github.rosemoe.sora.langs.css3.*;
import io.github.rosemoe.sora.langs.html.*;
import io.github.rosemoe.sora.langs.java.*;
import io.github.rosemoe.sora.langs.python.*;
import io.github.rosemoe.sora.langs.universal.*;
import io.github.rosemoe.sora.langs.base.*;
import androidx.fragment.app.Fragment;
import io.github.rosemoe.sora.widget.schemes.HTMLScheme;
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula;
import io.github.rosemoe.sora.widget.schemes.SchemeEclipse;
import io.github.rosemoe.sora.widget.schemes.SchemeGitHub;
import io.github.rosemoe.sora.widget.schemes.SchemeNotepadXX;
import io.github.rosemoe.sora.widget.schemes.SchemeVS2019;

import io.github.rosemoe.sora.langs.EmptyLanguage;
import io.github.rosemoe.sora.langs.desc.CDescription;
import io.github.rosemoe.sora.langs.desc.CppDescription;
import io.github.rosemoe.sora.langs.desc.JavaScriptDescription;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.python.PythonLanguage;
import io.github.rosemoe.sora.langs.universal.UniversalLanguage;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class EditorActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	
	private LinearLayout linear1;
	private CodeEditor editor;
	private LinearLayout linear4;
	private LinearLayout linear2;
	private ImageView undob;
	private ImageView erdo;
	private ImageView allset;
	private ImageView more;
	private HorizontalScrollView hscroll2;
	private SymbolInputView sys;
	
	private Intent ninja = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.editor);
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
		_fab = findViewById(R.id._fab);
		
		linear1 = findViewById(R.id.linear1);
		editor = findViewById(R.id.editor);
		linear4 = findViewById(R.id.linear4);
		linear2 = findViewById(R.id.linear2);
		undob = findViewById(R.id.undob);
		erdo = findViewById(R.id.erdo);
		allset = findViewById(R.id.allset);
		more = findViewById(R.id.more);
		hscroll2 = findViewById(R.id.hscroll2);
		sys = findViewById(R.id.sys);
		
		undob.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				editor.undo();
			}
		});
		
		erdo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				editor.redo();
			}
		});
		
		allset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((io.github.rosemoe.sora.widget.CodeEditor)editor).selectAll();
				SketchwareUtil.showMessage(getApplicationContext(), getResources().getString(R.string.msg));
			}
		});
		
		more.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				View popupView = getLayoutInflater().inflate(R.layout.custompop, null);
				final PopupWindow popup = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
				LinearLayout bg = popupView.findViewById(R.id.bg);
				LinearLayout javas = popupView.findViewById(R.id.javas);
				LinearLayout htmls = popupView.findViewById(R.id.htmls);
				LinearLayout pys = popupView.findViewById(R.id.pys);
				LinearLayout css2 = popupView.findViewById(R.id.css2);
				LinearLayout save = popupView.findViewById(R.id.save);
				 TextView   zaban32 = popupView.findViewById(R.id.zaban32);
				
				zaban32.setText(getResources().getString(R.string.zaban1));
				
				 TextView   html = popupView.findViewById(R.id.html);
				
				html.setText(getResources().getString(R.string.html2));
				
				 TextView   java = popupView.findViewById(R.id.java);
				
				java.setText(getResources().getString(R.string.java2));
				
				 TextView   py = popupView.findViewById(R.id.py);
				
				py.setText(getResources().getString(R.string.py2));
				
				 TextView   pathsave = popupView.findViewById(R.id.pathsave);
				
				pathsave.setText(getResources().getString(R.string.files));
				
				 TextView   css1 = popupView.findViewById(R.id.css1);
				
				css1.setText("css mod");
				
				javas.setOnClickListener(new OnClickListener() { public void onClick(View view) {
								editor.setEditorLanguage(new JavaLanguage()); 
								popup.dismiss();
						} });
				
				htmls.setOnClickListener(new OnClickListener() { public void onClick(View view) {
								editor.setEditorLanguage(new HTMLLanguage()); 
						editor.setColorScheme(new HTMLScheme());
								popup.dismiss();
						} });
				
				pys.setOnClickListener(new OnClickListener() { public void onClick(View view) {
								editor.setEditorLanguage(new PythonLanguage()); 
								popup.dismiss();
						} });
				
				css2.setOnClickListener(new OnClickListener() { public void onClick(View view) {
								editor.setEditorLanguage(new CSS3Language()); 
						editor.setColorScheme(new SchemeVS2019());
								popup.dismiss();
						} });
				
				save.setOnClickListener(new OnClickListener() { public void onClick(View view) {
								if (getIntent().getStringExtra("save").equals("empty")) {
							
						}
						else {
							FileUtil.writeFile(getIntent().getStringExtra("save"), editor.getText().toString());
							SketchwareUtil.showMessage(getApplicationContext(), "saved");
						}
								popup.dismiss();
						} });
				
				popup.setAnimationStyle(android.R.style.Animation_Dialog);
				
				popup.showAsDropDown(more, 0,0);
				
				popup.setBackgroundDrawable(new BitmapDrawable());
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ninja.putExtra("res", editor.getText().toString());
				ninja.setClass(getApplicationContext(), WebviewActivity.class);
				startActivity(ninja);
			}
		});
	}
	
	private void initializeLogic() {
		try{
			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		}catch(Exception e){
			 
		}
		///editor.setColorScheme(new HTMLScheme());
		SymbolInputView inputView = findViewById(R.id.sys);
		
		        inputView.bindEditor(editor);
		        inputView.addSymbols(new String[]{"->", "{", "}", "(", ")", "<" , ">" ,  ",", ".", ";", "\"", "?", "+", "-", "*", "/"},
		                new String[]{"\t", "{}", "}", "(", ")", ",", ".", ";", "\"", "?", "+", "-", "*", "/"});
		
		linear1.setBackgroundColor(Color.TRANSPARENT);
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			
			Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("path"))).useDelimiter("\\Z");
			while (scanner.hasNext()) {
				stringBuilder .append(scanner.next());
			}
			editor.setText(stringBuilder );
		} catch (Exception rt) {
			rt.printStackTrace();
		}
		editor.setColorScheme(new SchemeDarcula());
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_fab.setImageResource(R.drawable.play);
		undob.setImageResource(R.drawable.undo);
		erdo.setImageResource(R.drawable.redo);
		allset.setImageResource(R.drawable.selectall);
		more.setImageResource(R.drawable.more);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =EditorActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF1E1E1E);
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