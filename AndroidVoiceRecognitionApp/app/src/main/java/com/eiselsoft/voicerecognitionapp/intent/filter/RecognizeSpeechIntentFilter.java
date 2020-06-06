package com.eiselsoft.voicerecognitionapp.intent.filter;

import android.content.IntentFilter;
import android.speech.RecognizerIntent;

public class RecognizeSpeechIntentFilter extends IntentFilter {
    /**
     * Constructs the {@link IntentFilter} using
     * {@link RecognizerIntent#ACTION_RECOGNIZE_SPEECH} as the action.
     */
    public RecognizeSpeechIntentFilter() {
        super(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    }
}
