package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.example.myapplication.Model.BlogResource;
import com.example.myapplication.Retrofit.ApiClient;
import com.example.myapplication.Retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





       ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);


        /**
         GET List Resources
         **/
        Call<BlogResource> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<BlogResource>() {
            @Override
            public void onResponse(Call<BlogResource> call, Response<BlogResource> response) {


               // Log.d("TAG",response.code()+"");

                String displayResponse = "";

                BlogResource resource = response.body();
                /*Integer text = resource.page;
                Integer total = resource.total;
                Integer totalPages = resource.totalPages;
                List<MultipleResource.Datum> datumList = resource.data;

                displayResponse += text + " Page\n" + total + " Total\n" + totalPages + " Total Pages\n";

                for (MultipleResource.Datum datum : datumList) {
                    displayResponse += datum.id + " " + datum.name + " " + datum.pantoneValue + " " + datum.year + "\n";
                }

                responseText.setText(displayResponse);*/

            }

            @Override
            public void onFailure(Call<BlogResource> call, Throwable t) {
                call.cancel();
            }
        });


    }
}