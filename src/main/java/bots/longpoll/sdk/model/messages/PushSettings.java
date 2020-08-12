package bots.longpoll.sdk.model.messages;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class PushSettings {
	@SerializedName("sound")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean soundEnabled;
	@SerializedName("disabled_until")
	private Integer disabledUntil;

	public boolean isSoundEnabled() {
		return soundEnabled;
	}

	public PushSettings setSoundEnabled(boolean soundEnabled) {
		this.soundEnabled = soundEnabled;
		return this;
	}

	public Integer getDisabledUntil() {
		return disabledUntil;
	}

	public PushSettings setDisabledUntil(Integer disabledUntil) {
		this.disabledUntil = disabledUntil;
		return this;
	}
}
