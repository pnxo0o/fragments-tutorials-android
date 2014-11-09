package cl.frojas.fragmentstutorial.servicios;

import cl.frojas.fragmentstutorial.broadcastreceiver.AbstractReceiver;
import cl.frojas.fragmentstutorial.broadcastreceiver.AndroidMusicReceiver;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class Servicio extends Service {
	
	public static final String ACCION = "cl.frojas.fragmentstutorial.servicios.Servicio.accion";
	public static final String BROADCAST_ACTION = "cl.frojas.fragmentstutorial.servicios.Servicio.envio";
	
	private Intent intento;
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	private AbstractReceiver mReceiver1 = new AndroidMusicReceiver();
	
	/** Called when the service is being created. */
	@Override
	public void onCreate() {
	  super.onCreate();
	  IntentFilter if1 = new IntentFilter();
      if1.addAction("com.android.music.metachanged");
      if1.addAction("com.android.music.playstatechanged");
      if1.addAction("com.android.music.playbackcomplete");
      if1.addAction("com.android.music.queuechanged");

      registerReceiver(mReceiver1, if1);
      intento = new Intent(BROADCAST_ACTION);	
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// Let it continue running until it is stopped.
		reciboAccion(intent);
		Toast.makeText(this, "Iniciado", Toast.LENGTH_SHORT).show();
		return START_STICKY;
	}
	
	private void reciboAccion(Intent intent) {
		if(intent==null){
			return;
		}
		String action = intent.getAction();
		Bundle extras = intent.getExtras();
		if(extras==null || action==null){
			return;
		}
		if (action.equals(ACCION)){
			String cancion = null;
			cancion = extras.getString("cancion", cancion); 
//			Toast.makeText(this, "cancion"+cancion, Toast.LENGTH_LONG).show();
			intento.putExtra("cancion", cancion);
	    	sendBroadcast(intento);
		}
		return;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mReceiver1);
		Toast.makeText(this, "Destruido", Toast.LENGTH_SHORT).show();
	}
}
