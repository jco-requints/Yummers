package yummers.com;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends AppCompatActivity {

    EditText input;
    Button addBtn;
    ListView mListView;
    ArrayList<String> mShoppingList = new ArrayList<>();

    ArrayAdapter<String> adapter;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list);
        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();

        input = (EditText) findViewById(R.id.food_field);
        addBtn = (Button) findViewById(R.id.addToList);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Shopping_List");
        mListView = (ListView) findViewById(R.id.shoppingList);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mShoppingList);

        mListView.setAdapter(adapter);


        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                mShoppingList.add(value);
                adapter.notifyDataSetChanged();
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


        onBtnClick();

        startService(i);

    }

    public void onBtnClick(){
        addBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String value =  input.getText().toString();
                mDatabase.push().setValue(value);

            }
        });

    }




}