package api.longpoll.bots.model.objects.additional.buttons;

import com.google.gson.annotations.SerializedName;

/**
 * Describes possible button colors.
 */
public enum ButtonColor {
    /**
     * Blue button, indicates the main action. #5181B8
     */
    @SerializedName("primary") PRIMARY,
    /**
     * Default white button. #FFFFFF
     */
    @SerializedName("secondary") SECONDARY,
    /**
     * Dangerous or negative action (cancel, delete etc.) #E64646
     */
    @SerializedName("negative") NEGATIVE,
    /**
     * Accept, agree. #4BB34B
     */
    @SerializedName("positive") POSITIVE
}
