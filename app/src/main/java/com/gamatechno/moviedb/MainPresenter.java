package com.gamatechno.moviedb;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.gamatechno.moviedb.Common.API_KEY;
import static com.gamatechno.moviedb.Common.BASE_URL;

public class MainPresenter implements MainView.Presenter {

    Context context;
    MainView.View view;
    Gson gson;

    @Override
    public void onGetMovie() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, BASE_URL + "discover/movie?api_key=" + API_KEY + "&language=en-US"
        , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    ArrayList<MovieModel> movieModelsArrayList = new ArrayList<>();
                    JSONArray jsonArray = jsonObject.getJSONArray( "results" );
                    for (int i = 0; i < jsonObject.length(); i++) {
                        movieModelsArrayList.add(gson.fromJson(jsonArray.get(i).toString(), MovieModel.class));
                    }
                    view.onSuksesMovie(movieModelsArrayList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        ReqController.getInstance().addToRequestQueue(stringRequest);
    }

    public MainPresenter(Context context, MainView.View view) {
        this.context = context;
        this.view = view;
        gson = new Gson();
    }

}
