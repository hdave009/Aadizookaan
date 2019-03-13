package com.example.aadizookaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Image Buttons for each story.
        ImageButton gluscabiWindEagleButton = (ImageButton) findViewById(R.id.gluscabiWindEagleButton);
        ImageButton glooscapSummerButton = (ImageButton) findViewById(R.id.glooscapSummerButton);

        // Stories in the form of PDF files should be saved in the assets folder under Aadizookaan > app > src > main > assets
        // To add a story, just create an OnClickListener for the ImageButton for the story and use the makeIntent() method to pass the information to the second activity.

        gluscabiWindEagleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("gluscabi.pdf", 13, 1);
            }
        });

        glooscapSummerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("glooscapfoundsummer.pdf", 6, 1);
            }
        });
    }

    // Method passes PDF information to the second activity.
    public void makeIntent(String fileName, int lastPage, int firstPage){
        Intent intent = new Intent(MainActivity.this, Gluscabi_and_the_Wind_Eagle.class);
        intent.putExtra("FILENAME", fileName);
        intent.putExtra("LASTPAGE", String.valueOf(lastPage));
        intent.putExtra("FIRSTPAGE", String.valueOf(firstPage));
        startActivity(intent);

    }

}

