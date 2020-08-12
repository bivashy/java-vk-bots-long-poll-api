package api.longpoll.bots.model.audio.message;

import api.longpoll.bots.model.attachment.MediaObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AudioMessage extends MediaObject {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("duration")
	private Integer duration;
	@SerializedName("waveform")
	private List<Integer> waveform;
	@SerializedName("link_ogg")
	private String linkOgg;
	@SerializedName("link_mp3")
	private String linkMp3;
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
