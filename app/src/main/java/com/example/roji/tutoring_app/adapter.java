package com.example.roji.tutoring_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Saul on 4/19/2016.
 */
public class adapter extends ArrayAdapter<String> {
    //declare variables
    Context c;
    String[] names={};
    String[] emails={};
    String[] subjects={};
    int[] rating={};
    LayoutInflater inflater;

    public adapter(Context context, String[] names,String[] emails, String[] subjects, int[] rating)
    {
        super(context,R.layout.tutorcategorylistview,names);
        this.names=names;
        this.emails=emails;
        this.c=context;
        this.subjects=subjects;
        this.rating=rating;
    }

    public class ViewHolder
    {
        TextView nameTv;
        TextView emailTv;
        TextView subjectTv;
        RatingBar ratingTv;

    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null)
        {
            inflater=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.tutorcategorylistview, null);
        }
        final ViewHolder holder = new ViewHolder();
        holder.nameTv=(TextView)convertView.findViewById(R.id.name_listview);
        holder.emailTv=(TextView)convertView.findViewById(R.id.email_listview);
        holder.subjectTv=(TextView)convertView.findViewById(R.id.subject_listview);
        holder.ratingTv=(RatingBar)convertView.findViewById(R.id.ratingBar_listview);

        //assign data
        holder.nameTv.setText(names[position]);
        holder.emailTv.setText(emails[position]);
        holder.subjectTv.setText(subjects[position]);
        holder.ratingTv.setRating(rating[position]);

        return convertView;

    }
}
