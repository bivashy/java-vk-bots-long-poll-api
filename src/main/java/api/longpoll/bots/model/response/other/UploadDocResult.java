package api.longpoll.bots.model.response.other;

import com.google.gson.annotations.SerializedName;

public class UploadDocResult {
	@SerializedName("file")
	private String file;

	public String getFile() {
		return file;
	}

	public UploadDocResult setFile(String file) {
		this.file = file;
		return this;
	}
}
