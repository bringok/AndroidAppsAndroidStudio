package com.eiselsoft.voicerecognitionapp.intent;

import android.content.Intent;
import android.speech.RecognizerIntent;

public class RecognizeSpeechIntent extends Intent {
    /**
     * Constructs the {@link Intent} using
     * {@link RecognizerIntent#ACTION_RECOGNIZE_SPEECH} as the action..
     */
    public RecognizeSpeechIntent() {
        super(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    }
}
