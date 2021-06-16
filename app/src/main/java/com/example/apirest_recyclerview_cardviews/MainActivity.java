package com.example.apirest_recyclerview_cardviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.apirest_recyclerview_cardviews.adapters.RevistaAdapter;
import com.example.apirest_recyclerview_cardviews.models.revista;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private RevistaAdapter mAdapter;
    private ArrayList<revista> mRevistaList = new ArrayList<>();

    private static final String URL1 = "https://revistas.uteq.edu.ec/ws/issues.php?j_id=2";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvRevistas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Prueballenar();
        jsonArrayRequest();
    }

    private void jsonArrayRequest(){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL1,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        int size = response.length();
                        for(int i=0; i<size; i++){
                            try {
                                JSONObject jsonObject = new JSONObject(response.get(i).toString());
                                int issue_id = Integer.parseInt(jsonObject.getString("issue_id"));
                                String titulo = jsonObject.getString("title");
                                int volumen = Integer.parseInt(jsonObject.getString("volume"));
                                int numero = Integer.parseInt(jsonObject.getString("number"));
                                int anio = Integer.parseInt(jsonObject.getString("year"));
                                //String cover = "https://revistas.uteq.edu.ec/public/journals/2/cover_issue_82_es_ES.jpg";
                                String cover = jsonObject.getString("cover");
                                mRevistaList.add(new revista(1, titulo, volumen, numero, anio, cover));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        mAdapter = new RevistaAdapter(mRevistaList, R.layout.revistas_view, MainActivity.this);
                        mRecyclerView.setAdapter(mAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }

    private void Prueballenar(){
        mRevistaList.clear();
        for(int i = 0; i < 10; i++){
            String titulo = "El titulo";
            int volumen = 2;
            int numero = 33;
            int anio = 2020;
            String cover = "https://revistas.uteq.edu.ec/public/journals/2/cover_issue_82_es_ES.jpg";
            mRevistaList.add(new revista(1, titulo, volumen, numero, anio, cover));
        }
        mAdapter = new RevistaAdapter(mRevistaList, R.layout.revistas_view, MainActivity.this);
        mRecyclerView.setAdapter(mAdapter);

    }



}