package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
	 * Describes currency.
	 */
	public class Currency {
		/**
		 * Currency ID.
		 */
		@SerializedName("id")
		private Integer id;

		/**
		 * Currency letter.
		 */
		@SerializedName("name")
		private String name;

		public Integer getId() {
			return id;
		}

		public Currency setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getName() {
			return name;
		}

		public Currency setName(String name) {
			this.name = name;
			return this;
		}
	}