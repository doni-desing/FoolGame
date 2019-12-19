package com.example.cardstupet.profaile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cardstupet.R;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ProfaileActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profaile);

        progressBar = findViewById(R.id.progressBar);
        int progress = 0;
        setProgressValue(progress + 10);

    }

    private void setProgressValue(final int progress) {
        progressBar.setProgress(progress);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));


            }
        });

        thread.start();
        }
    }