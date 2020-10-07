package design.mozhay.transcargo.data.entity.rest.dellin.rawResult;

import com.google.gson.annotations.SerializedName;

public class DLRawSessionID {

    @SerializedName("sessionID")
    private String mSessionID;

    public String getSessionID(){
        return mSessionID;
    }
}
