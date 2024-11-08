package com.example.verticalrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<FilterModel> filterModels = new ArrayList<>();
    int[] filterImages = {R.drawable.baseline_filter_1_24, R.drawable.baseline_filter_2_24,
                        R.drawable.baseline_filter_3_24, R.drawable.baseline_filter_4_24,
                        R.drawable.baseline_filter_5_24, R.drawable.baseline_filter_6_24,
                        R.drawable.baseline_filter_7_24, R.drawable.baseline_filter_7_24,
                        R.drawable.baseline_filter_8_24, R.drawable.baseline_filter_9_24,
                        R.drawable.baseline_filter_9_plus_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpFilterModels();

        F_RecyclerViewAdapter adapter = new F_RecyclerViewAdapter(this, filterModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setUpFilterModels();
    }

    private void setUpFilterModels() {
        String[] filterNames = getResources().getStringArray(R.array.filter_types);

        for (int i = 0; i < filterNames.length; i++) {
            filterModels.add(new FilterModel (filterNames[i], filterImages[i]));
        }
    }
}