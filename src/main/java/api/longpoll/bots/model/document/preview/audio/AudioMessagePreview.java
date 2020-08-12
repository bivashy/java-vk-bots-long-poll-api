package api.longpoll.bots.model.document.preview.audio;

import api.longpoll.bots.model.document.preview.Preview;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This class may be a part of
 * {@link Preview} class.
 * <p>
 * See <a href="https://vk.com/dev/objects/doc">https://vk.com/dev/objects/doc</a> for details.
 *
 * <p>
 * Note: this class is not included into unit tests yet.
 * </p>
 */
public class AudioMessagePreview {
	/**
	 * Audio messages duration in seconds.
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

	public Integer getDuration() {
		return duration;
	}

	public AudioMessagePreview setDuration(Integer duration) {
		this.duration = duration;
		return this;
	}

	public List<Integer> getWaveform() {
		return waveform;
	}

	public AudioMessagePreview setWaveform(List<Integer> waveform) {
		this.waveform = waveform;
		return this;
	}

	public String getLinkOgg() {
		return linkOgg;
	}

	public AudioMessagePreview setLinkOgg(String linkOgg) {
		this.linkOgg = linkOgg;
		return this;
	}

	public String getLinkMp3() {
		return linkMp3;
	}

	public AudioMessagePreview setLinkMp3(String linkMp3) {
		this.linkMp3 = linkMp3;
		return this;
	}
}
