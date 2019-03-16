package com.example.aadizookaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Image Buttons for each story.
        ImageButton gluscabiWindEagleButton = (ImageButton) findViewById(R.id.gluscabiWindEagleButton);
        ImageButton glooscapSummerButton = (ImageButton) findViewById(R.id.glooscapSummerButton);
        ImageButton buffaloOnEarthButton = (ImageButton) findViewById(R.id.buffaloOnEarthButton);
        ImageButton milkyWayButton = (ImageButton) findViewById(R.id.milkyWayButton);
        ImageButton manSunButton = (ImageButton) findViewById(R.id.manSunButton);
        ImageButton gluscabiTobaccoButton = (ImageButton) findViewById(R.id.gluscabiTobaccoButton);
        Button sourceButton = (Button) findViewById(R.id.sourceButton);

        // Stories in the form of PDF files should be saved in the assets folder under Aadizookaan > app > src > main > assets
        // To add a story, just create an OnClickListener for the ImageButton for the story and use the makeIntent() method to pass the information to the second activity.

       sourceButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent sourceIntent = new Intent(MainActivity.this, SourcesActivity.class);
               startActivity(sourceIntent);
           }
       });

        gluscabiWindEagleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("gluscabi.pdf", "Gluscabi and the Wind Eagle", 13, 1);
            }
        });

        glooscapSummerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("glooscapfoundsummer.pdf", "How Glooscap Found the Summer", 6, 1);
            }
        });

        buffaloOnEarthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("buffaloreleasedonearth.pdf", "How the Buffalo Were Released On Earth", 6, 1);
            }
        });

        milkyWayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("howthemilkywaybecametobecherokee.pdf", "How the Milky Way Came to Be", 3, 1);
            }
        });

        manSunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("themanwhoactedasthesun.pdf", "The Man Who Acted as The Sun", 4, 1);
            }
        });

        gluscabiTobaccoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("How Gluskabe Stole Tobacco.pdf", "How Gluskabe Stole Tobacco", 9, 1);
            }
        });
}

    // Method passes PDF information to the second activity.
    public void makeIntent(String fileName, String storyTitle, int lastPage, int firstPage){
        Intent intent = new Intent(MainActivity.this, Gluscabi_and_the_Wind_Eagle.class);
        intent.putExtra("FILENAME", fileName);
        intent.putExtra("LASTPAGE", String.valueOf(lastPage));
        intent.putExtra("FIRSTPAGE", String.valueOf(firstPage));
        intent.putExtra("TITLE", storyTitle);
        startActivity(intent);

    }

}

