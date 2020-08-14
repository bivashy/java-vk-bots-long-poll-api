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

	public AudioMessage setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public AudioMessage setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public Integer getDuration() {
		return duration;
	}

	public AudioMessage setDuration(Integer duration) {
		this.duration = duration;
		return this;
	}

	public List<Integer> getWaveform() {
		return waveform;
	}

	public AudioMessage setWaveform(List<Integer> waveform) {
		this.waveform = waveform;
		return this;
	}

	public String getLinkOgg() {
		return linkOgg;
	}

	public AudioMessage setLinkOgg(String linkOgg) {
		this.linkOgg = linkOgg;
		return this;
	}

	public String getLinkMp3() {
		return linkMp3;
	}

	public AudioMessage setLinkMp3(String linkMp3) {
		this.linkMp3 = linkMp3;
		return this;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public AudioMessage setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}
}
