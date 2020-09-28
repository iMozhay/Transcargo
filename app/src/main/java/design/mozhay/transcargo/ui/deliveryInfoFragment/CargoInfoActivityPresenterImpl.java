package design.mozhay.transcargo.ui.deliveryInfoFragment;

import design.mozhay.transcargo.App;
import design.mozhay.transcargo.data.entity.Delivery;
import design.mozhay.transcargo.databinding.FragmentDeliveryInfoBinding;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CargoInfoActivityPresenterImpl implements CargoInfoActivityPresenter {

    private static Delivery mDelivery;
    private static FragmentDeliveryInfoBinding mBinding;
    private boolean isChanged = false;

    public CargoInfoActivityPresenterImpl(FragmentDeliveryInfoBinding binding, boolean isCreate){
        //if new
        mBinding = binding;
        if (isCreate) {
            mDelivery = new Delivery();
        } else { //if exist
            //mDelivery = findDeliveryByID(getIntent().getStringExtra(DELIVERY_ID));
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        mBinding = null;
    }

    @Override
    public void update(Delivery delivery) {

    }

    @Override
    public void actionSearch() {
        Completable.fromRunnable(() -> App.getAppDeliveryDB().getDeliveryDao().insert(mDelivery))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    @Override
    public void actionCancel() {

    }

    @Override
    public void setDescription(String text) {
        mDelivery.setCargoDescription(text);
        isChanged = true;
    }

    @Override
    public void setCargoWeight(String weight) {
        mDelivery.setCargoWeight(weight);
        isChanged = true;
    }

    @Override
    public void setCargoVolume(String volume) {
        mDelivery.setCargoVolume(volume);
        isChanged = true;
    }

    @Override
    public void setCargoQuantity(String quantity) {
        mDelivery.setCargoQuantity(quantity);
        isChanged = true;
    }

    @Override
    public void setDerivalCity(String derivalCity) {
        mDelivery.setDerivalCity(derivalCity);
        isChanged = true;
    }

    @Override
    public void setArrivalCity(String arrivalCity) {
        mDelivery.setArrivalCity(arrivalCity);
        isChanged = true;
    }

    @Override
    public void setDerivalStreet(String derivalStreet) {
        mDelivery.setDerivalStreet(derivalStreet);
        isChanged = true;
    }

    @Override
    public void setArrivalStreet(String arrivalStreet) {
        mDelivery.setArrivalStreet(arrivalStreet);
        isChanged = true;
    }

    @Override
    public void setDerivalHouse(String derivalHouse) {
        mDelivery.setDerivalHouse(derivalHouse);
        isChanged = true;
    }

    @Override
    public void setArrivalHouse(String arrivalHouse) {
        mDelivery.setArrivalHouse(arrivalHouse);
        isChanged = true;
    }
}
