package com.example.profileme23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    Button alamat, email, telp, dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        alamat = findViewById(R.id.alamat);
        email = findViewById(R.id.email);
        telp = findViewById(R.id.telp);

        telp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:081328642624"));
                startActivity(intent);
            }
        });

        alamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri lokasi = Uri.parse("geo:0,0?q=-7.078438, 110.866372(Rumah)");
                Intent maps = new Intent(Intent.ACTION_VIEW, lokasi);
                maps.setPackage("com.google.android.apps.maps");
                startActivity(maps);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"111201811322@mhs.dinus.ac.id"});
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(MainActivity.this, "Tidak ada email..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void launchCurriculumVitae(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, CurriculumVitaeActivity2.class);
        startActivity(intent);

    }
}