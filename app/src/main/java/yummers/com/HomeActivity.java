package yummers.com;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        Intent i = new Intent(this, YummersService.class);
        startService(i);

    }

    public void process(View v){
        Intent i = null, chooser = null;

        //if italian is clicked...
        if(v.getId()==R.id.italian){
            i = new Intent(HomeActivity.this, DisplayRecipes.class);
            String foodCategory = "Italian";
            i.putExtra("category", foodCategory);
            startActivity(i);
        }

        //if japanese is clicked...
        else if(v.getId()==R.id.japanese){
            i = new Intent(HomeActivity.this, DisplayRecipes.class);
            String foodCategory = "Japanese";
            i.putExtra("category", foodCategory);
            startActivity(i);
        }

        //if filipino is clicked..
        else if(v.getId()==R.id.filipino){
            i = new Intent(HomeActivity.this, DisplayRecipes.class);
            String foodCategory = "Filipino";
            i.putExtra("category", foodCategory);
            startActivity(i);
        }

        else if(v.getId()==R.id.shopping_list){
            i = new Intent(HomeActivity.this, RecipeList.class);
            startActivity(i);
        }





    }


}
