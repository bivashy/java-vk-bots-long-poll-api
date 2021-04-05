package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.objects.additional.Country;
import api.longpoll.bots.model.objects.additional.CropPhoto;
import api.longpoll.bots.model.objects.additional.Currency;
import api.longpoll.bots.model.objects.additional.Image;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes VK community.
 *
 * @see <a href="https://vk.com/dev/objects/group">Community</a>
 */
public class Community {
    /**
     * Community ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Community name.
     */
    @SerializedName("name")
    private String name;

    /**
     * Screen name of the community page (e.g. apiclub or club1).
     */
    @SerializedName("screen_name")
    private String screenName;

    /**
     * Whether the community is closed (0 — open, 1 — closed, 2 — private).
     */
    @SerializedName("is_closed")
    private Integer isClosed;

    /**
     * Returns if the community is deleted or blocked.
     */
    @SerializedName("deactivated")
    private String deactivated;

    /**
     * Whether a user is the community manager.
     */
    @SerializedName("is_admin")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean admin;

    /**
     * Rights of the user (1 — moderator, 2 — editor, 3 — administrator).
     */
    @SerializedName("admin_level")
    private Integer adminLevel;

    /**
     * Whether a user is a community member.
     */
    @SerializedName("is_member")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean member;

    /**
     * Whether the current user is an advertiser.
     */
    @SerializedName("is_advertiser")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean advertiser;

    /**
     * User ID who invited current user to the community.
     */
    @SerializedName("invited_by")
    private Integer invitedBy;

    /**
     * Community type (group — group, page — public page, event — event).
     */
    @SerializedName("type")
    private String type;

    /**
     * URL of the 50px-wide community logo.
     */
    @SerializedName("photo_50")
    private String photo50;

    /**
     * URL of the 100px-wide community logo.
     */
    @SerializedName("photo_100")
    private String photo100;

    /**
     * URL of the 200px-wide community logo.
     */
    @SerializedName("photo_200")
    private String photo200;

    /**
     * Returns the public page status bar.
     */
    @SerializedName("activity")
    private String activity;

    /**
     * Information about community addresses.
     */
    @SerializedName("addresses")
    private Addresses addresses;

    /**
     * Age limits.
     */
    @SerializedName("age_limits")
    private Integer ageLimits;

    /**
     * Information about adding to the community's blacklist.
     */
    @SerializedName("ban_info")
    private BanInfo banInfo;

    /**
     * Whether current user can create discussion in the community.
     */
    @SerializedName("can_create_topic")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canCreateTopic;

    /**
     * Whether current user can send message to the community.
     */
    @SerializedName("can_message")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canMessage;

    /**
     * Whether current user can post on the community's wall.
     */
    @SerializedName("can_post")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canPost;

    /**
     * Whether current user can see all posts on the community's wall.
     */
    @SerializedName("can_see_all_posts")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canSeeAllPosts;

    /**
     * Whether current user can upload documents to the community.
     */
    @SerializedName("can_upload_doc")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canUploadDoc;

    /**
     * Whether current user can upload video to the community.
     */
    @SerializedName("can_upload_video")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canUploadVideo;

    /**
     * City specified in information about community.
     */
    @SerializedName("city")
    private City city;

    /**
     * Information from public page contact module.
     */
    @SerializedName("contacts")
    private List<Contact> contacts;

    /**
     * Counters object with community counters.
     */
    @SerializedName("counters")
    private Counters counters;

    /**
     * Country specified in information about community.
     */
    @SerializedName("country")
    private Country country;

    /**
     * Community cover.
     */
    @SerializedName("cover")
    private Cover cover;

    /**
     * Returns data about the points from which the profile and thumbnail photos of the community were cut.
     */
    @SerializedName("crop_photo")
    private CropPhoto cropPhoto;

    /**
     * Community description text.
     */
    @SerializedName("description")
    private String description;

    /**
     * Fixed wall post ID.
     */
    @SerializedName("fixed_post")
    private Integer fixedPost;

    /**
     * Whether the community has a master photo.
     */
    @SerializedName("has_photo")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean hasPhoto;

