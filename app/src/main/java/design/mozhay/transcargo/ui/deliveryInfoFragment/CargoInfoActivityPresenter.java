package design.mozhay.transcargo.ui.deliveryInfoFragment;

import design.mozhay.transcargo.data.entity.model.Delivery;

public interface CargoInfoActivityPresenter {

    void onStart();

    void onDestroy();

    void update(Delivery delivery);

    void actionSearch();

    void actionCancel();

    void showDelivery(int cargoId);

    //product text values management below
    void setDescription(String text);

    void setCargoWeight(String weight);

    void setCargoVolume(String volume);

    void setCargoQuantity(String quantity);

    void setDerivalCity(String derivalCity);

    void setArrivalCity(String arrivalCity);

    void setDerivalStreet(String derivalStreet);

    void setArrivalStreet(String arrivalStreet);

    void setDerivalHouse(String derivalHouse);

    void setArrivalHouse(String arrivalHouse);

}
