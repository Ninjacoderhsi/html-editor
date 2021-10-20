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
import com.evgenii.jsevaluator.*;
import io.github.rosemoe.sora.*;
import io.github.rosemoe.sora.langs.base.*;
import io.github.rosemoe.sora.langs.universal.*;
import io.github.rosemoe.sora.langs.python.*;
import io.github.rosemoe.sora.langs.java.*;
import io.github.rosemoe.sora.langs.html.*;
import io.github.rosemoe.sora.langs.css3.*;
import io.github.rosemoe.sora.langs.textmate.*;
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
	private String jsonfixer = "";
	
	private LinearLayout linear1;
	private CodeEditor editor;
	private LinearLayout linear4;
	private LinearLayout linear2;
	private ImageView undob;
	private ImageView erdo;
	private ImageView allset;
	private ImageView jsonpather;
	private ImageView imageview1;
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
		jsonpather = findViewById(R.id.jsonpather);
		imageview1 = findViewById(R.id.imageview1);
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
		
		jsonpather.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (getIntent().getStringExtra("path").contains(".json")) {
					try{
						jsonfixer = editor.getText().toString();
						{
							final String json_str = jsonfixer;
							final int indent_width = 4;
								
							    final char[] chars = json_str.toCharArray();
							    final String newline = System.lineSeparator();
							
							final boolean[] begin_quotes = {false};
							   
							final int[] progres = {0};
							 
							final String[] ret = {""};
							
							final ProgressDialog prog = new ProgressDialog(EditorActivity.this);
							
							prog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
							
							prog.setIndeterminate(false);
							
							prog.setMax(chars.length);
							
							prog.setMessage("Formatting in progress...");
							
							prog.setCancelable(false);
							
							prog.show();
							new Thread(new Runnable() {
									@Override
									public void run() {
											Looper.prepare();
											
											
											    for (int i = 0, indent = 0; i < chars.length; i++) {
													        char c = chars[i];
													
													prog.setProgress(i);
													
													
													
													        if (c == '\"') {
															            ret[0] += c;
															            begin_quotes[0] = !begin_quotes[0];
															            continue;
															        }
													
													        if (!begin_quotes[0]) {
															            switch (c) {
																	            case '{':
																	            case '[':
																	                ret[0] += c + newline + String.format("%" + (indent += indent_width) + "s", "");
																	                continue;
																	            case '}':
																	            case ']':
																	                ret[0] += newline + ((indent -= indent_width) > 0 ? String.format("%" + indent + "s", "") : "") + c;
																	                continue;
																	            case ':':
																	                ret[0] += c + " ";
																	                continue;
																	            case ',':
																	                ret[0] += c + newline + (indent > 0 ? String.format("%" + indent + "s", "") : "");
																	                continue;
																	            default:
																	                if (Character.isWhitespace(c)) continue;
																	            }
															        }
													
													        ret[0] += c + (c == '\\' ? "" + chars[++i] : "");
													    }
											
											    
											
											
											runOnUiThread(new Runnable() {
													@Override
													public void run() {
															
															
															
															prog.dismiss();
															
											editor.setText(ret[0]);
															
															Looper.loop();
													} 
													
											});
									}
							}).start();
							
						}
					}catch(Exception e){
						 
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "متاسفم فایل شما جیسون نیست (json)");
				}
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ColorPicker seekColorPicker = new ColorPicker(EditorActivity.this);
				
						final AlertDialog.Builder buildPicker = new AlertDialog.Builder(EditorActivity.this);
				
						final LinearLayout linPicker = new LinearLayout(getApplicationContext());
				
				
						
				
				
				
						linPicker.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					SketchUi.setColor(0xFFFFFFFF);SketchUi.setCornerRadius(getDip(30));
					SketchUi.setStroke((int)getDip(2) ,0xFF008DCD);
					linPicker.setElevation(getDip(5));
					linPicker.setBackground(SketchUi);
				}
				
						linPicker.setOrientation(LinearLayout.VERTICAL);
				
						linPicker.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL);
				
				
				
						buildPicker.setPositiveButton("✔️", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialogInterface, int i) {
						imageview1.setColorFilter(Color.parseColor(hex.getText().toString().replace("0xFF" ,"#")), PorterDuff.Mode.MULTIPLY);
								}
						});
				
				
				
						linPicker.addView(seekColorPicker);
						buildPicker.setView(linPicker);
						buildPicker.show();
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
				if (getIntent().getStringExtra("path").contains(".html")) {
					ninja.putExtra("res", editor.getText().toString());
					ninja.setClass(getApplicationContext(), WebviewActivity.class);
					startActivity(ninja);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "dont html file");
				}
			}
		});
	}
	
	private void initializeLogic() {
		try{
			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
			editor.setColorScheme(new SchemeVS2019());
		}catch(Exception e){
			 
		}
		jsonpather.setVisibility(View.VISIBLE);
		jsonpather.setImageResource(R.drawable.jsonfiler);
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
		if (getIntent().getStringExtra("path").contains(".html")) {
			editor.setEditorLanguage(new HTMLLanguage()); 
			editor.setColorScheme(new HTMLScheme());
			StringBuilder htmlmod = new StringBuilder();
			
			try {
				
				Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("path"))).useDelimiter("\\Z");
				while (scanner.hasNext()) {
					htmlmod .append(scanner.next());
				}
				editor.setText(htmlmod );
			} catch (Exception rt) {
				rt.printStackTrace();
			}
		}
		else {
			if (getIntent().getStringExtra("path").contains(".py")) {
				editor.setColorScheme(new SchemeVS2019());
				editor.setEditorLanguage(new PythonLanguage()); 
				StringBuilder pyviewer = new StringBuilder();
				
				try {
					
					Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("path"))).useDelimiter("\\Z");
					while (scanner.hasNext()) {
						pyviewer .append(scanner.next());
					}
					editor.setText(pyviewer );
				} catch (Exception rt) {
					rt.printStackTrace();
				}
			}
			else {
				if (getIntent().getStringExtra("path").contains(".cpp")) {
					editor.setColorScheme(new SchemeVS2019());
					editor.setEditorLanguage(new UniversalLanguage(new CppDescription()));
					StringBuilder cpproad = new StringBuilder();
					
					try {
						
						Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("path"))).useDelimiter("\\Z");
						while (scanner.hasNext()) {
							cpproad .append(scanner.next());
						}
						editor.setText(cpproad );
					} catch (Exception rt) {
						rt.printStackTrace();
					}
				}
				else {
					if (getIntent().getStringExtra("path").contains(".js")) {
						editor.setColorScheme(new SchemeVS2019());
						StringBuilder jsroad = new StringBuilder();
						
						try {
							
							Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("path"))).useDelimiter("\\Z");
							while (scanner.hasNext()) {
								jsroad .append(scanner.next());
							}
							editor.setText(jsroad );
						} catch (Exception rt) {
							rt.printStackTrace();
						}
						editor.setEditorLanguage(new UniversalLanguage(new JavaScriptDescription()));
					}
					else {
						if (getIntent().getStringExtra("path").contains(".java")) {
							editor.setColorScheme(new SchemeVS2019());
							StringBuilder javaroad = new StringBuilder();
							
							try {
								
								Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("path"))).useDelimiter("\\Z");
								while (scanner.hasNext()) {
									javaroad .append(scanner.next());
								}
								editor.setText(javaroad );
							} catch (Exception rt) {
								rt.printStackTrace();
							}
							editor.setEditorLanguage(new JavaLanguage()); 
						}
						else {
							if (getIntent().getStringExtra("path").contains(".c")) {
								editor.setColorScheme(new SchemeVS2019());
								StringBuilder javaroad = new StringBuilder();
								
								try {
									
									Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("path"))).useDelimiter("\\Z");
									while (scanner.hasNext()) {
										javaroad .append(scanner.next());
									}
									editor.setText(javaroad );
								} catch (Exception rt) {
									rt.printStackTrace();
								}
							}
							else {
								if (getIntent().getStringExtra("path").contains(".json")) {
									editor.setColorScheme(new SchemeVS2019());
									StringBuilder javaroad = new StringBuilder();
									
									try {
										
										Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("path"))).useDelimiter("\\Z");
										while (scanner.hasNext()) {
											javaroad .append(scanner.next());
										}
										editor.setText(javaroad );
									} catch (Exception rt) {
										rt.printStackTrace();
									}
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
	public void _librarycolorpicker() {
	}
		 private Button btnCopy;
		 private EditText hex;
		 private EditText hex2;
		 private boolean isSimleDialog = false;
		 public static interface OnColorChangedListener
		 {
				 public void onColorChanged(ColorPicker picker, int color);
			 }
		 class ColorPicker extends LinearLayout
		 {
				 private SeekBar r;
				 private SeekBar g;
				 private SeekBar b;
				 private TextView colorShow;
				 private SeekBar.OnSeekBarChangeListener listener;
				 private OnColorChangedListener l;
				 public ColorPicker(Context c)
				 {
						 super(c);
						 init();
					 }
		
				 private void init(){
						 setPadding(16, 16, 16, 16);
						 setGravity(Gravity.CENTER);
						 setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
						 colorShow = new TextView(getContext());
						 colorShow.setLayoutParams(new ViewGroup.LayoutParams(60, 60));
						 addView(colorShow);
						 listener = new SeekBar.OnSeekBarChangeListener(){
								 @Override
								 public void onProgressChanged(SeekBar p1, int p2, boolean p3)
								 {
										 int color = Color.rgb(r.getProgress(), g.getProgress(), b.getProgress());
										 String temp = String.format("0x%08X", color);
										 String result = temp.substring(2);
										 hex.setText("#" + result);
										 hex2.setText("0x" + result);
										 hex.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN);
										 colorShow.setBackgroundColor(color);
										 btnCopy.setBackgroundColor(color);
					
										 double darkness = 1-(0.299*Color.red(color) + 0.587*Color.green(color) + 0.114*Color.blue(color))/255;
					
										 if(darkness<0.5){
												 btnCopy.setTextColor(Color.BLACK);
											 }else{
												 btnCopy.setTextColor(Color.WHITE);
											 }
					
					
					
										 if(l != null) l.onColorChanged(ColorPicker.this, color);
									 }
								 @Override public void onStartTrackingTouch(SeekBar p1){}
								 @Override public void onStopTrackingTouch(SeekBar p1){}
							 };
						 LinearLayout lay2 = new LinearLayout(getContext());
						 lay2.setOrientation(VERTICAL);
						 lay2.setPadding(8, 0, 8, 8);
						 lay2.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
						 hex = new EditText(getContext());
						 hex2 = new EditText(getContext());
						 ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
						 params.setMargins(16, 0, 16, 0);
						 hex.setLayoutParams(params);
						 hex2.setLayoutParams(params);
						 hex.setCursorVisible(false);
			
						 hex.setImeOptions(android.view.inputmethod.EditorInfo.IME_ACTION_DONE);
						 hex.setText("#000000");
						 hex2.setText("0xFF000000");
						 hex.setOnEditorActionListener(new TextView.OnEditorActionListener(){
								 @Override
								 public boolean onEditorAction(TextView text, int code, KeyEvent event)
								 {
										 try {
												 int color = Color.parseColor(text.getText().toString());
												 r.setProgress(Color.red(color));
												 g.setProgress(Color.green(color));
												 b.setProgress(Color.blue(color));
											 } catch(Exception e){
												 Toast.makeText(getContext(), "Color code is wrong", Toast.LENGTH_SHORT).show();
											 }
										 return true;
									 }
							 });
			
						 btnCopy = new Button(getApplicationContext());
			
						 btnCopy.setTextSize(15);
			
			if (isSimleDialog) {
							 if (Locale.getDefault().getDisplayLanguage().equals("العربية")){
									 btnCopy.setText("نسخ");
								 } else {
									 btnCopy.setText("Copy");
								 }
							     btnCopy.setClickable(true);
							 } if (! isSimleDialog) {
								 btnCopy.setText("");
								 btnCopy.setClickable(false);
							 }
			
						 btnCopy.setTypeface(Typeface.MONOSPACE);
			
						 btnCopy.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
						 
						 btnCopy.setPadding(0,0,0,0);
						 
						 btnCopy.setBackgroundColor(Color.BLACK);
						 
						 btnCopy.setTextColor(Color.WHITE);
			
						 btnCopy.setOnClickListener(new View.OnClickListener() {
								 @Override
								 public void onClick(View view) {
										 try {
												 android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
												 ClipData clip = ClipData.newPlainText("label", hex.getText().toString());
												 clipboard.setPrimaryClip(clip);
												 Toast.makeText(getApplicationContext(), "✓", Toast.LENGTH_SHORT).show();
											 } catch (Exception e) {
												 e.printStackTrace();
											 }
									 }
							 });
			
						 lay2.addView(hex);
						 lay2.addView(hex2);
						 r = new SeekBar(getContext());
						 setProgressColor(r, 0xffcc5577);
						 r.setMax(255);
						 r.setOnSeekBarChangeListener(listener);
						 lay2.addView(r);
						 g = new SeekBar(getContext());
						 setProgressColor(g, 0xff339977);
						 g.setMax(255);
						 g.setOnSeekBarChangeListener(listener);
						 lay2.addView(g);
						 b = new SeekBar(getContext());
						 setProgressColor(b, 0xff6077bb);
						 b.setMax(255);
						 b.setOnSeekBarChangeListener(listener);
						 lay2.addView(b);
						 addView(lay2);
						 int color = Color.parseColor(hex.getText().toString());
						 r.setProgress(Color.red(color));
						 g.setProgress(Color.green(color));
						 b.setProgress(Color.blue(color));
						 colorShow.setBackgroundColor(color);
						 lay2.addView(btnCopy);
					 }
				 public void setColor(int color)
				 {
						 hex.setText("#" + String.format("0x%08X", color).substring(2));
						 hex2.setText("0x" + String.format("0x%08X", color).substring(2));
						 r.setProgress(Color.red(color));
						 g.setProgress(Color.green(color));
						 b.setProgress(Color.blue(color));
			
			
			
					 }
				 public int getColor(boolean refreshFromSlider)
				 {
						 if(refreshFromSlider)
							 listener.onProgressChanged(null, 0, false);
						 return Color.parseColor(hex.getText().toString());
					 }
				 public int getColor()
				 {
						 return getColor(true);
					 }
				 public void setOnColorChangedListener(OnColorChangedListener l)
				 {
						 this.l = l;
					 }
				 private void setProgressColor(AbsSeekBar bar, int color)
				 {
						 bar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN); bar.getThumb().setColorFilter(color, PorterDuff.Mode.SRC_IN);
					 }
			 }
		 {
		
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