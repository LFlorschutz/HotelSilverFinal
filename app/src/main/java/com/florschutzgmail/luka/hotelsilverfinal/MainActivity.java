package com.florschutzgmail.luka.hotelsilverfinal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startBtn = (Button) findViewById(R.id.sendEmail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
        ImageView ivPrvi = (ImageView) findViewById(R.id.ivHotelLogo);   //definiranje imageview-a
        ivPrvi.setImageResource(R.drawable.hotellogo);
        ImageView ivDrugi = (ImageView) findViewById(R.id.ivNaslovnaPrva);
        ivDrugi.setImageResource(R.drawable.naslovnadruga);
        ImageView ivTreci = (ImageView) findViewById(R.id.ivNaslovnaDruga);
        ivTreci.setImageResource(R.drawable.naslovnaprva);
        ImageView ivCetvrti = (ImageView) findViewById(R.id.ivNaslovnaTreca);
        ivCetvrti.setImageResource(R.drawable.naslovnatreca);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.drugi:
                Intent i = new Intent(getApplicationContext(),GalleryActivity.class);
                startActivity(i);
                return true;
            case R.id.treci:
                Intent j = new Intent(getApplicationContext(),AccActivity.class);
                startActivity(j);
                return true;
            case R.id.cetvrti:
                Intent k = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(k);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {"hotel@hotel-silver.hr"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "First and last name:" + "\n" + "Adress:" + "\n" + "Phone:" + "\n" + "Arriving(date):" + "\n" + "Leaving(date):"+"\n"+"Party:"+"\n"+"Your note:");


        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }















}
