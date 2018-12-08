package yummers.com;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ChecklistAdapter extends ArrayAdapter<String> {

    private final String[] itemname;
    private final Activity context;


    public ChecklistAdapter(Activity context, String[] itemname){
        super(context, R.layout.item_layout, itemname);

        this.itemname = itemname;
        this.context = context;
    }


    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_layout, null,true);

        TextView item = (TextView) rowView.findViewById(R.id.checklist_item);

        item.setText(itemname[position]);

        return rowView;

    };

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//
//        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
//        View row = inflater.inflate(R.layout.item_layout, parent, false);
//        TextView name = row.findViewById(R.id.checklist_item);
//
//        name.setText(ingredients.get(position));
//
//        return super.getView(position,convertView,parent);
//
//    };

}
