package design.mozhay.transcargo.data.entity.rest.dellin.rawResult;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DLRawMicroCalcResult {

    @SerializedName("metadata")
    private DLRawMetadata mMetadata;

    @SerializedName("data")
    private List<DLRawDeliveryVariant> mDeliveryVariants;

}
