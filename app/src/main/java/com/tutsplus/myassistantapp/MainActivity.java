package com.tutsplus.myassistantapp;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyAssistantApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Ready");
    }

    @Override
    public void onProvideAssistContent(AssistContent outContent) {
        super.onProvideAssistContent(outContent);
        outContent.setWebUri(Uri.parse("http://www.goodreads.com/book/show/13023.Alice_in_Wonderland"));
        try {
            outContent.setStructuredData(
                    new JSONObject()
                            .put("@type", "Book")
                            .put("author", "Lewis Carroll")
                            .put("name", "Alice in Wonderland")
                            .put("description", "This is an 1865 novel about a girl named Alice, " +
                                    "who falls through a rabbit hole and enters a fantasy world.")
                            .toString()
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
