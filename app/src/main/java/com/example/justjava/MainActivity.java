package com.example.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.StringReader;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    public int numberOfCoffees =0;
    public boolean hasWhippedCream;
    public boolean hasChocolate;
    public int pricePerCup = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.name);
        String name = nameEditText.getText().toString();
        EditText emailEditText = (EditText) findViewById(R.id.email);
        String email = emailEditText.getText().toString();
        CheckBox whippedCreamCB = (CheckBox) findViewById(R.id.whippedcream);
        hasWhippedCream = whippedCreamCB.isChecked();
        CheckBox ChocolateCB = (CheckBox) findViewById(R.id.chocolate);
        hasChocolate = ChocolateCB.isChecked();
        Log.v("MainActivity", "Has whipped cream is "+ hasWhippedCream);
        int total = calculatePrice();
        String finalMessage= createOrderSummary(hasWhippedCream, hasChocolate, name, total, email);

        Intent mail = new Intent(Intent.ACTION_SEND);
        mail.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        mail.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " +name);
        mail.putExtra(Intent.EXTRA_TEXT, finalMessage);
        mail.setType("message/rfc822");
        startActivity(Intent.createChooser(mail, "Send Mail Using :"));
        //displayMessage(finalMessage);

    }

    public int calculatePrice(){
        int total;
        int WPprice = 1;
        int chocPrice = 2;
        if(hasWhippedCream && hasChocolate){
            total= numberOfCoffees*(pricePerCup + WPprice + chocPrice);
        }
        else if(hasWhippedCream){
            total= numberOfCoffees*(pricePerCup + WPprice);
        }
        else if(hasChocolate){
            total= numberOfCoffees*(pricePerCup + chocPrice);
        }
        else{
            total= numberOfCoffees*(pricePerCup);
        }

        return total;
    }

    public String createOrderSummary(boolean addWhippedCream, boolean addChocolate, String name, int total, String email){
        String pricemessage = "Name: "+ name;
        pricemessage+= "\n Email id: "+ email;
        pricemessage+= "\nAdd Whipped Cream?" + addWhippedCream;
        pricemessage+= "\nAdd Chocolate?" + addChocolate;
        pricemessage+= "\nQuantity:" + numberOfCoffees;
        pricemessage+= "\nTotal: $" + total;
        pricemessage+= "\nThank You!";
        return pricemessage;


    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textView);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    /*private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/
//    private void displayMessage(String message){
//        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
//        priceTextView.setText(message);
//    }
    public void incrementvalue(View view){
        numberOfCoffees++;
        if(numberOfCoffees>100){
            Toast.makeText(getApplicationContext(), "This quantity is too much", Toast.LENGTH_SHORT).show();
            numberOfCoffees=100;
            return;
        }
        else {
            display(numberOfCoffees);
        }
    }

    public void decrementvalue(View view){
        numberOfCoffees--;
        if(numberOfCoffees<0){
            Toast.makeText(getApplicationContext(), "This quantity is invalid", Toast.LENGTH_SHORT).show();
            numberOfCoffees=0;
            return;
        }
        else {
            display(numberOfCoffees);
        }
    }

}