package com.harshdave.aadizookaan;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Drawable> mImageybois = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutButton = (Button) findViewById(R.id.aboutButton);

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SourcesActivity.class);
                startActivity(i);
            }
        });

        initImages();
        // Stories in the form of PDF files should be saved in the assets folder under Aadizookaan > app > src > main > assets
        // To add a story, just create an OnClickListener for the ImageButton for the story and use the makeIntent() method to pass the information to the second activity.
    }

    private void initImages(){
        mNames.add("Gluscabi and the Wind Eagle");
        Drawable cover1 = getResources().getDrawable(R.drawable.thewindeagle);
        mImageybois.add(cover1);

        mNames.add("How Glooscap Found the Summer");
        Drawable cover2 = getResources().getDrawable(R.drawable.howglooscapfoundsummer);
        mImageybois.add(cover2);

        mNames.add("How the Buffalo Were Released On Earth");
        Drawable cover3 = getResources().getDrawable(R.drawable.howbuffalowerereleasedonearth);
        mImageybois.add(cover3);

        mNames.add("How the Milky Way Came to Be");
        Drawable cover4 = getResources().getDrawable(R.drawable.storyofmilkyway);
        mImageybois.add(cover4);

        /*mNames.add("The Man Who Acted As the Sun");
        Drawable cover5 = getResources().getDrawable(R.drawable.manwhoactedasthesun);
        mImageybois.add(cover5);*/

        mNames.add("How Gluskabe Stole Tobacco");
        Drawable cover6 = getResources().getDrawable(R.drawable.tobacco);
        mImageybois.add(cover6);

        mNames.add("Nibubalnoba - A Man's Summer");
        Drawable cover7 = getResources().getDrawable(R.drawable.indiansummermain);
        mImageybois.add(cover7);

        mNames.add("The Origin of the Thunderbird");
        Drawable cover8 = getResources().getDrawable(R.drawable.thunderbird);
        mImageybois.add(cover8);

        mNames.add("The Dream Fast");
        Drawable cover9 = getResources().getDrawable(R.drawable.dreamfast);
        mImageybois.add(cover9);

        mNames.add("The Great Flood of Ottawa");
        Drawable cover10 = getResources().getDrawable(R.drawable.thegreatflood);
        mImageybois.add(cover10);

        mNames.add("White Owl and His Escape from the Witches and the Great Beasts");
        Drawable cover11 = getResources().getDrawable(R.drawable.owlimage);
        mImageybois.add(cover11);


        initRecyclerView();

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.booklist);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter( mNames, mImageybois, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    // Method passes PDF information to the second activity.
}

