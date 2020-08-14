package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

// TODO: 14.08.2020 https://vk.com/support?act=show&id=37960706

/**
 * Describes document.
 */
public class Doc implements Attachable {
	/**
	 * Document ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * ID of the user who uploaded the document.
	 */
	@SerializedName("owner_id")
	private Integer ownerId;

	/**
	 * Document title.
	 */
	@SerializedName("title")
	private String title;

	/**
	 * Document size (in bytes).
	 */
	@SerializedName("size")
	private Integer size;

	/**
	 * Document extension.
	 */
	@SerializedName("ext")
	private String ext;

	/**
	 * Document URL for downloading.
	 */
	@SerializedName("url")
	private String url;

	/**
	 * Date when the document has been added in Unixtime
	 */
	@SerializedName("date")
	private Integer date;

	/**
	 * Document type. Possible values:
	 * <ol>
	 *     <li>1 — text documents;</li>
	 *     <li>2 — archives;</li>
	 *     <li>3 — gif;</li>
	 *     <li>4 — images;</li>
	 *     <li>5 — audio;</li>
	 *     <li>6 — video;</li>
	 *     <li>7 — e-books;</li>
	 *     <li>8 — unknown.</li>
	 * </ol>
	 */
	@SerializedName("type")
	private Integer type;

	/**
	 * Document preview data.
	 */
	@SerializedName("preview")
	private Map<String, Preview> preview;

	/**
	 * Document access key.
	 */
	@SerializedName("access_key")
	private String accessKey;

	/**
	 * Describes document preview data.
	 */
	public abstract class Preview {
	}

	/**
	 * Describes document photo preview data.
	 */
	public class Photo extends Preview {
		/**
		 * Array with the photo copies of different sizes.
		 */
		@SerializedName("sizes")
		private List<Size> sizes;

		/**
		 * Describes photo size.
		 */
		public class Size {
			/**
			 * Photo URL.
			 */
			@SerializedName("src")
			private String src;

			/**
			 * Photo width in pixels.
			 */
			@SerializedName("width")
			private Integer width;

			/**
			 * Photo height in pixels.
			 */
			@SerializedName("height")
			private Integer height;

			/**
			 * Photo preview type. Possible values:
			 * <ul>
			 * <li><b>s</b> — proportional copy with max side of 100 px;</li>
			 * <li><b>m</b> — proportional copy with max side of 130 px;</li>
			 * <li><b>x</b> — proportional copy with max side of 604 px;</li>
			 * <li><b>y</b> — proportional copy with max side of 807 px;</li>
			 * <li><b>z</b> — proportional copy with max size of 1080x1024 px;</li>
			 * <li><b>o</b> — original size image.</li>
			 * </ul>
			 */
			@SerializedName("type")
			private String type;

			public Integer getWidth() {
				return width;
			}

			public String getSrc() {
				return src;
			}

			public Size setSrc(String src) {
				this.src = src;
				return this;
			}

			public Size setWidth(Integer width) {
				this.width = width;
				return this;
			}

			public Integer getHeight() {
				return height;
			}

			public Size setHeight(Integer height) {
				this.height = height;
				return this;
			}

			public String getType() {
				return type;
			}

			public Size setType(String type) {
				this.type = type;
				return this;
			}
		}

		public List<Size> getSizes() {
			return sizes;
		}

		public Photo setSizes(List<Size> sizes) {
			this.sizes = sizes;
			return this;
		}
	}

	/**
	 * Describes document graffiti preview data.
	 */
	public class Graffiti extends Preview {
		/**
		 * Doc URL with graffiti
		 */
		@SerializedName("src")
		private String src;

		/**
		 * Image width in pixels.
		 */
		@SerializedName("width")
		private Integer width;

		/**
		 * Image height in pixels.
		 */
		@SerializedName("height")
		private Integer height;

		public String getSrc() {
			return src;
		}

		public Graffiti setSrc(String src) {
			this.src = src;
			return this;
		}

		public Integer getWidth() {
			return width;
		}

		public Graffiti setWidth(Integer width) {
			this.width = width;
			return this;
		}

		public Integer getHeight() {
			return height;
		}

		public Graffiti setHeight(Integer height) {
			this.height = height;
			return this;
		}
	}

	/**
	 * Describes document audio message preview data.
	 */
	public class AudioMessage extends Preview {
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
	}

	public Integer getId() {
		return id;
	}

	public Doc setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Doc setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Doc setTitle(String title) {
		this.title = title;
		return this;
	}

	public Integer getSize() {
		return size;
	}

	public Doc setSize(Integer size) {
		this.size = size;
		return this;
	}

	public String getExt() {
		return ext;
	}

	public Doc setExt(String ext) {
		this.ext = ext;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Doc setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public Doc setDate(Integer date) {
		this.date = date;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public Doc setType(Integer type) {
		this.type = type;
		return this;
	}

	public Map<String, Preview> getPreview() {
		return preview;
	}

	public Doc setPreview(Map<String, Preview> preview) {
		this.preview = preview;
		return this;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public Doc setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}
}
