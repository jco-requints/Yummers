package yummers.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayRecipes extends AppCompatActivity {
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


        startService(i);

    }
}
