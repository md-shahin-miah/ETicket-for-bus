package com.shahin.ebusticket;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shahin.ebusticket.helpers.AbstractItem;
import com.shahin.ebusticket.adapters.AirplaneAdapter;
import com.shahin.ebusticket.helpers.CenterItem;
import com.shahin.ebusticket.helpers.EdgeItem;
import com.shahin.ebusticket.helpers.EmptyItem;
import com.shahin.ebusticket.helpers.OnSeatSelected;

import java.util.ArrayList;
import java.util.List;

public class SeatActivity extends AppCompatActivity implements OnSeatSelected {
    private static final int COLUMNS = 5;
    private TextView txtSeatSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_seat);
        txtSeatSelected =findViewById(R.id.txt_seat_selected);




        List<AbstractItem> items = new ArrayList<>();
        for (int i=0; i<30; i++) {

            if (i%COLUMNS==0 || i%COLUMNS==4) {
                items.add(new EdgeItem(String.valueOf(i)));
            } else if (i%COLUMNS==1 || i%COLUMNS==3) {
                items.add(new CenterItem(String.valueOf(i)));
            } else {
                items.add(new EmptyItem(String.valueOf(i)));
            }
        }

        GridLayoutManager manager = new GridLayoutManager(this, COLUMNS);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lst_items);
        recyclerView.setLayoutManager(manager);

        AirplaneAdapter adapter = new AirplaneAdapter(this, items);
        recyclerView.setAdapter(adapter);





    }


    @Override
    public void onSeatSelected(int count) {

        txtSeatSelected.setText("Book "+count+" seats");
    }

}
