package cl.frojas.fragmentstutorial.broadcastreceiver;

import cl.frojas.fragmentstutorial.entities.Cancion;
import android.content.Context;
import android.os.Bundle;

public class AndroidMusicReceiver extends AbstractReceiver {
	
	static final String APP_PACKAGE = "com.android.music";
	static final String APP_NAME = "Android Music Player";

	static final String ACTION_ANDROID_START = "com.android.music.playstatechanged";
	static final String ACTION_ANDROID_METACHANGED = "com.android.music.metachanged";
	static final String ACTION_ANDROID_STOP = "com.android.music.playbackcomplete";
	static final String ACTION_UNKNOW = "com.android.music.queuechanged";
	
	@Override
	protected void parseIntent(Context ctx, String action, Bundle bundle)
			throws IllegalArgumentException {

		Cancion mCancion = new Cancion();
		mCancion.setArtista(bundle.getString("artist"));
		mCancion.setCancion(bundle.getString("track"));
		mCancion.setReproductor(APP_NAME);
		
		if (action == ACTION_ANDROID_STOP) {
			setCancion(null);
		}

		else if (action == ACTION_ANDROID_START){
			setCancion(mCancion);
		}
		
		else if (action == ACTION_ANDROID_METACHANGED) {
			setCancion(mCancion);
		}
		
		else if (action == ACTION_UNKNOW) {
			setCancion(mCancion);
		}
	}
}
