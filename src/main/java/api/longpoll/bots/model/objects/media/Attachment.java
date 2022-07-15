package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.model.objects.additional.Story;
import api.longpoll.bots.model.objects.basic.Poll;
import api.longpoll.bots.model.objects.basic.WallComment;
import api.longpoll.bots.model.objects.basic.WallPost;
import com.google.gson.annotations.SerializedName;

import java.util.StringJoiner;

/**
 * Describes attachment.
 */
public class Attachment {
    /**
     * Attachment type.
     */
    @SerializedName("type")
    private Type type;

    /**
     * {@link Audio} object.
     */
    @SerializedName("audio")
    private Audio audio;

    /**
     * {@link AudioMessage} object.
     */
    @SerializedName("audio_message")
    private AudioMessage audioMessage;

    /**
     * {@link Doc} object.
     */
    @SerializedName("doc")
    private Doc doc;

    /**
     * {@link Graffiti} object.
     */
    @SerializedName("graffiti")
    private Graffiti graffiti;

    /**
     * {@link AttachedLink} object.
     */
    @SerializedName("link")
    private AttachedLink link;

    /**
     * {@link MarketItem} object.
     */
    @SerializedName("market")
    private MarketItem market;

    /**
     * {@link MarketCollection} object.
     */
    @SerializedName("market_album")
    private MarketCollection marketAlbum;

    /**
     * {@link Photo} object.
     */
    @SerializedName("photo")
    private Photo photo;

    /**
     * {@link Poll} object.
     */
    @SerializedName("poll")
    private Poll poll;

    /**
     * {@link Sticker} object.
     */
    @SerializedName("sticker")
    private Sticker sticker;

    /**
     * {@link Story} object.
     */
    @SerializedName("story")
    private Story story;

    /**
     * {@link Video} object.
     */
    @SerializedName("video")
    private Video video;

    /**
     * {@link WallPost} object.
     */
    @SerializedName("wall")
    private WallPost wall;

    /**
     * {@link WallComment} object.
     */
    @SerializedName("wall_reply")
    private WallComment wallReply;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public AudioMessage getAudioMessage() {
        return audioMessage;
    }

    public void setAudioMessage(AudioMessage audioMessage) {
        this.audioMessage = audioMessage;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    public Graffiti getGraffiti() {
        return graffiti;
    }

    public void setGraffiti(Graffiti graffiti) {
        this.graffiti = graffiti;
    }

    public AttachedLink getLink() {
        return link;
    }

    public void setLink(AttachedLink link) {
        this.link = link;
    }

    public MarketItem getMarket() {
        return market;
    }

    public void setMarket(MarketItem market) {
        this.market = market;
    }

    public MarketCollection getMarketAlbum() {
        return marketAlbum;
    }

    public void setMarketAlbum(MarketCollection marketAlbum) {
        this.marketAlbum = marketAlbum;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Sticker getSticker() {
        return sticker;
    }

    public void setSticker(Sticker sticker) {
        this.sticker = sticker;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public WallPost getWall() {
        return wall;
    }

    public void setWall(WallPost wall) {
        this.wall = wall;
    }

    public WallComment getWallReply() {
        return wallReply;
    }

    public void setWallReply(WallComment wallReply) {
        this.wallReply = wallReply;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", Attachment.class.getSimpleName() + "[", "]")
                .add("type=" + type);

        if (audio != null) {
            stringJoiner.add("audio=" + audio);
        }

        if (audioMessage != null) {
            stringJoiner.add("audioMessage=" + audioMessage);
        }

        if (doc != null) {
            stringJoiner.add("doc=" + doc);
        }

        if (graffiti != null) {
            stringJoiner.add("graffiti=" + graffiti);
        }

        if (link != null) {
            stringJoiner.add("link=" + link);
        }

        if (market != null) {
            stringJoiner.add("market=" + market);
        }

        if (marketAlbum != null) {
            stringJoiner.add("marketAlbum=" + marketAlbum);
        }

        if (photo != null) {
            stringJoiner.add("photo=" + photo);
        }

        if (poll != null) {
            stringJoiner.add("poll=" + poll);
        }

        if (sticker != null) {
            stringJoiner.add("sticker=" + sticker);
        }

        if (story != null) {
            stringJoiner.add("story=" + story);
        }

        if (video != null) {
            stringJoiner.add("video=" + video);
        }

        if (wall != null) {
            stringJoiner.add("wall=" + wall);
        }

        if (wallReply != null) {
            stringJoiner.add("wallReply=" + wallReply);
        }

        return stringJoiner.toString();
    }

    /**
     * Types of VK Attachments.
     */
    public enum Type {
        @SerializedName("audio") AUDIO,
        @SerializedName("audio_message") AUDIO_MESSAGE,
        @SerializedName("doc") DOCUMENT,
        @SerializedName("graffiti") GRAFFITI,
        @SerializedName("link") LINK,
        @SerializedName("market") MARKET,
        @SerializedName("market_album") MARKET_ALBUM,
        @SerializedName("photo") PHOTO,
        @SerializedName("poll") POLL,
        @SerializedName("sticker") STICKER,
        @SerializedName("story") STORY,
        @SerializedName("wall") WALL_POST,
        @SerializedName("wall_reply") WALL_REPLY,
        @SerializedName("video") VIDEO
    }
}
