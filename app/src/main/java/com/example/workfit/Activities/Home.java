package com.example.workfit.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.workfit.Adapters.FragmentsPageAdapter;
import com.example.workfit.DatabaseHandlers.DatabaseHandler_PersonalData;
import com.example.workfit.DatabaseHandlers.DatabaseHandler_Photo;
import com.example.workfit.Fragments.DiagramFragment;
import com.example.workfit.Fragments.StatisticFragment;
import com.example.workfit.workfitapps.R;
import com.pkmmte.view.CircularImageView;

public class Home extends AppCompatActivity {

    private String iUsername;
    private String iGender, temp;
    private int iWeight, iHeight;
    private Bitmap iAvatar;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private int totalCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /** Buat ngitung udah berapa banyak dibuka app-nya **/
        prefs = getPreferences(Context.MODE_PRIVATE);
        editor = prefs.edit();

        totalCount = prefs.getInt("counter", 0);
        totalCount++;
        editor.putInt("counter", totalCount);
        editor.apply();

        /**Passing from register to here **/
        /*
        Bundle i = getIntent().getBundleExtra("Bundle");
        if(i!=null) {
            iUsername = i.getString("USERNAME");
            if (iUsername.contains(" ")){
                iUsername = iUsername.substring(0, iUsername.indexOf(" "));
            }
            iWeight = i.getString("WEIGHT");
            iHeight = i.getString("HEIGHT");
            iGender = i.getString("GENDER");

            byte[] bytes = i.getByteArray("BMP");
            iAvatar = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        } else Toast.makeText(this, "Bundle Intent is empty", Toast.LENGTH_LONG).show();
        */

        /** Taking from database for personal info **/
        DatabaseHandler_PersonalData personaldb = new DatabaseHandler_PersonalData(Home.this);
        iUsername = personaldb.getPersonalData().getName();
        if (iUsername.contains(" ")){iUsername = iUsername.substring(0, iUsername.indexOf(" "));}
        if(personaldb.getPersonalData().getGender() == 1) temp = "Women"; else temp = "Men";
        iGender = temp;
        iHeight = personaldb.getPersonalData().getHeight();
        iWeight = personaldb.getPersonalData().getWeight();

        DatabaseHandler_Photo photodb = new DatabaseHandler_Photo(Home.this);
        iAvatar = photodb.getPhoto("profile");

        //==========================================================================================

        /** Setting Display name and avatar **/
        TextView homeUsername = (TextView)findViewById(R.id.textView3);
        homeUsername.setText(iUsername);

        CircularImageView profileHome = (CircularImageView)findViewById(R.id.profilePictureHome);
        profileHome.setImageBitmap(iAvatar);

        //==========================================================================================

        /** Tab things **/
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //==========================================================================================

        /** Start workout button **/
        final Button StartWorkout = (Button)findViewById(R.id.startWorkout);
        StartWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, ChooseWorkout.class);
                startActivity(intent);
            }
        });

    }

    public int getTotalCount() {
        return totalCount;
    }

    private void setupViewPager(ViewPager viewpager) {
        FragmentsPageAdapter adapternya = new FragmentsPageAdapter(getSupportFragmentManager());
        adapternya.addFragment(new StatisticFragment(), "Statistics");
        adapternya.addFragment(new DiagramFragment(), "Diagrams");
        viewpager.setAdapter(adapternya);
    }
}
