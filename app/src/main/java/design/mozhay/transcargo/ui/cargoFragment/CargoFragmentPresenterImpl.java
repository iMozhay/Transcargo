package design.mozhay.transcargo.ui.cargoFragment;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import design.mozhay.transcargo.App;
import design.mozhay.transcargo.data.database.DeliveryDatabase;
import design.mozhay.transcargo.data.entity.model.Delivery;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CargoFragmentPresenterImpl implements CargoFragmentPresenter {

    private List<Delivery> mDeliveryList = new ArrayList<>();
    private CargoFragment mCargoFragment;
    private DeliveryDatabase mDatabase;
    private CompositeDisposable allDisposables;

    private Observer<List<Delivery>> mDeliveryObserver = new Observer<List<Delivery>>() {
        @Override
        public void onSubscribe(Disposable d) {
            allDisposables.add(d);
        }

        @Override
        public void onNext(List<Delivery> deliveryList) {
            mCargoFragment.showDelivery(deliveryList);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    public CargoFragmentPresenterImpl(@NonNull CargoFragment fragment){
        mCargoFragment = fragment;
        mDatabase = App.getAppDeliveryDB();
        allDisposables = new CompositeDisposable();
    }

    @Override
    public void onStart() {
        loadDelivery();
    }

    @Override
    public void onDestroy() {
        allDisposables.dispose();
    }

    @Override
    public void loadDelivery() {

        mDatabase
                .getDeliveryDao()
                .getAllDeliveries()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mDeliveryObserver);
    }
}
