package cl.frojas.fragmentstutorial.broadcastreceiver;

import cl.frojas.fragmentstutorial.entities.Cancion;
import android.content.Context;
import android.os.Bundle;

public class LgOptimus4xReceiver extends AbstractReceiver {
	
	static final String APP_PACKAGE = "com.lge.music";
	static final String APP_NAME = "LG Music Player";

	static final String ACTION_LGE_START = "com.lge.music.metachanged";
	static final String ACTION_LGE_PAUSERESUME = "com.lge.music.playstatechanged";
	static final String ACTION_LGE_STOP = "com.lge.music.endofplayback";

	@Override
	protected void parseIntent(Context ctx, String action, Bundle bundle)
			throws IllegalArgumentException {
		
		Cancion mCancion = new Cancion();
		mCancion.setArtista(bundle.getString("artist"));
		mCancion.setCancion(bundle.getString("track"));
		mCancion.setReproductor(APP_NAME);
		
		if (action == ACTION_LGE_STOP) {
			setCancion(null);
		}

		if (action == ACTION_LGE_START){
			setCancion(mCancion);
		}
		
		else if (action == ACTION_LGE_PAUSERESUME) {
			setCancion(mCancion);
		}
	}
}
