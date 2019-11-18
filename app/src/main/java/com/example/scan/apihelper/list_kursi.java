package com.example.scan.apihelper;

import com.google.gson.annotations.SerializedName;

public class list_kursi {
    private boolean isSelect, isBooking;
    @SerializedName("id_kursi")
    private String id_kursi;
    @SerializedName("Kursi")
    private String Kursi;
    @SerializedName("s_kursi")
    private String s_kursi;

    public String getId_kursi() {
        return id_kursi;
    }
    public String getKursi() {
        return Kursi;
    }
    public String getS_kursi() {
        return s_kursi;
    }
    public boolean isSelect() {
        return isSelect;
    }
    public void setSelect(boolean select) {
        isSelect = select;
    }
    public void setBooking(boolean select) {
        isBooking = select;
    }

    public boolean isBooking() {
        return isBooking;
    }

}
