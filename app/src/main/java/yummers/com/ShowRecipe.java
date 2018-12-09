package yummers.com;

import android.app.ActionBar;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ShowRecipe extends AppCompatActivity {

    ImageView image;

    ImageButton addBtn;

    private DatabaseReference mDatabase;

    String foodName;
    ArrayList<String> mShoppingList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_recipe);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar2);

        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();

        addBtn = (ImageButton)findViewById(R.id.addToListBtn);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("shopping_list");

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                mShoppingList.add(value);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        TextView textViewToChange = (TextView) findViewById(R.id.food_name);
        if (extras != null) {
            String str = extras.getString("food_name");
            textViewToChange.setText(str);
        }

        final ListView listView = (ListView)findViewById(R.id.ingredientsList);
        foodName = textViewToChange.getText().toString();

        if(foodName.equals("Chicken Teriyaki")){
            String[] INGREDIENTS = {"1/4 cup soy sauce", "1/3 cup fresh orange juice", "3 Tbsp honey",
                    "1 tsp finely grated fresh ginger", "1 tsp sesame oil", "1 1/2 to 2 lbs chicken thighs", "1 Tbsp oil (I use light olive oil)",
                    "1 1/2 Tbsp unsalted butter", "Green onion and sesame seeds",
                    "STEPS:",
                    "1. In a large bowl, whisk together all marinade ingredients: 1/4 cup soy sauce, 1/3 cup orange juice, 3 Tbsp honey, 1 tsp ginger and 1 tsp sesame oil.\n" + "\n",
                    "2. Cut chicken into 1-inch pieces and place into marinade. Stir and cover with plastic wrap and marinate on the counter 20 min.\n" + "\n",
                    "3. Heat a large non-stick pan over medium-high heat. Add 1 Tbsp olive oil. Remove chicken from marinade with a slotted spoon, reserving marinade in the bowl. Add chicken to the hot pan and sauté, stirring occasionally until golden and cooked through (5 min).\n" + "\n",
                    "4. Remove pan from heat and transfer chicken to a bowl.\n" + "\n",
                    "5. Pour reserved marinade into the pan, add 1 1/2 Tbsp butter (it’s in bold for my own sake because I’ve forgotten it before and it just wasn’t the same) and place back over medium/high heat. Bring to a boil stirring constantly until slightly thickened (1 min) then remove from heat. Add chicken back to the pan and stir to combine.\n" + "\n",
                    "6. Serve over hot buttery white rice garnished with fresh green onion and a sprinkle of sesame seeds.\n" + "\n"};
//            String[] DIRECTIONS = {"STEPS:","1. In a large bowl, whisk together all marinade ingredients: 1/4 cup soy sauce, 1/3 cup orange juice, 3 Tbsp honey, 1 tsp ginger and 1 tsp sesame oil.\n" +
//                    "\n", "2. Cut chicken into 1-inch pieces and place into marinade. Stir and cover with plastic wrap and marinate on the counter 20 min.", "3. Heat a large non-stick pan over medium-high heat. Add 1 Tbsp olive oil. Remove chicken from marinade with a slotted spoon, reserving marinade in the bowl. Add chicken to the hot pan and sauté, stirring occasionally until golden and cooked through (5 min).\n" +
//                    "\n",
//                    "4. Remove pan from heat and transfer chicken to a bowl.", "5. Pour reserved marinade into the pan, add 1 1/2 Tbsp butter (it’s in bold for my own sake because I’ve forgotten it before and it just wasn’t the same) and place back over medium/high heat. Bring to a boil stirring constantly until slightly thickened (1 min) then remove from heat. Add chicken back to the pan and stir to combine.", "6. Serve over hot buttery white rice garnished with fresh green onion and a sprinkle of sesame seeds"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.teriyaki);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Sushi Roll")){
            String[] INGREDIENTS = {"2/3 Japanese rice", "3 tablespoons rice vinegar",
                    "3 tablespoons white sugar", "1 1/2 teaspoons salt", "4 sheets nori seaweed sheets",
                    "1/2 cucumber, peeled", "2 tablespoons pickled ginger", "1 avocado", "1/2 pound imitation crabmeat",
                    "STEPS:",
                    "1. In a medium saucepan, bring 1 1/3 cups water to a boil. Add rice, and stir. Reduce heat, cover, and simmer for 20 minutes. In a small bowl, mix the rice vinegar, sugar ,and salt. Blend the mixture into the rice.\n" + "\n",
                    "2. Preheat oven to 300 degrees F (150 degrees C). On a medium baking sheet, heat nori in the preheated oven 1 to 2 minutes, until warm.\n" + "\n",
                    "3. Center one sheet nori on a bamboo sushi mat. Wet your hands. Using your hands, spread a thin layer of rice on the sheet of nori, and press into a thin layer. Arrange 1/4 of the cucumber, ginger, avocado, and imitation crabmeat in a line down the center of the rice. Lift the end of the mat, and gently roll it over the ingredients, pressing gently. Roll it forward to make a complete roll. Repeat with remaining ingredients.\n" + "\n",
                    "4. Cut each roll into 4 to 6 slices using a wet, sharp knife.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.sushi);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Tempura")){
            String[] INGREDIENTS = {"Plain flour: 100g (1Cup)", "Egg: 1",
                    "Cold water: 200cc (1Cup)", "Baking Soda: 1 tea spoon", "Potato Starch: 2 table spoon",
                    "Prawns", "Cooking oil",
                    "STEPS:",
                    "1. Mix Plain flour, baking soda and potato starch together.  And then sift mixed flour as preparation.\n" + "\n",
                    "2. Crack an egg into the bowl and beat it roughly. Add the cold water and mix them.\n" + "\n",
                    "3. Put 1/3 mixed flour in to egg mixture and gently mix. Long cooking chop sticks are the best utensil for mixing tempura batter. If you do not have them, use a fork instead.\n" + "\n",
                    "4. Then add an additional 1/3 flour and mix.\n" + "\n",
                    "5. Finally, add the last 1/3 flour and mix.\n\n" + "\n",
                    "6. Important: Lumps in the flour is completely fine.  Do not mix it too much as you will get a lot of gluten which makes it heavy and un-crispy tempura batter.\n" + "\n",
                    "7. For the prawn, take off the head and shell, but keep the tail.\n" + "\n",
                    "8. Remove the sand vein.\n" + "\n",
                    "9. Scrape the tail to stop the oil spitting when you fry it.\n" + "\n",
                    "10. Half cut the abdomen side every 1cm.\n" + "\n",
                    "11. Then push back side to abdomen side by fingers.\n" + "\n",
                    "12. Heat up the frying oil to 170 degrees. \n" + "\n",
                    "13. Put prawn into the tempura batter bowl to coat them then carefully put them to the oil. Fry one side and then turn over and fry the other side.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.tempura);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Sashimi")){
            String[] INGREDIENTS = {"500g sashimi-grade tuna",
                    "2 avocados, cut into thick slices",
                    "2 tablespoons extra virgin olive oil",
                    "1 tablespoon lime juice",
                    "4 spring onions, finely sliced",
                    "1/2 cup (125ml) light soy sauce",
                    "STEPS:",
                    "1. Using a sharp knife, cut the tuna into 0.5cm slices. Place on a serving platter with the slices of avocado.\n" + "\n",
                    "2. Combine the extra virgin olive oil and lime juice. When ready to serve, dress the avocado and tuna with lime dressing. Garnish with spring onions and season with sea salt and pepper.\n" + "\n",
                    "3. Serve with the soy sauce for dipping, and extra lime if desired.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.sashimi);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Pizza")){
            String[] INGREDIENTS = {"1 1/2 cups (355 ml) warm water",
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
                    "Pepperoni, thinly sliced",
                    "STEPS:",
                    "1. Proof the yeast: Place the warm water in the large bowl of a heavy duty stand mixer. Sprinkle the yeast over the warm water and let it sit for 5 minutes until the yeast is dissolved." +
                            "After 5 minutes stir if the yeast hasn't dissolved completely. The yeast should begin to foam or bloom, indicating that the yeast is still active and alive.\n" + "\n",
                    "2. Make and knead the pizza dough: Using the mixing paddle attachment, mix in the flour, salt, sugar, and olive oil on low speed for a minute. Then replace the mixing paddle with the dough hook attachment." +
                            "Knead the pizza dough on low to medium speed using the dough hook about 7-10 minutes. If you don't have a mixer, you can mix the ingredients together and knead them by hand." +
                            "The dough should be a little sticky, or tacky to the touch. If it's too wet, sprinkle in a little more flour.\n" + "\n",
                    "3. Let the dough rise: Spread a thin layer of olive oil over the inside of a large bowl. Place the pizza dough in the bowl and turn it around so that it gets coated with the oil.\n" + "\n",
                    "3. Preheat pizza stone (or pizza pan or baking sheet): Place a pizza stone on a rack in the lower third of your oven. Preheat the oven to 475°F for at least 30 minutes, preferably an hour. " +
                            "If you don't have a pizza stone, you can use a pizza pan or a thick baking sheet; you need something that will not warp at high temperatures.\n" + "\n",
                    "4. Divide the dough into two balls: Remove the plastic cover from the dough. Dust your hands with flour and push the dough down so it deflates a bit. Divide the dough in half." +
                            "Form two round balls of dough. Place each in its own bowl, cover with plastic and let sit for 15 minutes (or up to 2 hours).\n" + "\n",
                    "5. Flatten dough ball, and stretch out into a round: Working one ball of dough at a time, take one ball of dough and flatten it with your hands on a slightly floured work surface.\n" + "\n",
                    "6. Brush dough top with olive oil: Use your finger tips to press down and make dents along the surface of the dough to prevent bubbling. " +
                            "Brush the top of the dough with olive oil (to prevent it from getting soggy from the toppings). Let rest another 10-15 minutes.\n" + "\n",
                    "7. Sprinkle pizza peel with corn meal, put flattened dough on top.\n" + "\n",
                    "8. Spread with tomato sauce and sprinkle with toppings: Spoon on the tomato sauce, sprinkle with cheese, and place your desired toppings on the pizza.\n" + "\n",
                    "9. Sprinkle cornmeal on pizza stone, slide pizza onto pizza stone in oven.\n" + "\n",
                    "10. Bake pizza: Bake pizza one at a time until the crust is browned and the cheese is golden, about 10-15 minutes. " +
                            "If you want, toward the end of the cooking time you can sprinkle on a little more cheese.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.pizza);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Spaghetti")){
            String[] INGREDIENTS = {"12 ounces dry spaghetti", "2 tablespoons canola oil",
                    "1 cup chopped onion", "2 tablespoons minced garlic", "1 pound ground round beef", "1 can pasta sauce",
                    "Grated Parmesan cheese",
                    "STEPS:",
                    "1. Cook spaghetti according to package directions.\n" + "\n",
                    "2. Meanwhile, heat oil in large skillet over medium-high heat. Add onion and garlic; cook 5 minutes or until onion is tender, stirring frequently. Add beef; cook 7 minutes or until beef is crumbled and no longer pink, stirring occasionally. Drain.\n" + "\n",
                    "3. Add pasta sauce to skillet; stir together. Simmer covered over medium-low heat 10 minutes or until hot. Drain spaghetti. Serve meat sauce with spaghetti. Sprinkle with cheese, if desired.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.spaghetti);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
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
                    "3/4 cup grated Parmesan cheese",
                    "STEPS:",
                    "1. Cook noodles according to package directions; drain. Meanwhile, in a Dutch oven, cook sausage, beef and onion over medium heat 8-10 minutes or until meat is no longer pink, breaking up meat into crumbles. Add garlic; cook 1 minute. Drain.\n" + "\n",
                    "2. Stir in tomatoes, tomato paste, water, sugar, 3 tablespoons parsley, basil, fennel, 1/2 teaspoon salt and pepper; bring to a boil. Reduce heat; simmer, uncovered, 30 minutes, stirring occasionally.\n" + "\n",
                    "3. In a small bowl, mix egg, ricotta cheese, and remaining parsley and salt.\n" + "\n",
                    "4. Preheat oven to 375°. Spread 2 cups meat sauce into an ungreased 13x9-in. baking dish. Layer with three noodles and a third of the ricotta mixture. Sprinkle with 1 cup mozzarella cheese and 2 tablespoons Parmesan cheese. Repeat layers twice. Top with remaining meat sauce and cheeses (dish will be full).\n" + "\n",
                    "5. Bake, covered, 25 minutes. Bake, uncovered, 25 minutes longer or until bubbly. Let stand 15 minutes before serving.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.lasagna);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Risotto")){
            String[] INGREDIENTS = {"1 onion",
                    "2 tbsp olive oil",
                    "knob of butter",
                    "6 rashers streaky bacon",
                    "300g risotto rice",
                    "1l hot vegetable stock",
                    "100g frozen peas",
                    "freshly grated parmesan",
                    "STEPS:",
                    "1. Finely chop 1 onion. Heat 2 tbsp olive oil and a knob of butter in a pan, add the onions and fry until lightly browned (about 7 minutes).\n" + "\n",
                    "2. Add 6 chopped rashers streaky bacon and fry for a further 5 minutes, until it starts to crisp.\n" + "\n",
                    "3. Add 300g risotto rice and 1l hot vegetable stock, and bring to the boil. Stir well, then reduce the heat and cook, covered, for 15-20 minutes until the rice is almost tender.\n" + "\n",
                    "4. Stir in 100g frozen peas, add a little salt and pepper and cook for a further 3 minutes, until the peas are cooked.\n" + "\n",
                    "5. Serve sprinkled with freshly grated parmesan and freshly ground black pepper.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.risotto);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
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
                    "salt, to taste",
                    "STEPS:",
                    "1. Place pork, tomatoes, and onions in a pot with enough water to cover pork, bring to a boil then lower the heat to simmer for 1-1 ½ hours or until pork is tender. Skim top from time to time to get rid of impurities. More water may be added if necessary.\n" + "\n",
                    "2. After 30 minutes of cooking pork, add the gabi cubes. Once pork is tender, add sinigang mix, and green sili and simmer for 5 minutes. Add the sitaw, radish and okra then simmer for another 5 minutes.\n" + "\n",
                    "3. Season to taste with patis then add the kangkong leaves and simmer for 2-3 minutes. Adjust seasoning according to your taste. Serve while hot.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.sinigang);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
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
                    "black pepper",
                    "STEPS:",
                    "1. In a big pot, place water and bring it to a boil. Water should be enough to cover the meat. Place pig's ears and pork jowl (or pork belly) then simmer for 40 minutes to 1 hour (or until tender). Season with salt and pepper.\n" + "\n",
                    "2. Remove the boiled ingredients from the pot then drain excess water.\n" + "\n",
                    "3. Grill the boiled pig's ears and pork jowl (or pork belly) until cooked.\n" + "\n",
                    "4. Chop the pig ears and pork belly into diced pieces.\n" + "\n",
                    "5. In a wide pan, heat the oil. Add the onions and cook until translucent.\n" + "\n",
                    "6. Add the ginger, garlic and green finger chilies and saute.\n" + "\n",
                    "7. Add the pig brains or chicken liver. Mash the chicken liver while cooking it in the pan.\n" + "\n",
                    "8. Add the chopped pig ears and pork belly. Cook for 10 to 12 minutes.\n" + "\n",
                    "9. Season with soy sauce, salt and pepper.\n" + "\n",
                    "10. Transfer to a serving plate. Top with chopped green finger chilies.\n" + "\n",
                    "11. Serve hot or serve on a hot sizzling plate. \n" + "\n",};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.sisig);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
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
                    "salt and pepper to taste",
                    "STEPS:",
                    "1. In a bowl, combine chicken, soy sauce, onions, garlic, peppercorns, and bay leaves. Massage onto meat and place in the refrigerator to marinate for about 30 minutes. Drain chicken well, reserving liquid.\n" + "\n",
                    "2. In a wide, heavy-bottomed skillet over medium heat, heat oil. Add the potatoes and cook, turning as needed, until lightly browned and halfway tender. With a slotted spoon, remove the potatoes and drain on paper towels. Remove excess oil from pan except for about 1 tablespoon.\n" + "\n",
                    "3. Add chicken including onions, garlic, and bay leaves and cook, turning occasionally until chicken is lightly browned.\n" + "\n",
                    "4. Add vinegar and allow to boil, uncovered and WITHOUT stirring, for about 3 to 5 minutes. This is very important to cook off the vinegar taste.\n" + "\n",
                    "5. Add the reserved marinade and water and stir to combine. Allow to a boil for 2 to 3 minutes. Lower heat, cover, and simmer for about 20 to 30 minutes or until chicken is cooked through. Season with salt and pepper to taste.\n" + "\n",
                    "6. Add potatoes and cook until potatoes are tender and sauce is reduced. Serve hot\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.adobo);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }
        else if(foodName.equals("Nilagang Baka")){
            String[] INGREDIENTS = {"2 lbs bone-in beef shank,",
                    "2 medium onions",
                    "1 tsp kosher salt",
                    "1 tsp whole peppercorns",
                    "5 medium size yellow potatoes",
                    "1 medium green cabbage",
                    "4 pieces ripe saba",
                    "Fish sauce or salt to taste",
                    "STEPS:",
                    "1. Put beef in a big pot and add enough water to cover it. Bring to a boil over high heat. Skim off scum that rises on the surface.\n" + "\n",
                    "2. Add onion, salt and peppercorns. Reduce heat to medium, cover and let simmer for 2 hours or until meat is fork tender. Add more water as needed.\n" + "\n",
                    "3. Increase heat to medium high. Add potatoes and cabbage and cook for 10 minutes. Add plantain banana, if using; cook for another 5 minutes or until potatoes are fork tender.\n" + "\n",
                    "4. Correct seasonings using fish sauce or salt. Serve hot with steamed rice and fish sauce with lemon juice on the side.\n" + "\n"};
            image = findViewById(R.id.dish);
            image.setImageResource(R.drawable.nilaga);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, INGREDIENTS);
            listView.setAdapter(adapter);
        }

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if(mShoppingList.contains(foodName)){
                  displayFailedToast(v);
              }
              else {
                  mDatabase.push().setValue(foodName);
                  displaySuccessToast(v);
              }


            }
        });

        startService(i);
    }


    public void displaySuccessToast(View v){
        Toast.makeText(this, "Added to List", Toast.LENGTH_LONG).show();
    }
    public void displayFailedToast(View v){
        Toast.makeText(this, "Food is already added", Toast.LENGTH_LONG).show();
    }


    public void process(View v){
        Intent i = null, chooser = null;

        if(v.getId()==R.id.shopping_list){
            i = new Intent(ShowRecipe.this, RecipeList.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.home){
            i = new Intent(ShowRecipe.this, HomeActivity.class);
            startActivity(i);
        }





    }




}
