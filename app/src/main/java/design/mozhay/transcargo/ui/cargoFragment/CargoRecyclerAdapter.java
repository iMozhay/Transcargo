package design.mozhay.transcargo.ui.cargoFragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import design.mozhay.transcargo.data.entity.Delivery;
import design.mozhay.transcargo.databinding.CardviewCargoBinding;

public class CargoRecyclerAdapter extends RecyclerView.Adapter {

    private List<Delivery> mCargoList;
    private CardviewCargoBinding cargoBinding;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        cargoBinding = CardviewCargoBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CargoViewHolder(cargoBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof CargoViewHolder){
            ((CargoViewHolder) holder).setPosition(position);
            ((CargoViewHolder) holder).bind(mCargoList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mCargoList.size();
    }

    public class  CargoViewHolder extends RecyclerView.ViewHolder{

        private int mPosition;

        public CargoViewHolder(@NonNull CardviewCargoBinding itemBinding) {
            super(itemBinding.getRoot());
        }

        public void setPosition(int position){
            this.mPosition = position;
        }

        public void bind(Delivery delivery){
            cargoBinding.cargoName.setText(delivery.getCargoDescription());
            cargoBinding.cargoDerivalCity.setText(delivery.getDerivalCity());
            cargoBinding.cargoDerivalStreet.setText(delivery.getDerivalStreet());
            cargoBinding.cargoDerivalHouse.setText(delivery.getDerivalHouse());
            cargoBinding.cargoArrivalCity.setText(delivery.getArrivalCity());
            cargoBinding.cargoArrivalStreet.setText(delivery.getArrivalStreet());
            cargoBinding.cargoArrivalHouse.setText(delivery.getArrivalHouse());
            cargoBinding.cargoTotalWeight.setText(delivery.getCargoWeight());
            cargoBinding.cargoTotalVolume.setText(delivery.getCargoVolume());
            cargoBinding.cargoTotalQty.setText(delivery.getCargoQuantity());
        }

    }

}
