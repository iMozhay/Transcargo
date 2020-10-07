package design.mozhay.transcargo.data.entity.rest.dellin.rawResult;

import com.google.gson.annotations.SerializedName;

public class DLRawAuthResult {

    @SerializedName("metadata")
    private DLRawMetadata mDellinMetadata;

    @SerializedName("data")
    private DLRawSessionID mRawSessionID;

    public DLRawMetadata getDellinMetadata() {
        return mDellinMetadata;
    }

    public DLRawSessionID getRawSessionID() {
        return mRawSessionID;
    }
}
