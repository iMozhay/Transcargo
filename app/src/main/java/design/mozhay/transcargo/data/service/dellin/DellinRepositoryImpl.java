package design.mozhay.transcargo.data.service.dellin;

import design.mozhay.transcargo.data.auth.DLAuth;
import design.mozhay.transcargo.data.entity.model.Delivery;
import design.mozhay.transcargo.data.entity.rest.dellin.RestApiDellin;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawAuthBody;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawAuthResult;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawMicroCalcResult;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DellinRepositoryImpl implements DellinRepository {

    private RestApiDellin mRestApiDellin;
    private DLAuth mDellinKeys;
    private String mSessionID;
    private DLRawAuthBody mAuthBody = new DLRawAuthBody();

    private Observer<DLRawAuthResult> mDLAuthObserver = new Observer<DLRawAuthResult>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(DLRawAuthResult dlRawAuthResult) {
            mSessionID = dlRawAuthResult.getRawSessionID().getSessionID();
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    public DellinRepositoryImpl(RestApiDellin restApiDellin){
        mRestApiDellin = restApiDellin;
        mDellinKeys = new DLAuth();
        mAuthBody.appkey = mDellinKeys.getDellinKey();
        mAuthBody.login = mDellinKeys.getDellinLogin();
        mAuthBody.password = mDellinKeys.getDellinPassword();
    }

    @Override
    public Observable<DLRawAuthResult> getAuth() {
        return mRestApiDellin
                .getAuth(mAuthBody);

    }

    @Override
    public Observable<DLRawMicroCalcResult> getDellinMicroCalc(Delivery delivery) {
        return null;
    }

    /*
    private void authDellin(){
        mRestApiDellin
                .getAuth(mDellinKeys.getDellinKey(),
                        mDellinKeys.getDellinLogin(),
                        mDellinKeys.getDellinPassword())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mDLAuthObserver);
    }
    */

}
