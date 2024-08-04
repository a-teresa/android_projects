package com.example.timestable;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesListView;

    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList <String>();

        for(int j=1; j<=20;j++){
            timesTableContent.add(Integer.toString(j)+" x "+Integer.toString(timesTableNumber)+" = "+Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, timesTableContent);
        timesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        timesListView = findViewById(R.id.timesListView);


        SeekBar timesSeekBar =  findViewById(R.id.timesSeekBar);





        timesSeekBar.setMax(20);
        timesSeekBar.setProgress(10);
        generateTimesTable(10);
        timesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min =1;
                int timestableNumber;


                if(i < min){
                    timestableNumber=min;
                    timesSeekBar.setProgress(min);
                }else{
                    timestableNumber=i;
                }
                Log.i("Seekbar value", Integer.toString(timestableNumber));
                generateTimesTable(timestableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}