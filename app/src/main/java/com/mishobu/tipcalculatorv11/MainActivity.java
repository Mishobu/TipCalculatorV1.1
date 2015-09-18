package com.mishobu.tipcalculatorv11;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Initializing views*/
        final EditText[] val = {(EditText) findViewById(R.id.val)};
        final Double[] vald = {Double.parseDouble(val[0].getText().toString())};
        /*Set Text Watcher listener*/
        val[0].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    DecimalFormat df = new DecimalFormat("0.0#");
                    EditText tip10 = (EditText) findViewById(R.id.tip10);
                    EditText tip15 = (EditText) findViewById(R.id.tip15);
                    EditText tip20 = (EditText) findViewById(R.id.tip20);
                    EditText tot10 = (EditText) findViewById(R.id.tot10);
                    EditText tot15 = (EditText) findViewById(R.id.tot15);
                    EditText tot20 = (EditText) findViewById(R.id.tot20);
                    Double tip10d;
                    Double tip15d;
                    Double tip20d;
                    Double tot10d;
                    Double tot15d;
                    Double tot20d;
                    Double bill = Double.parseDouble(s.toString());
                    tip10d = bill * .1;
                    tip15d = bill * .15;
                    tip20d = bill * .2;
                    tot10d = bill + tip10d;
                    tot15d = bill + tip15d;
                    tot20d = bill + tip20d;
                    String p10 = df.format(tip10d);
                    String p15 = df.format(tip15d);
                    String p20 = df.format(tip20d);
                    String t10 = df.format(tot10d);
                    String t15 = df.format(tot15d);
                    String t20 = df.format(tot20d);
                    tip10.setText(String.valueOf(p10));
                    tip15.setText(String.valueOf(p15));
                    tip20.setText(String.valueOf(p20));
                    tot10.setText(String.valueOf(t10));
                    tot15.setText(String.valueOf(t15));
                    tot20.setText(String.valueOf(t20));
                } catch (NumberFormatException e) {
                    vald[0] = 0.0;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SeekBar bar = (SeekBar) findViewById(R.id.bar);
        bar.setMax(100);
        bar.setProgress(1);
        bar.setOnSeekBarChangeListener(new barraListener());
        return true;
    }

    private class barraListener implements SeekBar.OnSeekBarChangeListener{

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
            TextView bartxt = (TextView) findViewById(R.id.bartxt);
            Log.d("DEBUG", "Progress is " + progress);
            bartxt.setText(progress+"%");
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
