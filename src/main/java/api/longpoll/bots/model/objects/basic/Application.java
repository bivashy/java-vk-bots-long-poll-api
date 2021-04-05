package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.objects.media.Photo;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes application.
 *
 * @see <a href="https://vk.com/dev/objects/app">Application</a>
 */
public class Application {
    /**
     * App ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * App title.
     */
    @SerializedName("title")
    private String title;

    /**
     * URL of the preview image with 278 px in width.
     */
    @SerializedName("icon_278")
    private String icon278;

    /**
     * URL of the preview image with 139 px in width.
     */
    @SerializedName("icon_139")
    private String icon139;

    /**
     * URL of the preview image with 150 px in width.
     */
    @SerializedName("icon_150")
    private String icon150;

    /**
     * URL of the preview image with 75 px in width.
     */
    @SerializedName("icon_75")
    private String icon75;

    /**
     * URL of the banner with 560 px in width.
     */
    @SerializedName("banner_560")
    private String banner560;

    /**
     * URL of the banner with 1120 px in width.
     */
    @SerializedName("banner_1120")
    private String banner1120;

    /**
     * App type. Possible values:
     * <ul>
     *     <li><b>app</b> — social app</li>
     *     <li><b>game</b> — game</li>
     *     <li><b>site</b> — site</li>
     *     <li><b>standalone</b> — standalone</li>
     * </ul>
     */
    @SerializedName("type")
    private String type;

    /**
     * App category.
     */
    @SerializedName("section")
    private String section;

    /**
     * App author page address.
     */
    @SerializedName("author_url")
    private String authorUrl;

    /**
     * App author ID.
     */
    @SerializedName("author_id")
    private Integer authorId;

    /**
     * Official community ID.
     */
    @SerializedName("author_group")
    private Integer authorGroup;

    /**
     * Members count.
     */
    @SerializedName("members_count")
    private Integer membersCount;

    /**
     * Creation date in Unixtime.
     */
    @SerializedName("published_date")
    private Integer publishedDate;

    /**
     * Catalog position.
     */
    @SerializedName("catalog_position")
    private Integer catalogPosition;

    /**
     * Whether the app is multilanguage.
     */
    @SerializedName("international")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean international;

    /**
     * Leaderboard type. Possible values:
     * <ul>
     *     <li><b>0</b> — not supported</li>
     *     <li><b>1</b>— by level</li>
     *     <li><b>2</b> — by points</li>
     * </ul>
     */
    @SerializedName("leaderboard_type")
    private Integer leaderboardType;

    /**
     * Genre ID.
     */
    @SerializedName("genre_id")
    private Integer genreId;

    /**
     * Genre name.
     */
    @SerializedName("genre")
    private String genre;

    /**
     * App ID in store.
     */
    @SerializedName("platform_id")
    private String platformId;

    /**
     * Whether the app is available in mobile catalog.
     */
    @SerializedName("is_in_catalog")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean isInCatalog;

    /**
     * Description.
     */
    @SerializedName("description")
    private String description;

    /**
     * Screen name (or idXXXXXXX string if screen name is not specified).
     */
    @SerializedName("screen_name")
    private String screenName;

    /**
     * URL of the preview image with 16px in width.
     */
    @SerializedName("icon_16")
    private String icon16;

    /**
     * List of photo objects describing app screenshots.
     */
    @SerializedName("screenshots")
    private List<Photo> screenshots;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon278() {
        return icon278;
    }

    public void setIcon278(String icon278) {
        this.icon278 = icon278;
    }

    public String getIcon139() {
        return icon139;
    }

    public void setIcon139(String icon139) {
        this.icon139 = icon139;
    }

    public String getIcon150() {
        return icon150;
    }

    public void setIcon150(String icon150) {
        this.icon150 = icon150;
    }

    public String getIcon75() {
        return icon75;
    }

    public void setIcon75(String icon75) {
        this.icon75 = icon75;
    }

    public String getBanner560() {
        return banner560;
    }

    public void setBanner560(String banner560) {
        this.banner560 = banner560;
    }

    public String getBanner1120() {
        return banner1120;
    }

    public void setBanner1120(String banner1120) {
        this.banner1120 = banner1120;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getAuthorGroup() {
        return authorGroup;
    }

    public void setAuthorGroup(Integer authorGroup) {
        this.authorGroup = authorGroup;
    }

    public Integer getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(Integer membersCount) {
        this.membersCount = membersCount;
    }

    public Integer getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Integer publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getCatalogPosition() {
        return catalogPosition;
    }

    public void setCatalogPosition(Integer catalogPosition) {
        this.catalogPosition = catalogPosition;
    }

    public Boolean getInternational() {
        return international;
    }

    public void setInternational(Boolean international) {
        this.international = international;
    }

    public Integer getLeaderboardType() {
        return leaderboardType;
    }

    public void setLeaderboardType(Integer leaderboardType) {
        this.leaderboardType = leaderboardType;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public Boolean getInCatalog() {
        return isInCatalog;
    }

    public void setInCatalog(Boolean inCatalog) {
        isInCatalog = inCatalog;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getIcon16() {
        return icon16;
    }

    public void setIcon16(String icon16) {
        this.icon16 = icon16;
    }

    public List<Photo> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<Photo> screenshots) {
        this.screenshots = screenshots;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", icon278='" + icon278 + '\'' +
                ", icon139='" + icon139 + '\'' +
                ", icon150='" + icon150 + '\'' +
                ", icon75='" + icon75 + '\'' +
                ", banner560='" + banner560 + '\'' +
                ", banner1120='" + banner1120 + '\'' +
                ", type='" + type + '\'' +
                ", section='" + section + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", authorId=" + authorId +
                ", authorGroup=" + authorGroup +
                ", membersCount=" + membersCount +
                ", publishedDate=" + publishedDate +
                ", catalogPosition=" + catalogPosition +
                ", international=" + international +
                ", leaderboardType=" + leaderboardType +
                ", genreId=" + genreId +
                ", genre='" + genre + '\'' +
                ", platformId='" + platformId + '\'' +
                ", isInCatalog=" + isInCatalog +
                ", description='" + description + '\'' +
                ", screenName='" + screenName + '\'' +
                ", icon16='" + icon16 + '\'' +
                ", screenshots=" + screenshots +
                '}';
    }
}
