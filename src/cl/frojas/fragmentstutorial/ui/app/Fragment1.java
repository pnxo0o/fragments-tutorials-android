package cl.frojas.fragmentstutorial.ui.app;

import cl.frojas.fragmentstutorial.BootActivity;
import cl.frojas.fragmentstutorial.Config;
import cl.frojas.fragmentstutorial.R;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {
	
	private Button button;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_1, container, false);
		
		button = (Button) rootView.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	lanzarLogin();
            }
        });
		return rootView;
	}
	
	public void lanzarLogin(){
		//accedemos a la preferencia y guardamos la sesion
		SharedPreferences prefs = getActivity().getSharedPreferences(Config.ARCHIVO_PREFERENCIAS,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(Config.SESION, "");
		editor.commit();
		
		//lanzamos el main
		Intent intent;
		intent = new Intent(getActivity(), BootActivity.class);
		startActivity(intent);
		getActivity().finish();
		return;
	}

}
