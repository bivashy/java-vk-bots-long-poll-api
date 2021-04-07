package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
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
     *
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
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean noSearch;

    /**
     * <b>true</b> if audio is in a high quality.
     */
    @SerializedName("is_hq")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean hq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLyricsId() {
        return lyricsId;
    }

    public void setLyricsId(Integer lyricsId) {
        this.lyricsId = lyricsId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Boolean getNoSearch() {
        return noSearch;
    }

    public void setNoSearch(Boolean noSearch) {
        this.noSearch = noSearch;
    }

    public Boolean getHq() {
        return hq;
    }

    public void setHq(Boolean hq) {
        this.hq = hq;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", url='" + url + '\'' +
                ", lyricsId=" + lyricsId +
                ", albumId=" + albumId +
                ", genre=" + genre +
                ", date=" + date +
                ", noSearch=" + noSearch +
                ", hq=" + hq +
                '}';
    }
}
