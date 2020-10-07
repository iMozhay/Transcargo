package design.mozhay.transcargo.ui.deliveryInfoFragment;

import design.mozhay.transcargo.App;
import design.mozhay.transcargo.data.entity.model.Delivery;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawAuthResult;
import design.mozhay.transcargo.data.service.dellin.DellinRepository;
import design.mozhay.transcargo.data.service.dellin.DellinRepositoryImpl;
import design.mozhay.transcargo.databinding.FragmentDeliveryInfoBinding;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CargoInfoActivityPresenterImpl implements CargoInfoActivityPresenter {

    private static Delivery mDelivery;
    private static FragmentDeliveryInfoBinding mBinding;
    private boolean isChanged = false;
    private CargoInfoActivityView mCargoView;
    private CompositeDisposable allDisposables;
    private int mCargoId;

    private DellinRepository mDellinRepo;


    private CompletableObserver mCargoObserver = new CompletableObserver() {
        @Override
        public void onSubscribe(Disposable d) {
            allDisposables.add(d);

        }

        @Override
        public void onComplete() {
            mCargoView.closeInfo();
        }

        @Override
        public void onError(Throwable e) {

        }
    };
    private SingleObserver<Delivery> mDeliveryObserver = new SingleObserver<Delivery>() {
        @Override
        public void onSubscribe(Disposable d) {
            allDisposables.add(d);
        }

        @Override
        public void onSuccess(Delivery delivery) {
            mDelivery = delivery;
            showDeliveryInfo(delivery);
        }

        @Override
        public void onError(Throwable e) {

        }
    };

    public CargoInfoActivityPresenterImpl(FragmentDeliveryInfoBinding binding, CargoInfoActivityView view, boolean isCreate, int cargo_id){

        mCargoView = view;
        mBinding = binding;
        allDisposables = new CompositeDisposable();
        mCargoId = cargo_id;
        mDellinRepo = new DellinRepositoryImpl(App.getRestApiDellin());
        //if new
        if (isCreate) {
            mDelivery = new Delivery();
        } else { //if exist
            showDelivery(mCargoId);
            //mDelivery = findDeliveryByID(getIntent().getStringExtra(DELIVERY_ID));
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        mBinding = null;
        allDisposables.dispose();
    }

    @Override
    public void update(Delivery delivery) {

    }

    @Override
    public void actionOk() {
        Completable.fromRunnable(() -> App.getAppDeliveryDB().getDeliveryDao().insert(mDelivery))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mCargoObserver);
    }

    @Override
    public void actionCancel() {
        mCargoView.closeInfo();
    }

    @Override
    public void actionInfo() {
        mDellinRepo
                .getSessionID()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DLRawAuthResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        int i = 0;

                    }

                    @Override
                    public void onNext(DLRawAuthResult dlRawAuthResult) {
                        int i = 0;
                    }

                    @Override
                    public void onError(Throwable e) {
                        int i = 0;

                    }

                    @Override
                    public void onComplete() {
                        int i = 0;

                    }
                });

    }

    @Override
    public void showDelivery(int cargo_id) {
        App.getAppDeliveryDB()
                .getDeliveryDao()
                .getDeliveryById(cargo_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mDeliveryObserver);
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

    private void showDeliveryInfo(Delivery delivery){
        mBinding.cargoName.setText(delivery.getCargoDescription());
        mBinding.cargoDerivalCity.setText(delivery.getDerivalCity());
        mBinding.cargoDerivalStreet.setText(delivery.getDerivalStreet());
        mBinding.cargoDerivalHouse.setText(delivery.getDerivalHouse());
        mBinding.cargoArrivalCity.setText(delivery.getArrivalCity());
        mBinding.cargoArrivalStreet.setText(delivery.getArrivalStreet());
        mBinding.cargoArrivalHouse.setText(delivery.getArrivalHouse());
        mBinding.cargoTotalWeight.setText(delivery.getCargoWeight());
        mBinding.cargoTotalVolume.setText(delivery.getCargoVolume());
        mBinding.cargoTotalQty.setText(delivery.getCargoQuantity());
    }
}
