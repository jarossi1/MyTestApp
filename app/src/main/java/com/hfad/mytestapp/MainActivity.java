package com.hfad.mytestapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BeerExpert expert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        expert = new BeerExpert(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

    }
    public void onClickFindBeer(View view) {
        // Get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        // Get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        ImageView beerImage = (ImageView) findViewById(R.id.beerImage);

        // Get the selected item in the Spinner, Convert to a string
        String beerType = String.valueOf(color.getSelectedItem());

        TextView beerDescription = findViewById(R.id.description);

        // Get recommendations from the BeerExpert class
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }

        int imageResId = expert.getImageResID(beerType);
        beerImage.setImageResource(imageResId);

        //display the beers
        brands.setText(brandsFormatted);

        String description = expert.getDescription(beerType);
        beerDescription.setText(description);
    }
}