package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.StringJoiner;

/**
 * Describes document.
 *
 * @see <a href="https://vk.com/dev/objects/doc">Document</a>
 */
public class Doc {
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
    private Type type;

    /**
     * Document preview data.
     */
    @SerializedName("preview")
    private Preview preview;

    /**
     * Document access key.
     */
    @SerializedName("access_key")
    private String accessKey;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", title='" + title + '\'' +
                ", size=" + size +
                ", ext='" + ext + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                ", type=" + type +
                ", preview=" + preview +
                ", accessKey='" + accessKey + '\'' +
                '}';
    }

    /**
     * Document preview data.
     */
    public static class Preview {
        /**
         * Preview image.
         */
        private Photo photo;

        /**
         * Preview graffiti.
         */
        private Graffiti graffiti;

        /**
         * Preview audio message.
         */
        private AudioMessage audioMessage;

        /**
         * Preview video.
         */
        private Video video;

        public Photo getPhoto() {
            return photo;
        }

        public void setPhoto(Photo photo) {
            this.photo = photo;
        }

        public Graffiti getGraffiti() {
            return graffiti;
        }

        public void setGraffiti(Graffiti graffiti) {
            this.graffiti = graffiti;
        }

        public AudioMessage getAudioMessage() {
            return audioMessage;
        }

        public void setAudioMessage(AudioMessage audioMessage) {
            this.audioMessage = audioMessage;
        }

        public Video getVideo() {
            return video;
        }

        public void setVideo(Video video) {
            this.video = video;
        }

        @Override
        public String toString() {
            StringJoiner stringJoiner = new StringJoiner(", ", Preview.class.getSimpleName() + "[", "]");

            if (photo != null) {
                stringJoiner.add("photo=" + photo);
            }

            if (graffiti != null) {
                stringJoiner.add("graffiti=" + graffiti);
            }

            if (audioMessage != null) {
                stringJoiner.add("audioMessage=" + audioMessage);
            }

            if (video != null) {
                stringJoiner.add("video=" + video);
            }

            return stringJoiner.toString();
        }

        /**
         * Describes document photo preview data.
         */
        public static class Photo {
            /**
             * Array with the photo copies of different sizes.
             */
            @SerializedName("sizes")
            private List<PhotoSize> sizes;

            public List<PhotoSize> getSizes() {
                return sizes;
            }

            public void setSizes(List<PhotoSize> sizes) {
                this.sizes = sizes;
            }

            @Override
            public String toString() {
                return "Photo{" +
                        "sizes=" + sizes +
                        '}';
            }
        }

        /**
         * Describes document graffiti preview data.
         */
        public static class Graffiti {
            /**
             * Doc URL with graffiti
             */
            @SerializedName("src")
            private String src;

            /**
             * VideoImage width in pixels.
             */
            @SerializedName("width")
            private Integer width;

            /**
             * VideoImage height in pixels.
             */
            @SerializedName("height")
            private Integer height;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            @Override
            public String toString() {
                return "Graffiti{" +
                        "src='" + src + '\'' +
                        ", width=" + width +
                        ", height=" + height +
                        '}';
            }
        }

        /**
         * Describes document audio message preview data.
         */
        public static class AudioMessage {
            /**
             * Audio message duration in seconds.
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

            public void setDuration(Integer duration) {
                this.duration = duration;
            }

            public List<Integer> getWaveform() {
                return waveform;
            }

            public void setWaveform(List<Integer> waveform) {
                this.waveform = waveform;
            }

            public String getLinkOgg() {
                return linkOgg;
            }

            public void setLinkOgg(String linkOgg) {
                this.linkOgg = linkOgg;
            }

            public String getLinkMp3() {
                return linkMp3;
            }

            public void setLinkMp3(String linkMp3) {
                this.linkMp3 = linkMp3;
            }

            @Override
            public String toString() {
                return "AudioMessage{" +
                        "duration=" + duration +
                        ", waveform=" + waveform +
                        ", linkOgg='" + linkOgg + '\'' +
                        ", linkMp3='" + linkMp3 + '\'' +
                        '}';
            }
        }

        /**
         * Describes document video preview data.
         */
        public static class Video {
            /**
             * Video link.
             */
            @SerializedName("src")
            private String src;

            /**
             * Video width.
             */
            @SerializedName("width")
            private Integer width;

            /**
             * Video height.
             */
            @SerializedName("height")
            private Integer height;

            /**
             * Video size in bytes.
             */
            @SerializedName("file_size")
            private Integer fileSize;

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public Integer getWidth() {
                return width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public Integer getHeight() {
                return height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            public Integer getFileSize() {
                return fileSize;
            }

            public void setFileSize(Integer fileSize) {
                this.fileSize = fileSize;
            }

            @Override
            public String toString() {
                return "Video{" +
                        "src='" + src + '\'' +
                        ", width=" + width +
                        ", height=" + height +
                        ", fileSize=" + fileSize +
                        '}';
            }
        }
    }

    /**
     * Document type.
     */
    public enum Type {
        @SerializedName("1") TEXT_DOCUMENT,
        @SerializedName("2") ARCHIVES,
        @SerializedName("3") GIF,
        @SerializedName("4") IMAGES,
        @SerializedName("5") AUDIO,
        @SerializedName("6") VIDEO,
        @SerializedName("7") E_BOOKS,
        @SerializedName("8") UNKNOWN
    }
}
