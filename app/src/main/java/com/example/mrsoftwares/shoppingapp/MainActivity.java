package com.example.mrsoftwares.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;
    int[] itemsID = new int[20];
    TextView cartTotal;
    private int currentItem = 0;
    private int cartTotalPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemsID[0] = R.id.item_1;
        itemsID[1] = R.id.item_2;
        itemsID[2] = R.id.item_3;
        itemsID[3] = R.id.item_4;
        itemsID[4] = R.id.item_5;
        itemsID[5] = R.id.item_6;
        itemsID[6] = R.id.item_7;
        itemsID[7] = R.id.item_8;
        itemsID[8] = R.id.item_9;
        itemsID[9] = R.id.item_10;
        itemsID[10] = R.id.item_11;
        itemsID[11] = R.id.item_12;
        itemsID[12] = R.id.item_13;
        itemsID[13] = R.id.item_14;
        itemsID[14] = R.id.item_15;
        itemsID[15] = R.id.item_16;
        itemsID[16] = R.id.item_17;
        itemsID[17] = R.id.item_18;
        itemsID[18] = R.id.item_19;
        itemsID[19] = R.id.item_20;
        cartTotal = (TextView) findViewById(R.id.textView_cart_total);
    }

    public void addNewItem(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra(Main2Activity.ITEM_NAME).toUpperCase();
                String price = data.getStringExtra(Main2Activity.ITEM_PRICE);
                String count = data.getStringExtra(Main2Activity.ITEM_COUNT);
                int totalPrice = Integer.parseInt(price) * Integer.parseInt(count);
                cartTotalPrice += totalPrice;
                String addItem = name + "  (x" + count + ") " + " - Price : " + String.valueOf(totalPrice);
                TextView textItem = (TextView) findViewById(itemsID[currentItem]);
                textItem.setText(addItem);
                cartTotal.setText("Cart Total : " + String.valueOf(cartTotalPrice));
                currentItem++;
            }

        }
    }
}
