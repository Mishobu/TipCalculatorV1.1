package com.mishobu.tipcalculatorv11;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

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
                    EditText tip10 = (EditText) findViewById(R.id.tip10);
                    EditText tip15 = (EditText) findViewById(R.id.tip15);
                    EditText tip20 = (EditText) findViewById(R.id.tip20);
                    EditText tot10 = (EditText) findViewById(R.id.tot10);
                    EditText tot15 = (EditText) findViewById(R.id.tot15);
                    EditText tot20 = (EditText) findViewById(R.id.tot20);
                    Double tip10d;
                    Double.parseDouble(tip10.getText().toString());
                    Double tip15d;
                    Double.parseDouble(tip15.getText().toString());
                    Double tip20d;
                    Double.parseDouble(tip20.getText().toString());
                    Double tot10d;
                    Double.parseDouble(tot10.getText().toString());
                    Double tot15d;
                    Double.parseDouble(tot15.getText().toString());
                    Double tot20d;
                    Double.parseDouble(tot20.getText().toString());
                    Double bill = Double.parseDouble(s.toString());
                    tip10d = bill * .10;
                    tip15d = bill * .15;
                    tip20d = bill * .20;
                    tot10d = bill + tip10d;
                    tot15d = bill + tip15d;
                    tot20d = bill + tip20d;
                    String p10 = tip10d.toString();
                    String p15 = tip15d.toString();
                    String p20 = tip20d.toString();
                    String t10 = tot10d.toString();
                    String t15 = tot15d.toString();
                    String t20 = tot20d.toString();
                    tip10.setText(p10);
                    tip15.setText(p15);
                    tip20.setText(p20);
                    tot10.setText(t10);
                    tot15.setText(t15);
                    tot20.setText(t20);
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
        return true;
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
