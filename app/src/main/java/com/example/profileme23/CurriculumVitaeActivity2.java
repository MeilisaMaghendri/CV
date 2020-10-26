package com.example.profileme23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CurriculumVitaeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum_vitae2);

        TextView alamat, email, telp;

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
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"meilisamaghendri122@gmail.com"});
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(CurriculumVitaeActivity2.this, "Tidak ada email..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}