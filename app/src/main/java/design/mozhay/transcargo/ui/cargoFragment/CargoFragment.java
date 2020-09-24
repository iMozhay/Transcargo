package design.mozhay.transcargo.ui.cargoFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import design.mozhay.transcargo.databinding.FragmentCargoBinding;

public class CargoFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private FragmentCargoBinding mCargoBinding;
    private RecyclerView mCargoRecyclerView;
    private CargoRecyclerAdapter mCargoAdapter;

    public static CargoFragment newInstance(int index){
        CargoFragment fragment = new CargoFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        mCargoBinding = FragmentCargoBinding.inflate(inflater, container, false);

        initialize();

        return mCargoBinding.getRoot();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        mCargoBinding = null;
    }

    private void initialize(){
        mCargoRecyclerView = mCargoBinding.cargoRecyclerView;
        mCargoAdapter = new CargoRecyclerAdapter();
        mCargoRecyclerView.setAdapter(mCargoAdapter);
    }
}
