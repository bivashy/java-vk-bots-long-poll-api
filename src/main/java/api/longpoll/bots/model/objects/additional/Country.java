package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

public class Country {
		@SerializedName("id")
		private Integer id;
		@SerializedName("title")
		private String title;

		public Integer getId() {
			return id;
		}

		public Country setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getTitle() {
			return title;
		}

		public Country setTitle(String title) {
			this.title = title;
			return this;
		}
	}