package com.example.ardrobe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float coat = 70;
    float coatdiscount = 77;
    float hat = 25;
    float hatdiscount = 37;
    float suit = 53;
    float suitdiscount = 44;
    byte shirt = 19;
    float shoes = 41;
    float shoesdiscount = 32;
    int account = 312;

    private float calculation(){
        float count = (coat*(100-coatdiscount)+hat*(100-hatdiscount)
                +suit*(100-suitdiscount)+shirt
                +shoes*(100-shoesdiscount))/100;
        return count;
    }

    private boolean possibility(){
        if (calculation() <= account){
            return true;
        } else {
            return false;
        }
    }

    private float balanse(){
        if (possibility()){
            return account - calculation();
        } else {
            return -1;
        }
    }

    private TextView possibilityOut;
    private TextView balanseOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibilityOut = findViewById(R.id.possibilityOut);
        balanseOut = findViewById(R.id.balanseOut);
         if (possibility()){
             possibilityOut.setText("Имеется достаточно стредств для покупки гардероба");
             balanseOut.setText("Остаток от покупки " + balanse() + " серебрянных монет");
         } else {
             possibilityOut.setText("Недостаточно стредств для покупки гардероба");
             balanseOut.setText("-");
         }
    }
}