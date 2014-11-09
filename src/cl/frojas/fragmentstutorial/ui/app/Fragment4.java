package cl.frojas.fragmentstutorial.ui.app;

import cl.frojas.fragmentstutorial.R;
import cl.frojas.fragmentstutorial.servicios.Servicio;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment4 extends Fragment {

	private TextView txtCancion;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_4, container, false);
		txtCancion = (TextView) rootView.findViewById(R.id.textView1);
		return rootView;
	}
	 
    @Override
    public void onResume(){
    	super.onResume();
    	getActivity().startService(new Intent(getActivity(), Servicio.class));
    	getActivity().registerReceiver(broadcastReceiver, new IntentFilter(Servicio.BROADCAST_ACTION));
    }
    
    @Override
    public void onPause(){
    	super.onPause();
    	getActivity().unregisterReceiver(broadcastReceiver);
    	getActivity().stopService(new Intent(getActivity(), Servicio.class));
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
        	txtCancion.setText("Estoy escuchando "+intent.getStringExtra("cancion")+" #NowPlaying");
        }
    }; 
}
