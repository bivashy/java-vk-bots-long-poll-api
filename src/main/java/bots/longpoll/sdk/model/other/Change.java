package bots.longpoll.sdk.model.other;

import com.google.gson.annotations.SerializedName;

public class Change {
	@SerializedName("old_value")
	private String oldValue;
	@SerializedName("new_value")
	private String newValue;

	public String getOldValue() {
		return oldValue;
	}

	public Change setOldValue(String oldValue) {
		this.oldValue = oldValue;
		return this;
	}

	public String getNewValue() {
		return newValue;
	}

	public Change setNewValue(String newValue) {
		this.newValue = newValue;
		return this;
	}
}
