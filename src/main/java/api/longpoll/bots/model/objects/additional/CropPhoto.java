package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.model.objects.media.Photo;
import com.google.gson.annotations.SerializedName;

public class CropPhoto {
		@SerializedName("photo")
		private Photo photo;
		@SerializedName("crop")
		private Crop crop;
		@SerializedName("rect")
		private Crop rect;

		public class Crop {
			@SerializedName("x")
			private Float x;
			@SerializedName("y")
			private Float y;
			@SerializedName("x2")
			private Float x2;
			@SerializedName("y2")
			private Float y2;

			public Float getX() {
				return x;
			}

			public Crop setX(Float x) {
				this.x = x;
				return this;
			}

			public Float getY() {
				return y;
			}

			public Crop setY(Float y) {
				this.y = y;
				return this;
			}

			public Float getX2() {
				return x2;
			}

			public Crop setX2(Float x2) {
				this.x2 = x2;
				return this;
			}

			public Float getY2() {
				return y2;
			}

			public Crop setY2(Float y2) {
				this.y2 = y2;
				return this;
			}
		}

		public Photo getPhoto() {
			return photo;
		}

		public CropPhoto setPhoto(Photo photo) {
			this.photo = photo;
			return this;
		}

		public Crop getCrop() {
			return crop;
		}

		public CropPhoto setCrop(Crop crop) {
			this.crop = crop;
			return this;
		}

		public Crop getRect() {
			return rect;
		}

		public CropPhoto setRect(Crop rect) {
			this.rect = rect;
			return this;
		}
	}