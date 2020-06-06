package com.eiselsoft.voicerecognitionapp.capability.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import com.eiselsoft.voicerecognitionapp.capability.VoiceRecognitionCapabilityIF;
import com.eiselsoft.voicerecognitionapp.intent.RecognizeSpeechIntent;

import java.util.List;

public class VoiceRecognitionCapability implements VoiceRecognitionCapabilityIF {
    /**
     * the context to use in grabbing the package manager.
     */
    private final Context ctx;

    /**
     * the package manager to query for activities that can
     * handle the recognize speech intent.
     */
    private final PackageManager packageManager;

    /**
     * Constructs the capability object using the context which
     * holds a package manager that can be used to query
     * for voice recognition capability.
     *
     * @param context the context to use.
     * @throws IllegalArgumentException if the context is null.
     */
    public VoiceRecognitionCapability(final Context context) {

        // Sanity check the context.
        if (null == context) {
            throw new IllegalArgumentException("context can not be null");
        }

        // Cache a local reference to the context.
        this.ctx = context;

        // Grab the package manager from the context.
        this.packageManager =
                ctx.getPackageManager();
    }

    /**
     * {@inheritDoc}
     *
     * @see VoiceRecognitionCapabilityIF#hasVoiceRecognitionCapability()
     */
    @Override
    public Boolean hasVoiceRecognitionCapability() {

        // Query the package manager for activities that can
        // handle the recognize speech intent.
        final List<ResolveInfo> activities =
                packageManager.queryIntentActivities(new RecognizeSpeechIntent(), 0);

        // If we have a list, and the size is > 0, then there
        // is an activity that can handle it.
        final boolean hasVoiceRecognitionCapability =
                (activities != null) && (activities.size() != 0);

        // Return the value.
        return Boolean.valueOf(hasVoiceRecognitionCapability);
    }
}
