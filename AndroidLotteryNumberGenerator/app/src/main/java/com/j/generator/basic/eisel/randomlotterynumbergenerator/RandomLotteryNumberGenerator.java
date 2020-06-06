package com.j.generator.basic.eisel.randomlotterynumbergenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class RandomLotteryNumberGenerator extends AppCompatActivity {

    private static final Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_lottery_number_generator);
    }

    public void onClickGetMyLuckyNumbers(final View view) {

        ((EditText) findViewById(R.id.txtLuckyNumbers)).setText("");

        final EditText minValueBox = (EditText) findViewById(R.id.minNumVal),
                       maxValueBox = (EditText) findViewById(R.id.maxNumVal),
                       numbersInAGroupBox = (EditText) findViewById(R.id.numGroupsVal),
                       numGroupsBox = (EditText) findViewById(R.id.howManyGroupsVal);

        final int minVal = Integer.parseInt(minValueBox.getText().toString()),
                  maxVal = Integer.parseInt(maxValueBox.getText().toString()),
                  numInAGroupVal = Integer.parseInt(numbersInAGroupBox.getText().toString()),
                  numGroupsVal = Integer.parseInt(numGroupsBox.getText().toString());

        final CheckBox repeatsAllowedBox = (CheckBox) findViewById(R.id.chkBoxRepeatsAllowed);

        final boolean repeatsAllowedVal = repeatsAllowedBox.isChecked();

        ArrayList<Integer> numbers = new ArrayList<Integer>(numInAGroupVal);

        for (int jdx = 1; jdx <= numGroupsVal; jdx++) {

            final StringBuilder sb = new StringBuilder();
            sb.append("Group " + jdx + ": ");

            for(int idx = 0; idx < numInAGroupVal; idx++) {

                int number = rnd.nextInt(maxVal) + minVal;

                if (repeatsAllowedVal) {
                    numbers.add(Integer.valueOf(number));
                } else {
                    while (numbers.contains(Integer.valueOf(number))) {
                        number = rnd.nextInt(maxVal) + minVal;
                    }

                    numbers.add(Integer.valueOf(number));
                }

                sb.append(String.valueOf(number )+ " ");
            }

            final EditText valuesBox = (EditText) findViewById(R.id.txtLuckyNumbers);
            valuesBox.append(sb.toString() + "\n");
        }
    }
}