    /**
     * Whether the community is in faves of current user.
     */
    @SerializedName("is_favorite")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean favorite;

    /**
     * Whether the community is hidden from feed of current user.
     */
    @SerializedName("is_hidden_from_feed")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean hiddenFromFeed;

    /**
     * Whether sending messages from community to current user is blocked.
     */
    @SerializedName("is_messages_blocked")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean messagesBlocked;

    /**
     * Information from public page links module.
     */
    @SerializedName("links")
    private List<Link> links;

    /**
     * Main photo album ID.
     */
    @SerializedName("main_album_id")
    private Integer mainAlbumId;

    /**
     * Main section info.
     */
    @SerializedName("main_section")
    private Integer mainSection;

    /**
     * Market info.
     */
    @SerializedName("market")
    private Market market;

    /**
     * Current user's member status.
     */
    @SerializedName("member_status")
    private Integer memberStatus;

    /**
     * Number of community members.
     */
    @SerializedName("members_count")
    private Integer membersCount;

    /**
     * Location specified in information about community.
     */
    @SerializedName("place")
    private Place place;

    /**
     * For public pages only. Description text for start_date.
     */
    @SerializedName("public_date_label")
    private String public_date_label;

    /**
     * Website URL.
     */
    @SerializedName("site")
    private String site;

    /**
     * Contain start time of the meeting as Unixtime or foundation date for public pages.
     */
    @SerializedName("start_date")
    private Object startDate;

    /**
     * Contain end time of the meeting as Unixtime or foundation date for public pages.
     */
    @SerializedName("finish_date")
    private Integer finishDate;

    /**
     * Group status.
     */
    @SerializedName("status")
    private String status;

    /**
     * Whether the community has a "fire" pictogram.
     */
    @SerializedName("trending")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean trending;

    /**
     * Whether the community is verified.
     */
    @SerializedName("verified")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean verified;

    /**
     * Community wall status.
     */
    @SerializedName("wall")
    private Integer wall;

    /**
     * Name of the home wiki-page of the community.
     */
    @SerializedName("wiki_page")
    private String wikiPage;

    /**
     * Describes addresses.
     */
    public static class Addresses {
        /**
         * Whether the block of addresses is included in the community.
         */
        @SerializedName("is_enabled")
        private Boolean enabled;

        /**
         * Main address ID.
         */
        @SerializedName("main_address_id")
        private Integer mainAddressId;

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public Integer getMainAddressId() {
            return mainAddressId;
        }

        public void setMainAddressId(Integer mainAddressId) {
            this.mainAddressId = mainAddressId;
        }

        @Override
        public String toString() {
            return "Addresses{" +
                    "enabled=" + enabled +
                    ", mainAddressId=" + mainAddressId +
                    '}';
        }
    }

    /**
     * Describes ban information.
     */
    public static class BanInfo {
        /**
         * Time of ban ending in Unixtime.
         */
        @SerializedName("end_date")
        private Integer endDate;

        /**
         * Ban comment.
         */
        @SerializedName("comment")
        private String comment;

        public Integer getEndDate() {
            return endDate;
        }

        public void setEndDate(Integer endDate) {
            this.endDate = endDate;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        @Override
        public String toString() {
            return "BanInfo{" +
                    "endDate=" + endDate +
                    ", comment='" + comment + '\'' +
                    '}';
        }
    }

    /**
     * Describes City.
     */
    public static class City {
        /**
         * City ID.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * City name.
         */
        @SerializedName("title")
        private String title;

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

