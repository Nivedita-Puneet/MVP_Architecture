package com.nivedita.aboutcanada.apiservice;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NEETU on 27-02-2018.
 */

/*Class used to deserialize json response.*/
public class Response {
    @SerializedName("status")
    public String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"unused", "used by Retrofit"})
    public Response() {
    }

    public Response(String status) {
        this.status = status;
    }

}
