package com.example.scan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scan.apihelper.BaseApiService;
import com.example.scan.apihelper.UtilsApi;
import com.example.scan.apihelper.list_kursi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class costum_dialog extends AppCompatActivity {
    Button kirim;
    String mkursi;
    private BaseApiService apiInterface;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<list_kursi> listkursi;
    StringBuilder appendBooked;
    ad_kursi adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.costum_dialog);
        Intent intent = getIntent();
//        mnorek = intent.getStringExtra("norek");
        mkursi = intent.getStringExtra("id_pesan");
        recyclerView = findViewById(R.id.listkursi);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
                createTable("" + mkursi);
    }

    private void createTable(String type) {
        apiInterface = UtilsApi.getAPIService();

        Call<List<list_kursi>> call = apiInterface.getKursi(type);
        call.enqueue(new Callback<List<list_kursi>>() {
            @Override
            public void onResponse(Call<List<list_kursi>> call, Response<List<list_kursi>> response) {
                listkursi = response.body();
                adapter = new ad_kursi(listkursi, costum_dialog.this, appendBooked);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<list_kursi>> call, Throwable t) {

                Toast.makeText(costum_dialog.this, "Error\n" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
//        room = new Room(this,tableLayout, titleTextView, ROW, COL, filmDatabase.getSeats(showId));
//
    }
}
