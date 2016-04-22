package com.example.roji.tutoring_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class filterActivity extends AppCompatActivity {



    ArrayList<String> subjects = new ArrayList<>();
    /*subjects.add("math");
    subjects.add("science");
    subjects.add("english");
    subjects.add("business");
    subjects.add("computer science");
    subjects.add("history");
    subjects.add("music");*/

    int distance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

    }
    public void toMap(View v)
    {
        Button search = (Button) findViewById(R.id.mapButton);
        Intent intent = new Intent(v.getContext(), MapsActivity.class );
        Bundle n = new Bundle();
        n.putStringArrayList("subjects", subjects);
        n.putInt("distance",distance);
        if(n!=null)
            intent.putExtra("n1",n);
        startActivityForResult(intent,0);
    }

    public void toTutorCat(View v)
    {
        Button search = (Button) findViewById(R.id.searchFilter);
        Intent intent = new Intent(v.getContext(), tutorCategoryList.class );
        Bundle n = new Bundle();
        n.putStringArrayList("subjects", subjects);
        n.putInt("distance",distance);
        if(n!=null)
            intent.putExtra("n",n);
        startActivityForResult(intent,0);
    }
    public void onCheckboxClicked(View view)
    {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.mathChoice:
                if (checked) {
                    subjects.add("Math");
                    Toast.makeText(getApplicationContext(), "math added", Toast.LENGTH_SHORT).show();
                }
                else
                    findElement("Math");
                // Remove the meat
                break;
            case R.id.scienceChoice:
                if (checked) {
                    subjects.add("Science");
                    Toast.makeText(getApplicationContext(), "sci added", Toast.LENGTH_SHORT).show();
                }
                else
                    findElement("Science");
                break;
            case R.id.businessChoice:
                if(checked) {
                    subjects.add("Business");
                    Toast.makeText(getApplicationContext(), "business added", Toast.LENGTH_SHORT).show();
                }
                else
                    findElement("Business");
                break;
            case R.id.englishChoice:
                if(checked) {
                    subjects.add("English");
                    Toast.makeText(getApplicationContext(), "english added", Toast.LENGTH_SHORT).show();
                }
                else
                    findElement("English");
                break;
            case R.id.csChoice:
                if (checked)
                {
                    subjects.add("Computer Science");
                    Toast.makeText(getApplicationContext(), "cs added", Toast.LENGTH_SHORT).show();
                }
                else
                    findElement("Computer Science");
                break;
            case R.id.historyChoice:
                if (checked)
                {
                    subjects.add("History");
                    Toast.makeText(getApplicationContext(), "history added", Toast.LENGTH_SHORT).show();
                }
                else
                    findElement("History");
                break;
            case R.id.musicChoice:
                if (checked)
                {
                    subjects.add("Music");
                    Toast.makeText(getApplicationContext(), "music added", Toast.LENGTH_SHORT).show();
                }
                else
                    findElement("Music");
                break;
        }

    }
    public void findElement(String string)
    {
        int i;
        for(i=0; i<=subjects.size();i++)
            if(string.equalsIgnoreCase(subjects.get(i)));
        subjects.remove(i);
    }
    public void otherString()
    {
        EditText sub = (EditText)findViewById(R.id.searchQuery);
        String subFinal = sub.getText().toString();
        if(subFinal !=null || subFinal.equals(""))
            subjects.add(subFinal);

    }
    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();


        switch(view.getId()) {
            case R.id.mile10:
                if (checked)
                {
                    distance=10;
                    Toast.makeText(getApplicationContext(), "10 added", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mile15:
                if (checked)
                {
                    distance=15;
                    Toast.makeText(getApplicationContext(), "15 added", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mile25:
                if(checked)
            {
                distance=25;
                Toast.makeText(getApplicationContext(), "25 added", Toast.LENGTH_SHORT).show();
            }
                break;
            case R.id.mile50:
                if(checked)
                {
                    distance=50;

                    Toast.makeText(getApplicationContext(), "50 added", Toast.LENGTH_SHORT).show();
                }
                break;
        }



    }
}
