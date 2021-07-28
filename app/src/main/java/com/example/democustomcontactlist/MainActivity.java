package com.example.democustomcontactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView LvContact;
    ArrayList<Contact> alContactList;
    CustomAdapter caContact;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LvContact = findViewById(R.id.lvViewContacts);
        alContactList = new ArrayList<>();
        Contact item1 = new Contact("Mary",65,1234567,'F',5);
        Contact item2 = new Contact("ken",65,7654321, 'M',4);
        Contact item3 = new Contact("Osmos",65,7654321,'A',3);
        alContactList.add(item1);
        alContactList.add(item2);
        alContactList.add(item3);

        caContact = new CustomAdapter(MainActivity.this,R.layout.row,alContactList);
        LvContact.setAdapter(caContact);


    }


}