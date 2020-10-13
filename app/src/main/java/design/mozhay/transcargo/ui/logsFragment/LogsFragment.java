package design.mozhay.transcargo.ui.logsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import design.mozhay.transcargo.App;
import design.mozhay.transcargo.databinding.FragmentLogsBinding;

public class LogsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private FragmentLogsBinding mLogsBinding;
    private LogsRecyclerAdapter mLogsAdapter;

    public static LogsFragment newInstance(int index){
        LogsFragment fragment = new LogsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        mLogsBinding = FragmentLogsBinding.inflate(inflater,container,false);

        initialize();

        return mLogsBinding.getRoot();
    }

    @Override
    public void onDestroy(){
        mLogsBinding = null;
        super.onDestroy();
    }

    private void initialize(){
        mLogsAdapter = new LogsRecyclerAdapter();
        mLogsBinding.logsRecyclerView.setAdapter(mLogsAdapter);
        App.getAppLogsRepo().setLogFragment(this);
    }

    public void setLogMessage(String time, String message){
        mLogsAdapter.addLogMessage(time, message);
    }
}
