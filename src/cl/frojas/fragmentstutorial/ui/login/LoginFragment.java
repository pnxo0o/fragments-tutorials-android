package cl.frojas.fragmentstutorial.ui.login;

import cl.frojas.fragmentstutorial.Config;
import cl.frojas.fragmentstutorial.R;
import cl.frojas.fragmentstutorial.ui.app.MainActivity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_login, container, false);
		
		Button button = (Button) view.findViewById(R.id.button1);
		button.setOnClickListener(new lanzarMain());
		return view;
	}
	
	public class lanzarMain implements OnClickListener {
		@Override
		public void onClick(View arg0) {
			lanzarMain();
		}
	}
	
	public void lanzarMain(){
		//accedemos a la preferencia y guardamos la sesion
		SharedPreferences prefs = getActivity().getSharedPreferences(Config.ARCHIVO_PREFERENCIAS,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(Config.SESION, Config.SESION);
		editor.commit();
		
		//lanzamos el main
		Intent intent;
		intent = new Intent(getActivity(), MainActivity.class);
		getActivity().startActivity(intent);
		getActivity().finish();
		return;
	}
	

}
