package design.mozhay.transcargo.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "delivery", indices = { @Index("id")})
public class Delivery {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int mId;

    @ColumnInfo(name = "cargoDescription")
    private String cargoDescription;

    @ColumnInfo(name = "cargoWeight")
    private String cargoWeight;

    @ColumnInfo(name = "cargoVolume")
    private String cargoVolume;

    @ColumnInfo(name = "cargoQuantity")
    private String cargoQuantity;

    @ColumnInfo(name = "derivalCity")
    private String derivalCity;

    @ColumnInfo(name = "derivalStreet")
    private String derivalStreet;

    @ColumnInfo(name = "derivalHouse")
    private String derivalHouse;

    @ColumnInfo(name = "arrivalCity")
    private String arrivalCity;

    @ColumnInfo(name = "arrivalStreet")
    private String arrivalStreet;

    @ColumnInfo(name = "arrivalHouse")
    private String arrivalHouse;

    public String getCargoDescription() {
        return cargoDescription;
    }

    public void setCargoDescription(String cargoDescription) {
        this.cargoDescription = cargoDescription;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(String  cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(String cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    public String getCargoQuantity() {
        return cargoQuantity;
    }

    public void setCargoQuantity(String cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    public String getDerivalCity() {
        return derivalCity;
    }

    public void setDerivalCity(String derivalCity) {
        this.derivalCity = derivalCity;
    }

    public String getDerivalStreet() {
        return derivalStreet;
    }

    public void setDerivalStreet(String derivalStreet) {
        this.derivalStreet = derivalStreet;
    }

    public String getDerivalHouse() {
        return derivalHouse;
    }

    public void setDerivalHouse(String derivalHouse) {
        this.derivalHouse = derivalHouse;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalStreet() {
        return arrivalStreet;
    }

    public void setArrivalStreet(String arrivalStreet) {
        this.arrivalStreet = arrivalStreet;
    }

    public String getArrivalHouse() {
        return arrivalHouse;
    }

    public void setArrivalHouse(String arrivalHouse) {
        this.arrivalHouse = arrivalHouse;
    }
}
