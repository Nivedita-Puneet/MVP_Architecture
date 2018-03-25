package com.nivedita.pagination.util;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PUNEETU on 18-03-2018.
 */

public class JSONResponse {

    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "used by Retrofit"})
    public JSONResponse() {
    }

    public JSONResponse(String status) {
        this.status = status;
    }

}
