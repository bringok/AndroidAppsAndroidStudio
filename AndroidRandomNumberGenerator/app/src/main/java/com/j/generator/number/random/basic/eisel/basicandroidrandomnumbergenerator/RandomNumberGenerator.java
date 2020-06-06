package com.j.generator.number.random.basic.eisel.basicandroidrandomnumbergenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class RandomNumberGenerator extends AppCompatActivity {

    private final static int MIN_DEFAULT_VALUE = 1;
    private final static int MAX_DEFAULT_VALUE = 10;
    private final Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number_generator);

        // Setup the default values
        resetDefaultValues(true);
    }

    private void resetHistoryBox() {
        EditText pastNumbersTextBox = (EditText) findViewById(R.id.txtPastHistory);
        pastNumbersTextBox.setText("Past Numbers: ");
    }

    private void resetDefaultValues(boolean resetPastBox) {
        final EditText minTextBox = (EditText) findViewById(R.id.minimum_text_value);
        minTextBox.setText(String.valueOf(MIN_DEFAULT_VALUE));

        final EditText maxTextBox = (EditText) findViewById(R.id.maximum_text_value);
        maxTextBox.setText(String.valueOf(MAX_DEFAULT_VALUE));

        final EditText curTextBox = (EditText) findViewById(R.id.current);
        curTextBox.setText(String.valueOf(MIN_DEFAULT_VALUE));

        if (resetPastBox) {
            resetHistoryBox();
        }
    }

    public void onClickNextNumber(View view) {

        final EditText minTextBox = (EditText) findViewById(R.id.minimum_text_value);
        final EditText maxTextBox = (EditText) findViewById(R.id.maximum_text_value);

        int minValue = Integer.parseInt(minTextBox.getText().toString());
        int maxValue = Integer.parseInt(maxTextBox.getText().toString());

        int nextValue = rnd.nextInt(maxValue) + minValue;

        ((EditText) findViewById(R.id.current)).setText(String.valueOf(nextValue));

        final EditText history = (EditText) findViewById(R.id.txtPastHistory);

        String historyVal = history.getText().toString();
        historyVal = historyVal + " " +     String.valueOf(nextValue);

        history.setText(historyVal);




    }

    public void onClickReset(View view) {
        resetDefaultValues(true);
    }

    public void onClickClearHistory(View view) {
        resetHistoryBox();
    }
}
