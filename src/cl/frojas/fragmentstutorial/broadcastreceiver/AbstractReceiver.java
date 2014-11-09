package cl.frojas.fragmentstutorial.broadcastreceiver;

import cl.frojas.fragmentstutorial.entities.Cancion;
import cl.frojas.fragmentstutorial.servicios.Servicio;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public abstract class AbstractReceiver extends BroadcastReceiver {
	
	private Cancion mCancion = null;
	private Intent mService = null;

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		Bundle bundle = intent.getExtras();
		mService = new Intent(Servicio.ACCION);
        try {
        	//aqui obtenimos la cancion del reproductor
    		parseIntent(context, action, bundle);
//    		Toast.makeText(context, mCancion.getArtista(), Toast.LENGTH_LONG).show();
    		mService.putExtra("cancion", mCancion.getCancion());
    		
    		context.startService(mService);
//    		MainActivity.getInstace().updateTheTextView(mCancion);
        	
        } catch (Exception e) {
        	mCancion=null;
        }
	}
	
	protected final void setCancion(Cancion cancion) {
		mCancion = cancion;
	}

	protected abstract void parseIntent(Context ctx, String action,
			Bundle bundle) throws IllegalArgumentException;
}
