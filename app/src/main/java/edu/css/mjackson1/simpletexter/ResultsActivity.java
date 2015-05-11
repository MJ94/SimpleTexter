package edu.css.mjackson1.simpletexter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class ResultsActivity extends ActionBarActivity {

    private Spinner spinner;
    private String smsBody = "";
    EditText txtCustomText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        txtCustomText = (EditText) findViewById(R.id.txtCustom);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                position = spinner.getSelectedItemPosition();
                Intent intent = null;
                switch (position) {
                    case 1:
                        smsBody = "Hello there!";
                        break;
                    case 2:
                        smsBody = "How are you?";
                        break;
                    case 3:
                        smsBody = "On my way!";
                        break;
                    case 4:
                        smsBody = "I can't talk right now.";
                        break;
                    case 5:
                        smsBody = "Mobile Programming is the best class ever!";
                        break;

                }
                if (intent != null) {
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // do nothing here
            }
        });
    }
    public void onClickCustomText(View v) {

        Intent receiverIntent = getIntent();
        String receiver = receiverIntent.getExtras().getString("receiver");

        if(!txtCustomText.getText().toString().trim().equals("")){
            smsBody = txtCustomText.getText().toString();
        }

        if (receiver.equals("Michael")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("2185911674", null, smsBody, null, null);

        }
        if (receiver.equals("Tom")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("2185911674", null, smsBody, null, null);
        }
        if (receiver.equals("Mick")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("2185911674", null, smsBody, null, null);
        }

        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);


    }


}