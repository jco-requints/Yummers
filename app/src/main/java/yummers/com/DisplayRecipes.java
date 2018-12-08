package yummers.com;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class DisplayRecipes extends AppCompatActivity {

    ListView list;
    ImageView image;
    TextView text;
    CustomListAdapter adapter;
    Integer[] japan_images = {R.drawable.teriyaki, R.drawable.sushi, R.drawable.tempura, R.drawable.sashimi};
    Integer[] italian_images = {R.drawable.pizza, R.drawable.spaghetti, R.drawable.lasagna, R.drawable.risotto};
    Integer[] filipino_images = {R.drawable.sinigang, R.drawable.sisig, R.drawable.adobo, R.drawable.nilaga};

    String[] JAPANESE = {"Chicken Teriyaki", "Sushi Roll", "Tempura", "Sashimi"};
    String[] ITALIAN = {"Pizza", "Spaghetti", "Lasagna", "Risotto"};
    String[] FILIPINO = {"Sinigang na Baboy", "Pork Sisig", "Chicken Adobo", "Nilagang Baka"};

    String[] JAPANESE_TIME = {"50min", "30mins", "45mins", "50mins"};
    String[] ITALIAN_TIME = {"55mins", "40mins", "50mins", "50mins"};
    String[] FILIPINO_TIME = {"40mins", "55mins", "45mins", "55mins"};



    ImageButton homeBtn;
    ImageButton searchBtn;
    ImageButton listBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_recipes);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar2);

        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();

        homeBtn = (ImageButton)findViewById(R.id.home);
        searchBtn = (ImageButton)findViewById(R.id.search);
        listBtn = (ImageButton)findViewById(R.id.shopping_list);



        list = (ListView) findViewById(R.id.LIST);

        //code for the text if japanese, italian or filipino food...
        TextView textViewToChange = findViewById(R.id.food_category);
        if (extras != null) {
            String str = extras.getString("category");
            textViewToChange.setText(str);
        }

        String foodCategory = textViewToChange.getText().toString();
        if(foodCategory.equals("Japanese")){
            setContentView(R.layout.display_recipes);
            image = findViewById(R.id.category);
            image.setImageResource(R.drawable.japanese_category);
            //code to display food category
            text = findViewById(R.id.food_category);
            text.setText(foodCategory);

            adapter=new CustomListAdapter(this, JAPANESE, JAPANESE_TIME, japan_images);
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
            image = findViewById(R.id.category);
            image.setImageResource(R.drawable.italian_category);
            //code to display food category
            text = findViewById(R.id.food_category);
            text.setText(foodCategory);

            adapter=new CustomListAdapter(this, ITALIAN, ITALIAN_TIME, italian_images);
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
            image = findViewById(R.id.category);
            image.setImageResource(R.drawable.filipino_category);
            //code to display food category
            text = findViewById(R.id.food_category);
            text.setText(foodCategory);

            adapter=new CustomListAdapter(this, FILIPINO, FILIPINO_TIME, filipino_images);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.LIST);
        SearchView searchView = (SearchView)item.getActionView();



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);

    }

    public void process(View v){
        Intent i = null, chooser = null;

        if(v.getId()==R.id.shopping_list){
            i = new Intent(DisplayRecipes.this, RecipeList.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.home){
            i = new Intent(DisplayRecipes.this, HomeActivity.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.search){

        }


    }








}
