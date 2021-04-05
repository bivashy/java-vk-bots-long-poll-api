package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes audio message object.
 */
public class AudioMessage implements Attachable {
    /**
     * Audio message ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Audio message owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Audio message duration in seconds.
     */
    @SerializedName("duration")
    private Integer duration;

    /**
     * List of integers to visualize the sound.
     */
    @SerializedName("waveform")
    private List<Integer> waveform;

    /**
     * .ogg file URL.
     */
    @SerializedName("link_ogg")
    private String linkOgg;

    /**
     * .mp3 file URL.
     */
    @SerializedName("link_mp3")
    private String linkMp3;

    /**
     * Audio message access key.
     */
    @SerializedName("access_key")
    private String accessKey;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Integer> getWaveform() {
        return waveform;
    }

    public void setWaveform(List<Integer> waveform) {
        this.waveform = waveform;
    }

    public String getLinkOgg() {
        return linkOgg;
    }

    public void setLinkOgg(String linkOgg) {
        this.linkOgg = linkOgg;
    }

    public String getLinkMp3() {
        return linkMp3;
    }

    public void setLinkMp3(String linkMp3) {
        this.linkMp3 = linkMp3;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public String toString() {
        return "AudioMessage{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", duration=" + duration +
                ", waveform=" + waveform +
                ", linkOgg='" + linkOgg + '\'' +
                ", linkMp3='" + linkMp3 + '\'' +
                ", accessKey='" + accessKey + '\'' +
                '}';
    }
}
