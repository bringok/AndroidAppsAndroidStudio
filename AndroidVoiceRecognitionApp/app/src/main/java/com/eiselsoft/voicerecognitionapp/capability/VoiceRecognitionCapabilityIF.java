package com.eiselsoft.voicerecognitionapp.capability;

/**
 * VoiceRecognitionCapabilityIF represents the interface for
 * which an implementation can give client classes the ability
 * to determine whether or not a device can recognize voices.
 *
 * @author Chris Adamson
 * @version 1.0
 */
public interface VoiceRecognitionCapabilityIF {
    /**
     * Returns a boolean value indicating whether or not
     * the device supports voice recognition capability.
     *
     * @return {@link Boolean#TRUE} if it has the capability,
     * {@link Boolean#FALSE} otherwise.
     */
    Boolean hasVoiceRecognitionCapability();
}
