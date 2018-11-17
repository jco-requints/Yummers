package yummers.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends AppCompatActivity {

    EditText et;
    Button bt;
    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    String shoppingList[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);
        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();

        et = (EditText) findViewById(R.id.editText);
        bt = (Button) findViewById(R.id.addToList);
        lv = (ListView) findViewById(R.id.shoppingList);

        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        lv.setAdapter(adapter);

        onBtnClick();

        startService(i);

    }

    public void onBtnClick(){
        bt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
               String result =  et.getText().toString();
                arrayList.add(result);
                adapter.notifyDataSetChanged();
            }
        });

    }
}
