package design.mozhay.transcargo.data.service.dellin;

import design.mozhay.transcargo.data.entity.model.Delivery;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawAuthResult;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawMicroCalcResult;
import io.reactivex.Observable;

public interface DellinRepository {

    //temp test
    Observable<DLRawAuthResult> getSessionID();


    Observable<DLRawMicroCalcResult> getDellinMicroCalc(Delivery delivery);



}
