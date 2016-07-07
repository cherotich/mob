package com.example.chero.mobiledietconsultant;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public  class MainActivity extends AppCompatActivity {
    public Button ok;
    public RadioGroup radiogroup;
    private RadioButton radiobutton;
    public RadioButton radiobtn;
    public RadioGroup radiogrp;
    private EditText editText2,editText3,editText5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1 =(EditText)findViewById(R.id.editText2);
        String height=e1.getText().toString();
        int a=Integer.parseInt(height);

        EditText e2=(EditText)findViewById(R.id.editText3);
        String weight=e2.getText().toString();
        int  b=Integer.parseInt(weight);

        EditText e3=(EditText)findViewById(R.id.editText5);
String age=e3.getText().toString();
        int c=Integer.parseInt(age);

    //addListenerRadioButton();
        ok=(Button)findViewById(R.id.button);
        ok.setOnClickListener((OnClickListener) this);
        }
   public void addListenerRadioButton( ) {

       radiogroup = (RadioGroup) findViewById(R.id.RadioGroup1);
       radiogrp = (RadioGroup) findViewById(R.id.RadioGroup2);
       int selected = radiogroup.getCheckedRadioButtonId();
       radiobutton = (RadioButton) findViewById(selected);
       String selectedValue = (String) radiobutton.getText();

       int select = radiogrp.getCheckedRadioButtonId();
       radiobtn = (RadioButton) findViewById(select);
       String selectValue = (String) radiobtn.getText();
       radiogroup=(RadioGroup)findViewById(R.id.RadioGroup1);
       String radiovalue=  ((RadioButton)this.findViewById(radiogroup.getCheckedRadioButtonId())).getText().toString();
   }
        //  @Override
           public void OnClickok(View v) {
               /*retrieving values from db*/
              /* ContentValues values = new ContentValues();
               values.put(mobileDietContentProvider.age,
                       ((EditText)findViewById(R.id.editText5)).getText().toString());

               values.put(mobileDietContentProvider.height,
                       ((EditText)findViewById(R.id.editText2)).getText().toString());
               values.put(mobileDietContentProvider.weight,
                       ((EditText)findViewById(R.id.editText3)).getText().toString());

               Uri uri = getContentResolver().insert( mobileDietContentProvider.CONTENT_URI, values);*/
String URL= "content://com.example.chero.mobiledietconsultant/diet";
               Uri diet = Uri.parse(URL);
               Cursor c = managedQuery(diet, null, null, null, "age");
               if (c.moveToFirst()) {
                   do{
                       Toast.makeText(this, c.getString(c.getColumnIndex(mobileDietContentProvider.BodyType)) +
                               ", " +  c.getString(c.getColumnIndex( mobileDietContentProvider.gender)) +
                               ", " + c.getString(c.getColumnIndex( mobileDietContentProvider.height)),
                               Toast.LENGTH_SHORT).show();
                             } while (c.moveToNext());

           }

       }}




