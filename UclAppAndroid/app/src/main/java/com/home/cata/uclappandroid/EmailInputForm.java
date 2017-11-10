package com.home.cata.uclappandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Cata on 10/29/2017.
 */

public class EmailInputForm extends Activity {

    Button send;
    EditText sendTo;
    EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.input_form);

        send=(Button) findViewById(R.id.buttonSend);
        sendTo=(EditText)findViewById(R.id.editTextEmail);
        content=(EditText)findViewById(R.id.editTextMsg);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=sendTo.getText().toString();
                String message=content.getText().toString();

                Intent email= new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT,"Favourite teams set");
                email.putExtra(Intent.EXTRA_TEXT,message);

                email.setType("message/rfc822");
                startActivity(email.createChooser(email,"Choose and email: "));
            }
        });
    }
}
