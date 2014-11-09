package cl.frojas.fragmentstutorial;

import cl.frojas.fragmentstutorial.ui.app.MainActivity;
import cl.frojas.fragmentstutorial.ui.login.LoginActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class BootActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_boot);
		lanzarActividad();
	}

	public void lanzarActividad(){
		Intent intent;
		
		SharedPreferences prefs = getSharedPreferences(Config.ARCHIVO_PREFERENCIAS, Context.MODE_PRIVATE);
		String sesion = prefs.getString(Config.SESION, "");
		
		Toast.makeText(this, sesion, Toast.LENGTH_SHORT).show();
		
		if(sesion.contains(Config.SESION)){
			intent = new Intent(this, MainActivity.class);
		}
		else{
			intent = new Intent(this, LoginActivity.class);
		}
		
		startActivity(intent);
		finish();
		return;
	}
}
