package com.tutsplus.myassistantapp;

import android.app.AlertDialog;
import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MyAssistantSession extends VoiceInteractionSession {

    private static final String TAG = "MyAssistantApp";

    public MyAssistantSession(Context context) {
        super(context);
    }

    @Override
    public void onHandleAssist(Bundle data, AssistStructure structure, AssistContent content) {
        super.onHandleAssist(data, structure, content);

        try {
            JSONObject structuredData = new JSONObject(content.getStructuredData());
            Toast.makeText(getContext(), structuredData.optString("description"), Toast.LENGTH_LONG)
                    .show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
