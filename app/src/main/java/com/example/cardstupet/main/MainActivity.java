package com.example.cardstupet.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cardstupet.R;
import com.example.cardstupet.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

        private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textView = findViewById(R.id.tv_settings);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Uri mMediaUri = getIntent().getData();
//                Intent recipientsIntent = new Intent(getApplicationContext(), SettingsFragment.class);
//                recipientsIntent.setData(mMediaUri);
//                replaceFragment();

            }
        });
        navigation();
    }

public void navigation(){
    CurvedBottomNavigationView mView = findViewById(R.id.customBottomBar);
    mView.inflateMenu(R.menu.icons);
    mView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.users:
                    break;
                case R.id.many:
                    break;
                case R.id.week:
                    break;
                case R.id.money:
                    break;
            }
            return true;
        }
    });
}

}
