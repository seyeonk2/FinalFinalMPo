package com.example.kierstinkim.finalfinalmp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "FinalFinalMPo:Main";

    /** Request queue for our API requests. */
    private static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.imageView);
        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "American button clicked");
                startAPICall();
            }
        });
        final Button button2 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "American button clicked");
                startAPICall();
            }
        });
        final Button button3 = findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "American button clicked");
                startAPICall();
            }
        });
        final Button button4 = findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "American button clicked");
                startAPICall();
            }
        });
        final Button button5 = findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "American button clicked");
                startAPICall();
            }
        });
        final Button button6 = findViewById(R.id.button6);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "American button clicked");
                startAPICall();
            }
        });
        final TextView textView = findViewById(R.id.textView);
        final Button button = findViewById(R.id.button);

    }

    public void browser(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yelp.com/"));
        startActivity(browserIntent);
    }

    RequestQueue queue = Volley.newRequestQueue(this);

    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://api.yelp.com/v3/businesses/search.API_KEY"
                            + BuildConfig.API_KEY,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            try {
                                Log.d(TAG, response.toString(2));
                            } catch (JSONException ignored) { }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.e(TAG, error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String getAmerican() {
            return "none";
    }
    private String getChinese() {
        return "none";
    }
    private String getItalian() {
        return "none";
    }
    private String getKorean() {
        return "none";
    }
    private String getMexican() {
        return "none";
    }
    private String getThai() {
        return "none";
    }
    private String getRandom(final String json) {
        if (json == null) {
            return "No resturant available";
        }
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonArray businesses = result.getAsJsonArray("businesses");
        int x = (int)(Math.random()) * businesses.size();
        JsonArray array = businesses.get(x).getAsJsonArray();
        int y = (int)(Math.random()) * array.size();
        JsonObject categories = array.get(y).getAsJsonObject();
        String title = categories.getAsJsonObject("title").getAsString();
        return title;
    }
}


