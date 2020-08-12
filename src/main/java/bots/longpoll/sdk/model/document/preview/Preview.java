package bots.longpoll.sdk.model.document.preview;

import bots.longpoll.sdk.model.document.preview.audio.AudioMessagePreview;
import bots.longpoll.sdk.model.document.preview.graffiti.GraffitiPreview;
import bots.longpoll.sdk.model.document.preview.photo.PhotoPreview;
import com.google.gson.annotations.SerializedName;

public class Preview {
	@SerializedName("photo")
	private PhotoPreview photoPreview;
	@SerializedName("graffiti")
	private GraffitiPreview graffitiPreview;
	@SerializedName("audio_message")
	private AudioMessagePreview audioMessagePreview;

	public boolean hasPhotoPreview() {
		return photoPreview != null;
	}

	public boolean hasGraffitiPreview() {
		return graffitiPreview != null;
	}

	public boolean hasAudioMEssagePreview() {
		return audioMessagePreview != null;
	}

	public PhotoPreview getPhotoPreview() {
		return photoPreview;
	}

	public Preview setPhotoPreview(PhotoPreview photoPreview) {
		this.photoPreview = photoPreview;
		return this;
	}

	public GraffitiPreview getGraffitiPreview() {
		return graffitiPreview;
	}

	public Preview setGraffitiPreview(GraffitiPreview graffitiPreview) {
		this.graffitiPreview = graffitiPreview;
		return this;
	}

	public AudioMessagePreview getAudioMessagePreview() {
		return audioMessagePreview;
	}

	public Preview setAudioMessagePreview(AudioMessagePreview audioMessagePreview) {
		this.audioMessagePreview = audioMessagePreview;
		return this;
	}
}
