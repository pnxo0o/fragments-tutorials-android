package cl.frojas.fragmentstutorial.ui.app;

import cl.frojas.fragmentstutorial.R;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment2 extends Fragment {
	
	private Button button;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_2, container, false);
		
		button = (Button) rootView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	lanzarFragmentA();
            }
        });
		return rootView;
	}
	
	public void lanzarFragmentA(){
		FragmentA fragmentA = new FragmentA();
		if (!fragmentA.isAdded()) {
        FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();              
        ft.replace(R.id.content_frame, fragmentA);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
		return;
		}
	}
}

