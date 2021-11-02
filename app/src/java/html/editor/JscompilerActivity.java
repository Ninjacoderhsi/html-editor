package ir.htmlplus.hsi.ninjacoder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
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
import android.webkit.WebView;
import android.webkit.WebSettings;
import io.github.rosemoe.sora.*;
import com.evgenii.jsevaluator.*;
import io.github.rosemoe.sora.langs.base.*;
import io.github.rosemoe.sora.langs.css3.*;
import io.github.rosemoe.sora.langs.html.*;
import io.github.rosemoe.sora.langs.java.*;
import io.github.rosemoe.sora.langs.python.*;
import io.github.rosemoe.sora.langs.textmate.*;
import io.github.rosemoe.sora.langs.universal.*;
import org.antlr.v4.runtime.*;
import com.oguzdev.circularfloatingactionmenu.library.*;
import me.ibrahimsn.particle.*;
import androidx.fragment.app.Fragment;
import android.webkit.WebChromeClient;
import android.view.View.OnLongClickListener;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class JscompilerActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private WebView consoleView;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.jscompiler);
		initialize(_savedInstanceState);
		initializeLogic();
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
		consoleView = findViewById(R.id.consoleView);
		consoleView.getSettings().setJavaScriptEnabled(true);
		consoleView.getSettings().setSupportZoom(true);
		
		//webviewOnProgressChanged
		consoleView.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		//OnDownloadStarted
		consoleView.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request consoleViewa = new DownloadManager.Request(Uri.parse(url));
				String consoleViewb = CookieManager.getInstance().getCookie(url);
				consoleViewa.addRequestHeader("cookie", consoleViewb);
				consoleViewa.addRequestHeader("User-Agent", userAgent);
				consoleViewa.setDescription("Downloading file...");
				consoleViewa.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				consoleViewa.allowScanningByMediaScanner(); consoleViewa.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); consoleViewa.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager consoleViewc = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				consoleViewc.enqueue(consoleViewa);
				showMessage("Downloading File....");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
						
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		
		consoleView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
		String var3 = getIntent().getExtras().getString("sendCode");
		      StringBuilder var2 = new StringBuilder();
		      var2.append("<html><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width,  initial-scale=1.0'><title>console</title><link rel=\"stylesheet\" href=\"css/saam.min.css\"><link rel=\"stylesheet\" href=\"css/console.css\"></head><body><div class='coutput content scroll-content' id='log'></div><script>var Console = function(code){var args = [];for(var a in arguments){if(typeof arguments[a] == \"object\"){var c = JSON.stringify(arguments[a]);args.push(c);} else { args.push(arguments[a]);}} document.getElementById('log').innerHTML += `<code class='cline'>${args.join('')}</code>`;};(function runCode() { try { ");
		      var2.append(var3.replace("console.log", "Console"));
		      var2.append(" } catch (err){ document.getElementById('log').innerHTML = `<code class='cline cerror'> ! ${err.message} </code>`; } })();</script></body></html>");
		      String var5 = var2.toString();
		      WebSettings var4 = consoleView.getSettings();
		      var4.setJavaScriptEnabled(true);
		      var4.setDomStorageEnabled(true);
		      var4.setDatabaseEnabled(true);
		      var4.setAllowContentAccess(true);
		      var4.setAllowFileAccess(true);
		      var4.setAppCacheEnabled(true);
		      var4.setUseWideViewPort(true);
		      consoleView.setWebChromeClient(new WebChromeClient());
		      consoleView.loadDataWithBaseURL("file:///android_asset/core/", var5, "text/html", "utf-8", (String)null);
		      consoleView.setOnLongClickListener(new OnLongClickListener() {
				         public boolean onLongClick(View var1) {
						            return true;
						         }
				      });
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