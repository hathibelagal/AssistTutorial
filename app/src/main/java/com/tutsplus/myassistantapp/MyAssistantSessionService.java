package com.tutsplus.myassistantapp;

import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.service.voice.VoiceInteractionSessionService;

public class MyAssistantSessionService extends VoiceInteractionSessionService {

    @Override
    public VoiceInteractionSession onNewSession(Bundle bundle) {
        return new MyAssistantSession(this);
    }
}
