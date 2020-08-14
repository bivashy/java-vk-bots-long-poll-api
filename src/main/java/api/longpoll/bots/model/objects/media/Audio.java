package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Describes audio objects.
 */
public class Audio implements Attachable {
	/**
	 * Audio ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * Audio owner ID.
	 */
	@SerializedName("owner_id")
	private Integer ownerId;

	/**
	 * Artist name.
	 */
	@SerializedName("artist")
	private String artist;

	/**
	 * Audio title.
	 */
	@SerializedName("title")
	private String title;

	/**
	 * Duration (in seconds).
	 */
	@SerializedName("duration")
	private Integer duration;

	/**
	 * Link to mp3 file.
	 */
	@SerializedName("url")
	private String url;

	/**
	 * ID of the lyrics (if available) of the audio file.
	 */
	@SerializedName("lyrics_id")
	private Integer lyricsId;

	/**
	 * ID of the album containing the audio file (if assigned).
	 */
	@SerializedName("album_id")
	private Integer albumId;

	/**
	 * Genre ID.
	 * @see <a href="https://vk.com/dev/objects/audio_genres">List of Audio Genres</a>
	 */
	@SerializedName("genre_id")
	private Integer genre;

	/**
	 * Date when the audio has been added in Unixtime.
	 */
	@SerializedName("date")
	private Integer date;

	/**
	 * <b>true</b> if "No search" option is enabled.
	 */
	@SerializedName("no_search")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean noSearch;

	/**
	 * <b>true</b> if audio is in a high quality.
	 */
	@SerializedName("is_hq")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean hq;

	public Integer getId() {
		return id;
	}

	public Audio setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Audio setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getArtist() {
		return artist;
	}

	public Audio setArtist(String artist) {
		this.artist = artist;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Audio setTitle(String title) {
		this.title = title;
		return this;
	}

	public Integer getDuration() {
		return duration;
	}

	public Audio setDuration(Integer duration) {
		this.duration = duration;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Audio setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getLyricsId() {
		return lyricsId;
	}

	public Audio setLyricsId(Integer lyricsId) {
		this.lyricsId = lyricsId;
		return this;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public Audio setAlbumId(Integer albumId) {
		this.albumId = albumId;
		return this;
	}

	public Integer getGenre() {
		return genre;
	}

	public Audio setGenre(Integer genre) {
		this.genre = genre;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public Audio setDate(Integer date) {
		this.date = date;
		return this;
	}

	public boolean isNoSearch() {
		return noSearch;
	}

	public Audio setNoSearch(boolean noSearch) {
		this.noSearch = noSearch;
		return this;
	}

	public boolean isHq() {
		return hq;
	}

	public Audio setHq(boolean hq) {
		this.hq = hq;
		return this;
	}
}
