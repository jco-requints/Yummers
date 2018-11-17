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

    ListView list;
    Integer[] japan_images = {R.drawable.teriyaki, R.drawable.sushi, R.drawable.tempura, R.drawable.sashimi};
    Integer[] italian_images = {R.drawable.pizza, R.drawable.spaghetti, R.drawable.lasagna, R.drawable.risotto};
    Integer[] filipino_images = {R.drawable.sinigang, R.drawable.sisig, R.drawable.adobo, R.drawable.nilaga};

    String[] JAPANESE = {"Chicken Teriyaki", "Sushi Roll", "Tempura", "Sashimi"};
    String[] ITALIAN = {"Pizza", "Spaghetti", "Lasagna", "Risotto"};
    String[] FILIPINO = {"Sinigang na Baboy", "Pork Sisig", "Chicken Adobo", "Nilagang Baka"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_recipes);

        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();

        //code for the text if japanese, italian or filipino food...
        TextView textViewToChange = findViewById(R.id.food_category);
        if (extras != null) {
            String str = extras.getString("category");
            textViewToChange.setText(str);
        }


        String foodCategory = textViewToChange.getText().toString();
        if(foodCategory.equals("Japanese")){
            setContentView(R.layout.display_recipes);

            CustomListAdapter adapter=new CustomListAdapter(this, JAPANESE, japan_images);
            list= findViewById(R.id.LIST);
            list.setAdapter(adapter);

            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = null;
                    i = new Intent(DisplayRecipes.this, ShowRecipe.class);
                    String selectedFoodName = list.getItemAtPosition(position).toString();
                    i.putExtra("food_name", selectedFoodName);
                    startActivity(i);
                }
            });
        }
        else if(foodCategory.equals("Italian")){
            setContentView(R.layout.display_recipes);

            CustomListAdapter adapter=new CustomListAdapter(this, ITALIAN, italian_images);
            list = findViewById(R.id.LIST);
            list.setAdapter(adapter);

            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = null;
                    i = new Intent(DisplayRecipes.this, ShowRecipe.class);
                    String selectedFoodName = list.getItemAtPosition(position).toString();
                    i.putExtra("food_name", selectedFoodName);
                    startActivity(i);
                }
            });
        }
        else if(foodCategory.equals("Filipino")){
            setContentView(R.layout.display_recipes);

            CustomListAdapter adapter=new CustomListAdapter(this, FILIPINO, filipino_images);
            list = findViewById(R.id.LIST);
            list.setAdapter(adapter);

            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = null;
                    i = new Intent(DisplayRecipes.this, ShowRecipe.class);
                    String selectedFoodName = list.getItemAtPosition(position).toString();
                    i.putExtra("food_name", selectedFoodName);
                    startActivity(i);
                }
            });
        }



        startService(i);

    }


}
