package com.hfad.mytestapp;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeerExpert {

    private Map<String, List<String>> beerMap;
    private Map<String, String> beerDescriptionMap;
    private Map<String, Integer> beerImageMap;
    private Context context;

    public BeerExpert(Context context) {
        this.context = context;
        beerMap = new HashMap<>();
        beerImageMap = new HashMap<>();
        beerDescriptionMap = new HashMap<>();
        initializeBeers();
        initializeBeerImages();
        initializeBeerDescriptions();
    }

    private void initializeBeers() {
        List<String> amberBeers = new ArrayList<>();
        amberBeers.add("Jack Amber");
        amberBeers.add("Red Moose");
        beerMap.put("amber", amberBeers);

        List<String> lightBeers = new ArrayList<>();
        lightBeers.add("Lite Beer");
        lightBeers.add("Pale Ale");
        beerMap.put("light", lightBeers);

        List<String> brownBeers = new ArrayList<>();
        brownBeers.add("Brown Ale");
        brownBeers.add("Nut Brown Ale");
        beerMap.put("brown", brownBeers);

        List<String> darkBeers = new ArrayList<>();
        darkBeers.add("Stout");
        darkBeers.add("Porter");
        beerMap.put("dark", darkBeers);
    }

    private void initializeBeerImages() {
        beerImageMap.put("amber", R.drawable.amber);
        beerImageMap.put("light", R.drawable.light);
        beerImageMap.put("brown", R.drawable.brown);
        beerImageMap.put("dark", R.drawable.dark);
    }

    private void initializeBeerDescriptions() {
        // Use context to fetch string resources
        beerDescriptionMap.put("amber", context.getString(R.string.beer_description_amber));
        beerDescriptionMap.put("light", context.getString(R.string.beer_description_light));
        beerDescriptionMap.put("brown", context.getString(R.string.beer_description_brown));
        beerDescriptionMap.put("dark", context.getString(R.string.beer_description_dark));
    }


    public List<String> getBrands(String color) {
        return beerMap.getOrDefault(color, new ArrayList<>());
    }

    public int getImageResID(String color) {
        return beerImageMap.getOrDefault(color, R.drawable.defaultbeer);
    }

    // Updated method to use Context for default description
    public String getDescription(String color) {
        return beerDescriptionMap.getOrDefault(color, context.getString(R.string.beer_description_default));
    }

}



