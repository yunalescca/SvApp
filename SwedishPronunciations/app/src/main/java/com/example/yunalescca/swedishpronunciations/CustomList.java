package com.example.yunalescca.swedishpronunciations;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.example.yunalescca.swedishpronunciations.models.*;

import java.util.ArrayList;


public class CustomList extends ArrayAdapter<Achievement>{

    private final Activity context;
    private final ArrayList<Achievement> achievements;

    public CustomList(Activity context, ArrayList<Achievement> achievements) {
        super(context, R.layout.list_single, achievements);
        this.context = context;
        this.achievements = achievements;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        System.out.println(position);
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView name = (TextView) rowView.findViewById(R.id.list_name);
        TextView description = (TextView) rowView.findViewById(R.id.list_description);
        ImageView image = (ImageView) rowView.findViewById(R.id.list_img);
        if (achievements.get(position).isAchieved()){
            rowView.setBackgroundColor(Color.parseColor("#00FF00"));
            rowView.invalidate();

        }
        else{
            rowView.setBackgroundColor(Color.parseColor("#FF5247"));
            rowView.invalidate();
        }
        name.setText(achievements.get(position).getName());
        description.setText(achievements.get(position).getDescription());
        image.setImageDrawable(achievements.get(position).getPicture());

        return rowView;

    }
}
