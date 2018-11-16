package yummers.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayRecipes extends AppCompatActivity {

    int[] IMAGES = {};

    String[] JAPANESE = {"Chicken Teriyaki", "Sushi Roll", "Tempura", "Sashimi"};
    String[] ITALIAN = {"Pizza", "Spaghetti", "Lasagna", "Risotto", "Gelato"};
    String[] FILIPINO = {"Sinigang na Baboy", "Pork Sisig", "Chicken Adobo", "Crispy Pata", "Nilagang Baka"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_recipes);

        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();

        //code for the text if japanese, italian or filipino food...
        TextView textViewToChange = (TextView) findViewById(R.id.food_category);
        if (extras != null) {
            String str = extras.getString("category");
            textViewToChange.setText(str);
        }


        final ListView listView = (ListView)findViewById(R.id.foodList);
        String foodCategory = textViewToChange.getText().toString();
        if(foodCategory.equals("Japanese")){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, JAPANESE);

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = null;
                    i = new Intent(DisplayRecipes.this, ShowRecipe.class);
                    String selectedFoodName = listView.getItemAtPosition(position).toString();
                    i.putExtra("food_name", selectedFoodName);
                    startActivity(i);
                }
            });
        }
        else if(foodCategory.equals("Italian")){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ITALIAN);

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = null;
                    i = new Intent(DisplayRecipes.this, ShowRecipe.class);
                    String selectedFoodName = listView.getItemAtPosition(position).toString();
                    i.putExtra("food_name", selectedFoodName);
                    startActivity(i);
                }
            });
        }
        else if(foodCategory.equals("Filipino")){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, FILIPINO);

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = null;
                    i = new Intent(DisplayRecipes.this, ShowRecipe.class);
                    String selectedFoodName = listView.getItemAtPosition(position).toString();
                    i.putExtra("food_name", selectedFoodName);
                    startActivity(i);
                }
            });
        }



        startService(i);

    }


}
