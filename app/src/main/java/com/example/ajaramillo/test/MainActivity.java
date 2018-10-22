package com.example.ajaramillo.test;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ajaramillo.test.fragments.ListCreditCardFragment;

public class MainActivity extends AppCompatActivity implements ListCreditCardFragment.OnFragmentInteractionListener {

    ListCreditCardFragment listCreditCardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCreditCardFragment = new ListCreditCardFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedorFragment, listCreditCardFragment).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {



    }
}
