package design.mozhay.transcargo.data.entity.rest.dellin.rawResult;

import com.google.gson.annotations.SerializedName;

public class DLRawDeliveryVariant {

    @SerializedName("preiod_from")
    private int mPeriodFrom;

    @SerializedName("period_to")
    private int mPeriodTo;

    @SerializedName("price")
    private float mPrice;

    public int getPeriodFrom(){
        return mPeriodFrom;
    }

    public int getPeriodTo(){
        return mPeriodTo;
    }

    public float getPrice() {
        return mPrice;
    }
}
