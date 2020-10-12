package design.mozhay.transcargo.data.entity.rest.dellin;

import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawAuthBody;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawAuthResult;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawCitiesResult;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawMicroCalcResult;
import design.mozhay.transcargo.data.entity.rest.dellin.rawResult.DLRawStreetResult;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApiDellin {

    @Headers("Content-Type: application/json")
    @POST("v3/auth/login")
    Observable<DLRawAuthResult> getAuth(@Body DLRawAuthBody authBody);

    @GET("v2/public/kladr")
    Observable<DLRawCitiesResult> findKLADRCity(
            @Query("appkey") String appKey,
            @Query("q") String cityName,
            @Query("limit") int limitCities
    );

    @GET("v1/public/kladr_street")
    Observable<DLRawStreetResult> findKLADRStreet(
            @Query("appkey") String appKey,
            @Query("sessionID") String sessionID,
            @Query("cityID") int cityID,
            @Query("street") String street,
            @Query("limit") int limit
    );

    @GET("v1/micro_calc")
    Observable<DLRawMicroCalcResult> getSimpleCalculation(
            @Query("appkey") String appKey,
            @Query("sessionID") String sessionID,
            @Query("derival") String derivalCity,
            @Query("arrival") String arrivalCity
    );




    /*

    Адрес метода: https://api.dellin.ru/v1/micro_calc.json

    {
   "appkey":"00000000-0000-0000-0000-000000000000",
   "sessionID":"0000000-0000-0000-0000-000000000000",
   "derival":{
      "city":"7800000000000000000000000"
   },
   "arrival":{
      "city":"5500000100000000000000000"
   }
}
    Адрес метода: https://api.dellin.ru/v1/public/kladr_street.json


{
   "appkey":"00000000-0000-0000-0000-000000000000",
   "sessionID":"00000000-0000-0000-0000-000000000000",
   "cityID":12345,
   "code":"1000000100000010000000000",
   "street":"Авто",
   "limit":2
}


    @GET("maps/api/geocode/json")
    Observable<RawResult> getNavpoint(
            @Query("address") String address,
            @Query("key") String keyAPI
    );

    @GET("maps/api/distancematrix/json")
    Observable<RawDistanceMatrix> getDistanceMatrix(
            @Query("origins") String origins,
            @Query("destinations") String destinations,
            @Query("language") String language,
            @Query("key") String keyAPI
    );


     https://api.dellin.ru/v3/auth/login.json

     //kladr
     Адрес метода: https://api.dellin.ru/v2/public/kladr.json


     {
   "appkey":"00000000-0000-0000-0000-000000000000",
   "login":"info@info.ru",
   "password":"Password1"
}
     */


}