        @Override
        public String toString() {
            return "City{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    /**
     * Describes contact.
     */
    public static class Contact {
        /**
         * User ID.
         */
        @SerializedName("user_id")
        private Integer userId;

        /**
         * Position.
         */
        @SerializedName("desc")
        private String desc;

        /**
         * Phone number.
         */
        @SerializedName("phone")
        private String phone;

        /**
         * E-mail.
         */
        @SerializedName("email")
        private String email;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "userId=" + userId +
                    ", desc='" + desc + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }

    /**
     * Describes counters.
     */
    public static class Counters {
        /**
         * Amount of photos.
         */
        @SerializedName("photos")
        private Integer photos;

        /**
         * Amount of albums.
         */
        @SerializedName("albums")
        private Integer albums;

        /**
         * Amount of audios.
         */
        @SerializedName("audios")
        private Integer audios;

        /**
         * Amount of videos.
         */
        @SerializedName("videos")
        private Integer videos;

        /**
         * Amount of topics.
         */
        @SerializedName("topics")
        private Integer topics;

        /**
         * Amount of documents.
         */
        @SerializedName("docs")
        private Integer docs;

        public Integer getPhotos() {
            return photos;
        }

        public void setPhotos(Integer photos) {
            this.photos = photos;
        }

        public Integer getAlbums() {
            return albums;
        }

        public void setAlbums(Integer albums) {
            this.albums = albums;
        }

        public Integer getAudios() {
            return audios;
        }

        public void setAudios(Integer audios) {
            this.audios = audios;
        }

        public Integer getVideos() {
            return videos;
        }

        public void setVideos(Integer videos) {
            this.videos = videos;
        }

        public Integer getTopics() {
            return topics;
        }

        public void setTopics(Integer topics) {
            this.topics = topics;
        }

        public Integer getDocs() {
            return docs;
        }

        public void setDocs(Integer docs) {
            this.docs = docs;
        }

        @Override
        public String toString() {
            return "Counters{" +
                    "photos=" + photos +
                    ", albums=" + albums +
                    ", audios=" + audios +
                    ", videos=" + videos +
                    ", topics=" + topics +
                    ", docs=" + docs +
                    '}';
        }
    }

    /**
     * Describes community cover.
     */
    public static class Cover {
        /**
         * Whether the cover is enabled.
         */
        @SerializedName("enabled")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean enabled;

        /**
         * Cover image copies.
         */
        @SerializedName("images")
        private List<Image> images;

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "Cover{" +
                    "enabled=" + enabled +
                    ", images=" + images +
                    '}';
        }
    }

    /**
     * Describes link.
     */
    public static class Link {
        /**
         * Link ID.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * URL.
         */
        @SerializedName("url")
        private String url;

        /**
         * Link title.
         */
        @SerializedName("name")
        private String name;

        /**
         * Link description.
         */
        @SerializedName("desc")
        private String desc;

        /**
         * URL preview image with width of 50 px.
         */
        @SerializedName("photo_50")
        private String photo50;

        /**
         * URL preview image with width of 100 px.
         */
        @SerializedName("photo_100")
        private String photo100;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPhoto50() {
            return photo50;
        }

        public void setPhoto50(String photo50) {
            this.photo50 = photo50;
        }

        public String getPhoto100() {
            return photo100;
        }

        public void setPhoto100(String photo100) {
            this.photo100 = photo100;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "id=" + id +
                    ", url='" + url + '\'' +
                    ", name='" + name + '\'' +
                    ", desc='" + desc + '\'' +
                    ", photo50='" + photo50 + '\'' +
                    ", photo100='" + photo100 + '\'' +
                    '}';
        }
    }

    /**
     * Describes market info.
     */
    public static class Market {
        /**
         * Whether market block is enabled.
         */
        @SerializedName("enabled")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean enabled;

        /**
         * Minimum price.
         */
        @SerializedName("price_min")
        private Integer priceMin;

        /**
         * Maximum price.
         */
        @SerializedName("price_max")
        private Integer priceMax;

        /**
         * Main collection ID.
         */
        @SerializedName("main_album_id")
        private Integer mainAlbumId;

        /**
         * Contact person ID.
         */
        @SerializedName("contact_id")
        private Integer contactId;

        /**
         * Currency info.
         */
        @SerializedName("currency")
        private Currency currency;

        /**
         * String designation.
         */
        @SerializedName("currency_text")
        private String currencyText;

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

        public Integer getPriceMin() {
            return priceMin;
        }

        public void setPriceMin(Integer priceMin) {
            this.priceMin = priceMin;
        }

        public Integer getPriceMax() {
            return priceMax;
        }

        public void setPriceMax(Integer priceMax) {
            this.priceMax = priceMax;
        }

        public Integer getMainAlbumId() {
            return mainAlbumId;
        }

