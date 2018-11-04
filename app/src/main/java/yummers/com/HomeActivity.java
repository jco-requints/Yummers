package yummers.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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





    }


}
