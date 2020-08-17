package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

public class Image {
		@SerializedName("url")
		private String url;
		@SerializedName("width")
		private Integer width;
		@SerializedName("height")
		private Integer height;

		public String getUrl() {
			return url;
		}

		public Image setUrl(String url) {
			this.url = url;
			return this;
		}

		public Integer getWidth() {
			return width;
		}

		public Image setWidth(Integer width) {
			this.width = width;
			return this;
		}

		public Integer getHeight() {
			return height;
		}

		public Image setHeight(Integer height) {
			this.height = height;
			return this;
		}
	}