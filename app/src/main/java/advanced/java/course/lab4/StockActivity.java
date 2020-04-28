package advanced.java.course.lab4;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class StockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_layout);

        final TextView apple = findViewById(R.id.apple);
        final TextView google = findViewById(R.id.alphabet);
        final TextView faceBook = findViewById(R.id.facebook);
        final TextView nokia = findViewById(R.id.nokia);
        final TextView redHat = findViewById(R.id.redhat);
        final TextView intel = findViewById(R.id.intel);

        fetchApi("Apple","AAPL", apple);
        fetchApi("Google", "GOOGL", google);
        fetchApi("Facebook", "FB", faceBook);
        fetchApi("Nokia", "NOK", nokia);
        fetchApi("Red hat", "RHT", redHat);
        fetchApi("Intel", "INTC", intel);
    }

    public void fetchApi(final String companyName, final String stockId, final TextView companyView) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://financialmodelingprep.com/api/company/price/"+stockId+"?datatype=json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject value = response.getJSONObject(stockId);
                            String price = value.getString("price");
                            companyView.setText(companyName + " : " + price + " USD");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "something went wrong!", Toast.LENGTH_LONG).show();
                        System.out.println(error);
                    }
                });

        queue.add(jsonObjectRequest);

//        final ListView listView = findViewById(R.id.list_view);
//        final String[] stocks = new String[] {};
//        final ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(stocks));
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
//        listView.setAdapter(arrayAdapter);
//
//
//        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
//        JsonObjectRequest facebookRequest =  new JsonObjectRequest(Request.Method.GET, "https://financialmodelingprep.com/api/company/price/FB?datatype=json", null,  new Response.Listener<JSONObject>() {
//
//
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONObject object = response.getJSONObject("FB");
//                    String price = object.getString("price");
//                    String facebookStock = "Facebook: " + price + " USD";
//                    arrayList.add(facebookStock);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        queue.add(facebookRequest);
//
//
//        JsonObjectRequest appleRequest =  new JsonObjectRequest(Request.Method.GET, "https://financialmodelingprep.com/api/company/price/AAPL?datatype=json", null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONObject object = response.getJSONObject("AAPL");
//                    String price = object.getString("price");
//                    String appleStock = "Apple: " + price + " USD";
//                    arrayList.add(appleStock);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        queue.add(appleRequest);
//
//
//        JsonObjectRequest googleRequest =  new JsonObjectRequest(Request.Method.GET, "https://financialmodelingprep.com/api/company/price/GOOGL?datatype=json", null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONObject object = response.getJSONObject("GOOGL");
//                    String price = object.getString("price");
//                    String googleStock = "Google: " + price + " USD";
//                    arrayList.add(googleStock);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        queue.add(googleRequest);
//
//
//
//        JsonObjectRequest nokiaRequest =  new JsonObjectRequest(Request.Method.GET, "https://financialmodelingprep.com/api/company/price/NOK?datatype=json", null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONObject object = response.getJSONObject("NOK");
//                    String price = object.getString("price");
//                    String nokiaStock = "Nokia: " + price + " USD";
//                    arrayList.add(nokiaStock);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        queue.add(nokiaRequest);

    }

}
