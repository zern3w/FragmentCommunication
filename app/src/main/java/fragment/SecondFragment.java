package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puttipong.testfragment.R;

public class SecondFragment extends Fragment {

    EditText etSecond;
    FirstFragment fragment;

    public SecondFragment() {
        super();
    }

    public static SecondFragment newInstance() {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        etSecond = (EditText) rootView.findViewById(R.id.etSecond);

        etSecond.addTextChangedListener(new MyTextWatcher2(etSecond));

    }

    public void setChangedText(String txt) {
        Toast.makeText(getContext(),
                "SecondFragment was changed: \n" + txt,
                Toast.LENGTH_SHORT).show();
        etSecond.setText(txt);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    private class MyTextWatcher2 implements TextWatcher {
        private View view;

        private MyTextWatcher2(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            fragment = (FirstFragment) getFragmentManager()
                    .findFragmentById(R.id.contentContainerUpper);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String text = editable.toString();
            if (etSecond.isFocused()) {
                fragment.setChangedText(text);
            }
        }
    }
}