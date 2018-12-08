package yummers.com;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecipeList extends AppCompatActivity {

    EditText input;
    Button addBtn;
    ListView mListView;
    ArrayList<String> mShoppingList = new ArrayList<>();
    ArrayList<String> mKeyList = new ArrayList<>();

    List<String> foodNameIdList = new ArrayList<>();

    ArrayAdapter<String> adapter;

    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar2);
        Intent i = new Intent(this, YummersService.class);
        Bundle extras = getIntent().getExtras();


        mDatabase = FirebaseDatabase.getInstance().getReference("shopping_list");
        mListView = (ListView) findViewById(R.id.recipeList);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mShoppingList);

        mListView.setAdapter(adapter);


        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String value = dataSnapshot.getValue(String.class);
                mShoppingList.add(value);
                mKeyList.add(dataSnapshot.getKey());

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String string = dataSnapshot.getValue(String.class);

                mShoppingList.remove(string);
                mKeyList.remove(dataSnapshot.getKey());

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {

                AlertDialog.Builder alert = new AlertDialog.Builder(RecipeList.this);
                alert.setTitle("Delete Item");
                alert.setMessage("Are you sure you want to delete this recipe from your list?");
                alert.setPositiveButton(Html.fromHtml("<font color='#00000'>Yes</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String deletedItem = (mListView.getItemAtPosition(position).toString());
                        String key = mKeyList.get(position);
                        mShoppingList.remove(position);
                        adapter.notifyDataSetChanged();
                        mDatabase.child(key).removeValue();
                        displayDeletedToast(view);
                        dialog.dismiss();

                    }
                });
                alert.setNegativeButton(Html.fromHtml("<font color='#00000'>No</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alert.show();
                return true;
            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = null;

                i = new Intent(RecipeList.this, FoodChecklist.class);
                String selectedFoodName = mListView.getItemAtPosition(position).toString();
                i.putExtra("checklist_title", selectedFoodName);
                startActivity(i);
            }
        });


        startService(i);

    }

    public void displayDeletedToast(View v){
        Toast.makeText(this, "Deleted item from the List", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_shopping, menu);
        MenuItem item = menu.findItem(R.id.recipeList);
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


        if(v.getId()==R.id.home){
            i = new Intent(RecipeList.this, HomeActivity.class);
            startActivity(i);
        }



    }





}