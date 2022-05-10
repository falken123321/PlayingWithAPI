package com.example.playingwithapi.model;

import android.widget.TextView;

import com.example.playingwithapi.R;

import org.json.JSONException;
import org.json.JSONObject;

public class beer {
    String id;
    String uid;
    String brand;
    String name;
    String style;
    String hop;
    String yeast;
    String malts;
    String ibu;
    String alcohol;
    String blg;

    public void setFromJsonString(JSONObject jsonObject) {
        try {
            id = jsonObject.getString("id");
            uid = jsonObject.getString("uid");
            brand = jsonObject.getString("brand");
            name = jsonObject.getString("name");
            style = jsonObject.getString("style");
            hop = jsonObject.getString("hop");
            yeast = jsonObject.getString("yeast");
            malts = jsonObject.getString("malts");
            ibu = jsonObject.getString("ibu");
            alcohol = jsonObject.getString("alcohol");
            blg = jsonObject.getString("blg");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getAlcohol() {
        return alcohol;
    }

    public String getBlg() {
        return blg;
    }

    public String getBrand() {
        return brand;
    }

    public String getHop() {
        return hop;
    }

    public String getIbu() {
        return ibu;
    }

    public String getId() {
        return id;
    }

    public String getMalts() {
        return malts;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public String getUid() {
        return uid;
    }

    public String getYeast() {
        return yeast;
    }

    public void setBlg(String blg) {
        this.blg = blg;
    }
}




