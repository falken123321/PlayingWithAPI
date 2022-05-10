package com.example.playingwithapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.playingwithapi.model.beer;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String EndPointURL = "https://random-data-api.com/api/beer/random_beer";
    String responseToString = "Diller";
    beer b = new beer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNewBeer();

        Button getNewBeerBtn = findViewById(R.id.GetNewBeerBtn);
        getNewBeerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNewBeer();
            }
        });
    }

    public void getNewBeer() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                EndPointURL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println("Succes");
                        System.out.println("Rest response: " + response.toString());
                        responseToString = response.toString();


                        //TODO: Lav object og sæt værdier her



                        b.setFromJsonString(response);
                        if (b.getName().length() > 25) {
                            getNewBeer();
                        } else {
                            //BEER NAME
                            TextView BeerName = findViewById(R.id.beerName);
                            BeerName.setText(b.getName());
                            BeerName.setTextSize(24);
                            BeerName.setTextColor(getResources().getColor(R.color.blue));

                            //BEER BRAND
                            TextView BeerBrand = findViewById(R.id.beerBrand);
                            BeerBrand.setText("Brand: " +b.getBrand());

                            //BEER STYLE
                            TextView BeerStyle = findViewById(R.id.beerStyle);
                            BeerStyle.setText("Style: " +b.getStyle());

                            //BEER ALCOHOL
                            TextView BeerAlcohol = findViewById(R.id.beerAlcohol);
                            BeerAlcohol.setText("Alcohol: " +b.getAlcohol());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error: " + error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);



    }
}

//