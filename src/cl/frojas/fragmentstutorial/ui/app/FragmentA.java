package cl.frojas.fragmentstutorial.ui.app;

import cl.frojas.fragmentstutorial.R;
import cl.frojas.fragmentstutorial.R.layout;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentA extends Fragment  {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_a, container, false);
		return rootView;
	}
}