        public void setMainAlbumId(Integer mainAlbumId) {
            this.mainAlbumId = mainAlbumId;
        }

        public Integer getContactId() {
            return contactId;
        }

        public void setContactId(Integer contactId) {
            this.contactId = contactId;
        }

        public Currency getCurrency() {
            return currency;
        }

        public void setCurrency(Currency currency) {
            this.currency = currency;
        }

        public String getCurrencyText() {
            return currencyText;
        }

        public void setCurrencyText(String currencyText) {
            this.currencyText = currencyText;
        }

        @Override
        public String toString() {
            return "Market{" +
                    "enabled=" + enabled +
                    ", priceMin=" + priceMin +
                    ", priceMax=" + priceMax +
                    ", mainAlbumId=" + mainAlbumId +
                    ", contactId=" + contactId +
                    ", currency=" + currency +
                    ", currencyText='" + currencyText + '\'' +
                    '}';
        }
    }

    /**
     * Describes location.
     */
    public static class Place {
        /**
         * Location ID.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * Location title.
         */
        @SerializedName("title")
        private String title;

        /**
         * Geographical latitude, in degrees.
         */
        @SerializedName("latitude")
        private Float latitude;

        /**
         * Geographical longitude, in degrees.
         */
        @SerializedName("longitude")
        private Float longitude;

        /**
         * Location type.
         */
        @SerializedName("type")
        private Integer type;

        /**
         * Country ID.
         */
        @SerializedName("country")
        private Integer country;

        /**
         * City ID.
         */
        @SerializedName("city")
        private Integer city;

        /**
         * Address.
         */
        @SerializedName("address")
        private String address;

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

        public Float getLatitude() {
            return latitude;
        }

        public void setLatitude(Float latitude) {
            this.latitude = latitude;
        }

        public Float getLongitude() {
            return longitude;
        }

