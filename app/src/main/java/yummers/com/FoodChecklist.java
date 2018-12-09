package yummers.com;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodChecklist extends AppCompatActivity {

    ListView checkListView;
    ChecklistAdapter adapter;
    TextView title;
    String foodName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_checklist);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();


        checkListView = (ListView)findViewById(R.id.ingredients_checklist);

        TextView textViewToChange = (TextView) findViewById(R.id.checklist_title);

        if (extras != null) {
            String str = extras.getString("checklist_title");
            textViewToChange.setText(str);
        }

        foodName = textViewToChange.getText().toString();


        if(foodName.equals("Chicken Teriyaki")){
            String[] INGREDIENTS = {"1/4 cup soy sauce", "1/3 cup fresh orange juice", "3 Tbsp honey",
                    "1 tsp finely grated fresh ginger", "1 tsp sesame oil", "1 1/2 to 2 lbs chicken thighs", "1 Tbsp oil (I use light olive oil)",
                    "1 1/2 Tbsp unsalted butter", "Green onion and sesame seeds"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Sushi Roll")){
            String[] INGREDIENTS = {"2/3 Japanese rice", "3 tablespoons rice vinegar",
                    "3 tablespoons white sugar", "1 1/2 teaspoons salt", "4 sheets nori seaweed sheets",
                    "1/2 cucumber, peeled", "2 tablespoons pickled ginger", "1 avocado", "1/2 pound imitation crabmeat"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Tempura")){
            String[] INGREDIENTS = {"Plain flour: 100g (1Cup)", "Egg: 1",
                    "Cold water: 200cc (1Cup)", "Baking Soda: 1 tea spoon", "Potato Starch: 2 table spoon",
                    "Prawns", "Cooking oil"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Sashimi")){
            String[] INGREDIENTS = {"500g sashimi-grade tuna",
                    "2 avocados, cut into thick slices",
                    "2 tablespoons extra virgin olive oil",
                    "1 tablespoon lime juice",
                    "4 spring onions, finely sliced",
                    "1/2 cup (125ml) light soy sauce"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Pizza")){
            String[] INGREDIENTS = {
                    "1 1/2 cups (355 ml) warm water",
                    "2 1/4 teaspoons of active dry yeast",
                    "3 3/4 cups (490 g) bread flour",
                    "2 Tbsp olive oil",
                    "2 teaspoons salt",
                    "1 teaspoon sugar",
                    "Olive oil Cornmeal",
                    "Tomato sauce",
                    "Firm mozzarella cheese, grated",
                    "Fresh soft mozzarella cheese",
                    "Fontina cheese",
                    "Parmesan cheese",
                    "Feta cheese, crumbled",
                    "Mushrooms, thinly sliced",
                    "Bell peppers",
                    "Italian pepperoncini",
                    "Italian sausage",
                    "Chopped fresh basil",
                    "Baby arugula",
                    "Pesto",
                    "Pepperoni, thinly sliced"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Spaghetti")){
            String[] INGREDIENTS = {"12 ounces dry spaghetti", "2 tablespoons canola oil",
                    "1 cup chopped onion", "2 tablespoons minced garlic", "1 pound ground round beef", "1 can pasta sauce",
                    "Grated Parmesan cheese"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Lasagna")){
            String[] INGREDIENTS = {"9 lasagna noodles",
                    "1-1/4 pounds Italian sausage",
                    "3/4 pound ground beef",
                    "1 medium onion, diced",
                    "3 garlic cloves, minced",
                    "2 cans crushed tomatoes",
                    "2 cans tomato paste",
                    "2/3 cup water",
                    "2 to 3 tablespoons sugar",
                    "1/4 cup minced fresh parsley",
                    "2 teaspoons dried basil",
                    "3/4 teaspoon fennel seed",
                    "3/4 teaspoon salt, divided",
                    "1/4 teaspoon ground pepper",
                    "1 large egg, lightly beaten",
                    "1 carton ricotta cheese",
                    "4 cups mozzarella cheese",
                    "3/4 cup grated Parmesan cheese"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Risotto")){
            String[] INGREDIENTS = {"1 onion",
                    "2 tbsp olive oil",
                    "knob of butter",
                    "6 rashers streaky bacon",
                    "300g risotto rice",
                    "1l hot vegetable stock",
                    "100g frozen peas",
                    "freshly grated parmesan"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Sinigang na Baboy")){
            String[] INGREDIENTS = {"500 grams pork, sinigang cut",
                    "water, for boiling",
                    "1 medium tomatoes, quartered",
                    "1 small onion, quartered",
                    "1 cup gabi, cubed",
                    "3 to 4 tablespoons sinigang mix",
                    "1 piece green chili",
                    "1 to 2 tablespoons fish sauce",
                    "1/2 cup green beans",
                    "1/4 cup radish",
                    "1/2 cup okra",
                    "2 cups kangkong",
                    "salt, to taste",};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Pork Sisig")){
            String[] INGREDIENTS = {"water",
                    "1 kilo pork (face)",
                    "2 tablespoons vegetable oil",
                    "1 large onion, minced",
                    "3 cloves garlic",
                    "1 ginger, minced",
                    "3 pieces finger chilies",
                    "3 tablespoons soy sauce",
                    "3-5 pieces calamansi",
                    "1/4 kilo chicken liver",
                    "salt",
                    "black pepper"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Chicken Adobo")){
            String[] INGREDIENTS = {"2 large potatoes",
                    "1/4 cup soy sauce",
                    "1 head garlic",
                    "1 onion",
                    "1/2 teaspoon peppercorns",
                    "2 bay leaves",
                    "1/4 cup oil",
                    "1 whole (3 to 4 pounds) chicken",
                    "1/2 cup vinegar",
                    "1 cup water",
                    "salt and pepper to taste"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }
        else if(foodName.equals("Nilagang Baka")){
            String[] INGREDIENTS = {"2 lbs bone-in beef shank,",
                    "2 medium onions",
                    "1 tsp kosher salt",
                    "1 tsp whole peppercorns",
                    "5 medium size yellow potatoes",
                    "1 medium green cabbage",
                    "4 pieces ripe saba",
                    "Fish sauce or salt to taste"};
            setContentView(R.layout.recipe_checklist);
            //code to display food category
            title = findViewById(R.id.checklist_title);
            title.setText(foodName);

            adapter=new ChecklistAdapter(this, INGREDIENTS);
            checkListView = findViewById(R.id.ingredients_checklist);
            checkListView.setAdapter(adapter);
        }



        startService(i);

    }






}
