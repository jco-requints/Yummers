package yummers.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class ShowRecipe extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_recipe);

        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();

        TextView textViewToChange = (TextView) findViewById(R.id.food_name);
        if (extras != null) {
            String str = extras.getString("food_name");
            textViewToChange.setText(str);
        }

        final ListView listView = (ListView)findViewById(R.id.ingredientsList);
        final String foodName = textViewToChange.getText().toString();

        if(foodName.equals("Chicken Teriyaki")){
            String[] INGREDIENTS = {"1 cup soy sauce", "1 cup granulated sugar", "1 1/2 teaspoon brown sugar",
                    "6 gloves garlic, crushed in a press", "2 tablespoon grated fresh ginger"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Sushi Roll")){
            String[] INGREDIENTS = {"2/3 cup uncooked short-grain white rice", "3 tablespoons rice vinegar",
                    "3 tablespoons white sugar", "1 1/2 teaspoons salt", "4 sheets nori seaweed sheets",
                    "1/2 cucumber, peeled, cut into small strips", "2 tablespoons pickled ginger", "1 avocado", "1/2 pound imitation crabmeat, " +
                    "flaked"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Tempura")){
            String[] INGREDIENTS = {"Plain flour: 100g (1Cup)", "Egg: 1",
                    "Cold water: 200cc (1Cup)", "Baking Soda: 1 tea spoon", "Potato Starch: 2 table spoon",
                    "Your choice of vegetables, sea foods and mushrooms", "Oil (Natane oil, sunflower, corn or canola oil)"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Sashimi")){
            String[] INGREDIENTS = {"500g sashimi-grade tuna",
                    "2 avocados, flesh cut into thick slices",
                    "2 tablespoons extra virgin olive oil",
                    "1 tablespoon lime juice, plus extra lime to serve",
                    "4 spring onions, finely sliced on the diagonal",
                    "1/2 cup (125ml) light soy sauce"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Pizza")){
            String[] INGREDIENTS = {"1 1/2 cups (355 ml) warm water (105°F-115°F)",
                    "1 package (2 1/4 teaspoons) of active dry yeast",
                    "3 3/4 cups (490 g) bread flour",
                    "2 Tbsp olive oil (omit if cooking pizza in a wood-fired pizza oven)",
                    "2 teaspoons salt",
                    "1 teaspoon sugar"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Spaghetti")){
            String[] INGREDIENTS = {"1 lb. spaghetti noodles", "1 lb. Italian tomato sauce",
                    "8 ounces tomato paste", "2 tablespoons minced onion", "2 tablespoons minced garlic", "2 tablespoons oil",
                    "1 lb. ground pork", "½ cup minced carrots and red peppers", "2 cups diced or thinly sliced hot dogs",
                    "1 cup water", "1 tablespoon salt", "1 teaspoon seasoning mix", "7 ounces evaporated milk",
                    "grated cheese for topping"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }

        startService(i);
    }





}
