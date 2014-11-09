package cl.frojas.fragmentstutorial.ui.app;

import cl.frojas.fragmentstutorial.R;
import cl.frojas.fragmentstutorial.hilos.TaskFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment3 extends Fragment implements TaskFragment.TaskCallbacks {

    private static final String KEY_CURRENT_PROGRESS = "current_progress";
    private static final String KEY_PERCENT_PROGRESS = "percent_progress";
    private static final String TAG_TASK_FRAGMENT = "task_fragment";

    private TaskFragment mTaskFragment;
    private ProgressBar mProgressBar;
    private TextView mPercent;
	private Button mButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_3, container, false);
	    mProgressBar = (ProgressBar) rootView.findViewById(R.id.progress_horizontal);
	    mPercent = (TextView) rootView.findViewById(R.id.percent_progress);
		mButton = (Button) rootView.findViewById(R.id.task_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	 if (mTaskFragment.isRunning()) {
                     mTaskFragment.cancel();
                   } else {
                     mTaskFragment.start();
                   }
            }
        });
		return rootView;
	}

	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);

      // Restore saved state.
      if (savedInstanceState != null) {
        mProgressBar.setProgress(savedInstanceState.getInt(KEY_CURRENT_PROGRESS));
        mPercent.setText(savedInstanceState.getString(KEY_PERCENT_PROGRESS));
      }

      FragmentManager fm = getActivity().getFragmentManager();
      mTaskFragment = (TaskFragment) fm.findFragmentByTag(TAG_TASK_FRAGMENT);

      // If we haven't retained the worker fragment retained, then create it
      // and set this UIFragment as the TaskFragment's target fragment.
      if (mTaskFragment == null) {
        mTaskFragment = new TaskFragment();
        mTaskFragment.setTargetFragment(this, 0);
        fm.beginTransaction().add(mTaskFragment, TAG_TASK_FRAGMENT).commit();
      }

      if (mTaskFragment.isRunning()) {
        mButton.setText(getString(R.string.cancel));
      } else {
        mButton.setText(getString(R.string.start));
      }
    }
	
	@Override
    public void onSaveInstanceState(Bundle outState) {
      super.onSaveInstanceState(outState);
      outState.putInt(KEY_CURRENT_PROGRESS, mProgressBar.getProgress());
      outState.putString(KEY_PERCENT_PROGRESS, mPercent.getText().toString());
    }
	
    @Override
    public void onPreExecute() {
      mButton.setText(getString(R.string.cancel));
      Toast.makeText(getActivity(), R.string.task_started_msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgressUpdate(int percent) {
      mProgressBar.setProgress(percent * mProgressBar.getMax() / 100);
      mPercent.setText(percent + "%");
    }

    @Override
    public void onCancelled() {
    	if(isAdded()){// si el fragmento esta agregado a la actividad se cerrala la tarea
    	      mButton.setText(getString(R.string.start));
    	      mProgressBar.setProgress(0);
    	      mPercent.setText(getString(R.string.zero_percent));
    	      Toast.makeText(getActivity(), R.string.task_cancelled_msg, Toast.LENGTH_SHORT).show();	
    	}
    }

    @Override
    public void onPostExecute() {
      mButton.setText(getString(R.string.start));
      mProgressBar.setProgress(mProgressBar.getMax());
      mPercent.setText(getString(R.string.one_hundred_percent));
      Toast.makeText(getActivity(), R.string.task_complete_msg, Toast.LENGTH_SHORT).show();
    }
}
