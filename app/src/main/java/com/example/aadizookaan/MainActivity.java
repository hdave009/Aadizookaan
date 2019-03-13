package com.example.aadizookaan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FILENAME = "PDF File needed";
    public static final String EXTRA_LAST_PAGE = "Last page of PDF File";
    public static final String EXTRA_FIRST_PAGE = "First page of PDF File";

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton gluscabiWindEagleButton = (ImageButton) findViewById(R.id.gluscabiWindEagleButton);

        gluscabiWindEagleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeIntent("gluscabi.pdf");
            }
        });
    }
    public void makeIntent(String fileName){
        Intent intent = new Intent(MainActivity.this, Gluscabi_and_the_Wind_Eagle.class);
        intent.putExtra("FILENAME", fileName);
        startActivity(intent);

    }
}

