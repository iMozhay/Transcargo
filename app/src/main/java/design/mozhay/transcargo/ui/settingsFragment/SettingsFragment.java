package design.mozhay.transcargo.ui.settingsFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static SettingsFragment newInstance(int index){
        SettingsFragment fragment = new SettingsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }
}
