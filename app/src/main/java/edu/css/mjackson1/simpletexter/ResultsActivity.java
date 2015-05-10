package edu.css.mjackson1.simpletexter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ResultsActivity extends ActionBarActivity {

    private Spinner spinner;
    private String smsBody = "";
    EditText txtCustomText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        List<String> userDefinedMessages = new ArrayList<String>(); // get user defined messages from somewhere
        List<String> predefinedMessages = Arrays.asList(getResources().getStringArray(R.array.predefined_messages));
        List<String> finalMessagesList = new ArrayList<String>();
        finalMessagesList.addAll(userDefinedMessages);
        finalMessagesList.addAll(predefinedMessages);
        txtCustomText = (EditText) findViewById(R.id.txtCustom);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, finalMessagesList);
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
                        smsBody = "I'm on my way!";
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

        if(txtCustomText.toString() != ""){
            smsBody = txtCustomText.toString();
        }

        if (receiver == "Michael") {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:5555555555"));
            sendIntent.putExtra("sms_body", smsBody);
            startActivity(sendIntent);
        }
        if (receiver == "Tom") {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:5555555555"));
            sendIntent.putExtra("sms_body", smsBody);
            startActivity(sendIntent);
        }
        if (receiver == "Mick") {
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.setData(Uri.parse("sms:5555555555"));
            sendIntent.putExtra("sms_body", smsBody);
            startActivity(sendIntent);
        }

        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);


    }


}