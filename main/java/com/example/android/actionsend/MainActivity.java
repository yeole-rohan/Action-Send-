package com.example.android.actionsend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaring Views
    private EditText editText ;
    private TextView textView;


    //    Note :- I didn't used SharePreferences to store the values



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting View by its Ids

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textViewForView);

        // Checking for null values

        if (editText !=  null){

            //To Access imeOptions need to set SetOnEditorActionListener

            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

                //Default implemented method

                @Override
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean handled = false;
                    if (i == EditorInfo.IME_ACTION_SEND){

                        //Method to Enter Text,emails,numbers

                        dialNumber();
                        handled = true;
                    }
                    return handled;
                }
            });
        }

    }

    private void dialNumber() {


        String number = null;
        if (editText != null) {

            number = "Credential :- " + editText.getText().toString();

            // You use either one of them


            textView.setText(number);

          //     or  Sending intent to the apps that can handle this type of actions

           /*Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(number));
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }else {
                Log.d("implicit intent ","Can't be handle");
            }*/

        }

        }
    }
