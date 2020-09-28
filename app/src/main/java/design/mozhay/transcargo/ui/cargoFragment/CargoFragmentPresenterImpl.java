package design.mozhay.transcargo.ui.cargoFragment;

import androidx.annotation.NonNull;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import design.mozhay.transcargo.App;
import design.mozhay.transcargo.data.database.DeliveryDatabase;
import design.mozhay.transcargo.data.entity.Delivery;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CargoFragmentPresenterImpl implements CargoFragmentPresenter {

    private List<Delivery> mDeliveryList = new ArrayList<>();
    private CargoFragment mCargoFragment;
    private DeliveryDatabase mDatabase;

    public CargoFragmentPresenterImpl(@NonNull CargoFragment fragment){
        mCargoFragment = fragment;
        mDatabase = App.getAppDeliveryDB();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void loadDelivery() {

        mDatabase
                .getDeliveryDao()
                .getAllDeliveries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<List<Delivery>>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(List<Delivery> deliveryList) {
                        mDeliveryList = deliveryList;
                        mCargoFragment.showDelivery(mDeliveryList);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