        public void setLongitude(Float longitude) {
            this.longitude = longitude;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getCountry() {
            return country;
        }

        public void setCountry(Integer country) {
            this.country = country;
        }

        public Integer getCity() {
            return city;
        }

        public void setCity(Integer city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Place{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", type=" + type +
                    ", country=" + country +
                    ", city=" + city +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Integer getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(String deactivated) {
        this.deactivated = deactivated;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Integer getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(Integer adminLevel) {
        this.adminLevel = adminLevel;
    }

    public Boolean getMember() {
        return member;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }

    public Boolean getAdvertiser() {
        return advertiser;
    }

    public void setAdvertiser(Boolean advertiser) {
        this.advertiser = advertiser;
    }

    public Integer getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(Integer invitedBy) {
        this.invitedBy = invitedBy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto50() {
        return photo50;
    }

    public void setPhoto50(String photo50) {
        this.photo50 = photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    public String getPhoto200() {
        return photo200;
    }

    public void setPhoto200(String photo200) {
        this.photo200 = photo200;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public Integer getAgeLimits() {
        return ageLimits;
    }

    public void setAgeLimits(Integer ageLimits) {
        this.ageLimits = ageLimits;
    }

    public BanInfo getBanInfo() {
        return banInfo;
    }

    public void setBanInfo(BanInfo banInfo) {
        this.banInfo = banInfo;
    }

    public Boolean getCanCreateTopic() {
        return canCreateTopic;
    }

    public void setCanCreateTopic(Boolean canCreateTopic) {
        this.canCreateTopic = canCreateTopic;
    }

    public Boolean getCanMessage() {
        return canMessage;
    }

    public void setCanMessage(Boolean canMessage) {
        this.canMessage = canMessage;
    }

    public Boolean getCanPost() {
        return canPost;
    }

    public void setCanPost(Boolean canPost) {
        this.canPost = canPost;
    }

    public Boolean getCanSeeAllPosts() {
        return canSeeAllPosts;
    }

    public void setCanSeeAllPosts(Boolean canSeeAllPosts) {
        this.canSeeAllPosts = canSeeAllPosts;
    }

    public Boolean getCanUploadDoc() {
        return canUploadDoc;
    }

    public void setCanUploadDoc(Boolean canUploadDoc) {
        this.canUploadDoc = canUploadDoc;
    }

    public Boolean getCanUploadVideo() {
        return canUploadVideo;
    }

    public void setCanUploadVideo(Boolean canUploadVideo) {
        this.canUploadVideo = canUploadVideo;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Counters getCounters() {
        return counters;
    }

    public void setCounters(Counters counters) {
        this.counters = counters;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public CropPhoto getCropPhoto() {
        return cropPhoto;
    }

    public void setCropPhoto(CropPhoto cropPhoto) {
        this.cropPhoto = cropPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFixedPost() {
        return fixedPost;
    }

    public void setFixedPost(Integer fixedPost) {
        this.fixedPost = fixedPost;
    }

    public Boolean getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(Boolean hasPhoto) {
        this.hasPhoto = hasPhoto;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getHiddenFromFeed() {
        return hiddenFromFeed;
    }

    public void setHiddenFromFeed(Boolean hiddenFromFeed) {
        this.hiddenFromFeed = hiddenFromFeed;
    }

    public Boolean getMessagesBlocked() {
        return messagesBlocked;
    }

    public void setMessagesBlocked(Boolean messagesBlocked) {
        this.messagesBlocked = messagesBlocked;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Integer getMainAlbumId() {
        return mainAlbumId;
    }

    public void setMainAlbumId(Integer mainAlbumId) {
        this.mainAlbumId = mainAlbumId;
    }

    public Integer getMainSection() {
        return mainSection;
    }

    public void setMainSection(Integer mainSection) {
        this.mainSection = mainSection;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Integer getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Integer getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(Integer membersCount) {
        this.membersCount = membersCount;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getPublic_date_label() {
        return public_date_label;
    }

    public void setPublic_date_label(String public_date_label) {
        this.public_date_label = public_date_label;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    public Integer getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Integer finishDate) {
        this.finishDate = finishDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getTrending() {
        return trending;
    }

    public void setTrending(Boolean trending) {
        this.trending = trending;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Integer getWall() {
        return wall;
    }

    public void setWall(Integer wall) {
        this.wall = wall;
    }

    public String getWikiPage() {
        return wikiPage;
    }

    public void setWikiPage(String wikiPage) {
        this.wikiPage = wikiPage;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", screenName='" + screenName + '\'' +
                ", isClosed=" + isClosed +
                ", deactivated='" + deactivated + '\'' +
                ", admin=" + admin +
                ", adminLevel=" + adminLevel +
                ", member=" + member +
                ", advertiser=" + advertiser +
                ", invitedBy=" + invitedBy +
                ", type='" + type + '\'' +
                ", photo50='" + photo50 + '\'' +
                ", photo100='" + photo100 + '\'' +
                ", photo200='" + photo200 + '\'' +
                ", activity='" + activity + '\'' +
                ", addresses=" + addresses +
                ", ageLimits=" + ageLimits +
                ", banInfo=" + banInfo +
                ", canCreateTopic=" + canCreateTopic +
                ", canMessage=" + canMessage +
                ", canPost=" + canPost +
                ", canSeeAllPosts=" + canSeeAllPosts +
                ", canUploadDoc=" + canUploadDoc +
                ", canUploadVideo=" + canUploadVideo +
                ", city=" + city +
                ", contacts=" + contacts +
                ", counters=" + counters +
                ", country=" + country +
                ", cover=" + cover +
                ", cropPhoto=" + cropPhoto +
                ", description='" + description + '\'' +
                ", fixedPost=" + fixedPost +
                ", hasPhoto=" + hasPhoto +
                ", favorite=" + favorite +
                ", hiddenFromFeed=" + hiddenFromFeed +
                ", messagesBlocked=" + messagesBlocked +
                ", links=" + links +
                ", mainAlbumId=" + mainAlbumId +
                ", mainSection=" + mainSection +
                ", market=" + market +
                ", memberStatus=" + memberStatus +
                ", membersCount=" + membersCount +
                ", place=" + place +
                ", public_date_label='" + public_date_label + '\'' +
                ", site='" + site + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", status='" + status + '\'' +
                ", trending=" + trending +
                ", verified=" + verified +
                ", wall=" + wall +
                ", wikiPage='" + wikiPage + '\'' +
                '}';
    }
}
