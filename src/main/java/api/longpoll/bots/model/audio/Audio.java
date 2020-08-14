package api.longpoll.bots.model.audio;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.objects.media.Attachable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Audio implements Attachable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("artist")
	private String artist;
	@SerializedName("title")
	private String title;
	@SerializedName("duration")
	private Integer duration;
	@SerializedName("url")
	private String url;
	@SerializedName("lyrics_id")
	private Integer lyricsId;
	@SerializedName("album_id")
	private Integer albumId;
	@SerializedName("genre_id")
	private Integer genre;
	@SerializedName("date")
	private Integer date;
	@SerializedName("no_search")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean noSearch;
	@SerializedName("is_hq")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean hq;
	@SerializedName("track_code")
	private String trackCode;
	@SerializedName("content_restricted")
	private Integer contentRestricted;
	@SerializedName("main_artists")
	private List<MainArtist> mainArtists;
	@SerializedName("is_explicit")
	private boolean explicit;
	@SerializedName("is_focus_track")
	private boolean focusTrack;
	@SerializedName("short_videos_allowed")
	private boolean shortVidoesAllowed;
	@SerializedName("stories_allowed")
	private boolean storiesAllowed;

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

	public String getTrackCode() {
		return trackCode;
	}

	public Audio setTrackCode(String trackCode) {
		this.trackCode = trackCode;
		return this;
	}

	public Integer getContentRestricted() {
		return contentRestricted;
	}

	public Audio setContentRestricted(Integer contentRestricted) {
		this.contentRestricted = contentRestricted;
		return this;
	}

	public List<MainArtist> getMainArtists() {
		return mainArtists;
	}

	public Audio setMainArtists(List<MainArtist> mainArtists) {
		this.mainArtists = mainArtists;
		return this;
	}

	public boolean isExplicit() {
		return explicit;
	}

	public Audio setExplicit(boolean explicit) {
		this.explicit = explicit;
		return this;
	}

	public boolean isFocusTrack() {
		return focusTrack;
	}

	public Audio setFocusTrack(boolean focusTrack) {
		this.focusTrack = focusTrack;
		return this;
	}

	public boolean isShortVidoesAllowed() {
		return shortVidoesAllowed;
	}

	public Audio setShortVidoesAllowed(boolean shortVidoesAllowed) {
		this.shortVidoesAllowed = shortVidoesAllowed;
		return this;
	}

	public boolean isStoriesAllowed() {
		return storiesAllowed;
	}

	public Audio setStoriesAllowed(boolean storiesAllowed) {
		this.storiesAllowed = storiesAllowed;
		return this;
	}
}
