package com.example.aadizookaan;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.text.PDFTextStripper;
import com.tom_roush.pdfbox.util.PDFBoxResourceLoader;

import java.io.IOException;
import java.util.Locale;

public class Gluscabi_and_the_Wind_Eagle extends AppCompatActivity {

    // Declaring all the global variables that are used in this activity.
    int startPage = 0; // Initializing the starting page variable for the PDF Text Stripper
    int endPage = 0; // Initializing the starting page variable for the PDF Text Stripper
    TextToSpeech mTTS; // Declaring a Text To Speech Object
    int result;
    String fileName;
    int lastPage;
    int firstPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gluscabi_and_the__wind__eagle);

        PDFBoxResourceLoader.init(getApplicationContext());
        Button backButton = (Button) findViewById(R.id.backButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button prevButton = (Button) findViewById(R.id.prevButton);
        Button listenButton = (Button) findViewById(R.id.listenButton);
        Button stopSpeechButton = (Button) findViewById(R.id.stopSpeechButton);
        final TextView gluscabiTextView = (TextView) findViewById(R.id.gluscabiTextView);

        // Recieves the PDF information (pdf name, last page, first page) from the MainActivity through an intent.
        try{
            fileName = getIntent().getStringExtra("FILENAME");
            lastPage = Integer.parseInt(getIntent().getStringExtra("LASTPAGE"));
            firstPage = Integer.parseInt(getIntent().getStringExtra("FIRSTPAGE"));
        }catch(Exception e){
            Toast.makeText(this, "Error! No story has been loaded.", Toast.LENGTH_SHORT).show();
        }

        // Initializing mTTS Text To Speech Object

        mTTS = new TextToSpeech(getApplicationContext(), new OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    result = mTTS.setLanguage(Locale.CANADA);
                }else{
                    Toast.makeText(getApplicationContext(),"Feature Not Supported", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Setting the initial text
        gluscabiTextView.setText("Click 'NEXT PAGE' to continue.");

        // Takes user back to Main Activity with all the stories

        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });

        // Increments the startPage and endPage values by 1 to move to next page.

        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                startPage = startPage + 1;
                endPage = endPage + 1;

                if (startPage >= lastPage && endPage >= lastPage){
                    startPage = lastPage;
                    endPage = lastPage;
                }

                gluscabiTextView.setText(getText(fileName, startPage, endPage));
            }
        });

        // Decrements the startPage and endPage values by 1 to move to the previous page.

        prevButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                startPage = startPage - 1;
                endPage = endPage - 1;

                if (startPage <= firstPage && endPage <= firstPage){
                    startPage = firstPage;
                    endPage = firstPage;
                }

               gluscabiTextView.setText(getText(fileName, startPage, endPage));
            }
        });

        // Gets text from stories and converts to speech.

        listenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                    Toast.makeText(getApplicationContext(),"Something Went Wrong", Toast.LENGTH_SHORT).show();
                }else{
                    mTTS.speak(getText(fileName, startPage, endPage),TextToSpeech.QUEUE_FLUSH,null);
                }

            }
        });

        // Pauses the speech.

        stopSpeechButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTTS.stop();
            }
        });
    }

    // Method to extract story as a string from PDF file.

    public String getText(String fileName, int startPage, int endPage){
        String parsedText1 = null;
        PDDocument document = null;
        AssetManager assetManager = getAssets();
        try {
            document = PDDocument.load(assetManager.open(fileName));
        } catch(IOException e) {
            e.printStackTrace();
        }
        try {
            final PDFTextStripper pdfStripper = new PDFTextStripper();
            pdfStripper.setStartPage(startPage);
            pdfStripper.setEndPage(endPage);
            parsedText1 = pdfStripper.getText(document);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (document != null) document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return parsedText1;
    }

    public void onDestroy() {
        super.onDestroy();
        mTTS.stop();
    }
}



