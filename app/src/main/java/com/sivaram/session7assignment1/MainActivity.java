package com.sivaram.session7assignment1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare Views to Reference
    EditText txtSearchString;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference Declared view objects with XML Layout Objects.
        txtSearchString = (EditText) findViewById(R.id.txtSearchString);
        btnSearch = (Button)findViewById(R.id.btnSearch);

        // Setup Search Button Click Event Listener.
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate EditText View Input Value. if empty Show Toast if not navigate to search.
                if (txtSearchString.getText().toString().isEmpty() &&
                        txtSearchString.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), R.string.error_text, Toast.LENGTH_LONG).show();
                    return;
                }

                // Create URI With Search Criteria
                Uri searchStringUri = Uri.parse("http://www.google.com/#q=" + txtSearchString.getText().toString());

                // Create an intent and trigger Action_View with URI.
                Intent searchIntent = new Intent(Intent.ACTION_VIEW, searchStringUri);

                // Start Activity With required intent.
                startActivity(searchIntent);
            }
        });


    }
}
