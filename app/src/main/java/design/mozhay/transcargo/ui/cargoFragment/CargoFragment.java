package design.mozhay.transcargo.ui.cargoFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import design.mozhay.transcargo.data.entity.model.Delivery;
import design.mozhay.transcargo.databinding.FragmentCargoBinding;
import design.mozhay.transcargo.ui.deliveryInfoFragment.CargoInfoActivity;

public class CargoFragment
        extends Fragment implements CargoRecyclerAdapter.CargoListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private FragmentCargoBinding mCargoBinding;
    private RecyclerView mCargoRecyclerView;
    private CargoRecyclerAdapter mCargoAdapter;
    private FloatingActionButton mFabAdd;
    private CargoFragmentPresenterImpl mCargoPresenter;

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

        mCargoPresenter = new CargoFragmentPresenterImpl(this);
        mCargoPresenter.onStart();
        return mCargoBinding.getRoot();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        mCargoBinding = null;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCargoPresenter.loadDelivery();
    }

    private void initialize(){
        mCargoRecyclerView = mCargoBinding.cargoRecyclerView;
        mCargoAdapter = new CargoRecyclerAdapter();
        mCargoAdapter.setListener(this);
        mCargoRecyclerView.setAdapter(mCargoAdapter);
        mFabAdd = mCargoBinding.fabAdd;
        mFabAdd.setOnClickListener(v -> startCargoCardActivity(new Delivery(), true));
    }

    public void startCargoCardActivity(Delivery delivery, boolean isCreate){

        Intent intent = new Intent(getContext(), CargoInfoActivity.class);
        if (isCreate){
            intent.putExtra(CargoInfoActivity.DELIVERY_CREATE, isCreate);
        } else {
            intent.putExtra(CargoInfoActivity.DELIVERY_CREATE, false);
            intent.putExtra(CargoInfoActivity.DELIVERY_ID, delivery.getId());
        }
        startActivity(intent);
    }

    public void showDelivery(List<Delivery> deliveryList){
        mCargoAdapter.setCargoList(deliveryList);
    }

    @Override
    public void onClickDelivery(Delivery delivery) {
        startCargoCardActivity(delivery, false);
    }
}
