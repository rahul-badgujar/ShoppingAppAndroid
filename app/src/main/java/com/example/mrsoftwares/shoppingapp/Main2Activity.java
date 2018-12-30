package com.example.mrsoftwares.shoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText itemName, itemPrice, itemCount;
    public static String ITEM_NAME = "item_name";
    public static String ITEM_PRICE = "item_price";
    public static String ITEM_COUNT = "item_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        itemName = (EditText) findViewById(R.id.editText_input_item);
        itemPrice = (EditText) findViewById(R.id.editText_input_price);
        itemCount = (EditText) findViewById(R.id.editText_input_count);
    }

    public void sendDataBack(View view) {
        String name = itemName.getText().toString();
        String price = itemPrice.getText().toString();
        String count = itemCount.getText().toString();

        if (name.equals("") || price.equals("") || count.equals("")) {
            Toast.makeText(this, "Incomplete Data", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra(ITEM_NAME, name);
            intent.putExtra(ITEM_PRICE, price);
            intent.putExtra(ITEM_COUNT, count);
            setResult(RESULT_OK, intent);
            finish();
        }

    }
}
