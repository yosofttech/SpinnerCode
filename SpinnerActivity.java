package com.yosofttech.yostudy.spinner;

/**
 * Created by AKHILESH on 08-12-2017.
 */

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;
import java.util.ArrayList;
import java.util.List;

import android.widget.Toast;

import com.yosofttech.yostudy.R;
import com.yosofttech.yostudy.app.BaseActivity;

public class SpinnerActivity extends BaseActivity {

    Button button;
    Spinner spinner;
    List<String> itemList = new ArrayList<>();

    private static final String TAG = SpinnerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Spinner Selection");
        button = (Button) findViewById(R.id.btn_view);
        spinner = (Spinner) findViewById(R.id.spinner_folder);
        itemList.add("Select Item");
        itemList.add("One");
        itemList.add("Two");
        itemList.add("Three");
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item_black, itemList);
        // Specify layout to be used when list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String itemSelected = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "You have selected " + itemSelected, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}