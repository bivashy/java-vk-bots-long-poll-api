package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
 * Describes photo size.
 *
 * @see <a href="https://vk.com/dev/objects/photo_sizes">Photo sizes format</a>
 */
public class PhotoSize {
    @SerializedName(value = "src", alternate = "url")
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PhotoSize{" +
                "url='" + src + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", type='" + type + '\'' +
                '}';
    }
}
