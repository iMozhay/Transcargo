package design.mozhay.transcargo.ui.logsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import design.mozhay.transcargo.databinding.FragmentLogsBinding;

public class LogsFragment extends Fragment {

    private FragmentLogsBinding mLogsBinding;
    private LogsRecyclerAdapter mLogsAdapter;

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
    }

    public void setLogMessage(String time, String message){
        mLogsAdapter.addLogMessage(time, message);
    }
}
