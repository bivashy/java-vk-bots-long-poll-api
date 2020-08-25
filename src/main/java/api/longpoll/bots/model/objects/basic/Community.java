package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.objects.additional.Country;
import api.longpoll.bots.model.objects.additional.CropPhoto;
import api.longpoll.bots.model.objects.additional.Currency;
import api.longpoll.bots.model.objects.additional.Image;
import api.longpoll.bots.model.objects.media.Photo;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Community {
	@SerializedName("id")
	private Integer id;
	@SerializedName("name")
	private String name;
	@SerializedName("screen_name")
	private String screenName;
	@SerializedName("is_closed")
	private Integer isClosed;
	@SerializedName("deactivated")
	private String deactivated;
	@SerializedName("is_admin")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean admin;
	@SerializedName("admin_level")
	private Integer adminLevel;
	@SerializedName("is_member")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean member;
	@SerializedName("is_advertiser")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean advertiser;
	@SerializedName("invited_by")
	private Integer invitedBy;
	@SerializedName("type")
	private String type;
	@SerializedName("photo_50")
	private String photo50;
	@SerializedName("photo_100")
	private String photo100;
	@SerializedName("photo_200")
	private String photo200;
	@SerializedName("activity")
	private String activity;
	@SerializedName("addresses")
	private Addresses addresses;
	@SerializedName("age_limits")
	private Integer ageLimits;
	@SerializedName("ban_info")
	private BanInfo banInfo;
	@SerializedName("can_create_topic")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean canCreateTopic;
	@SerializedName("can_message")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean canMessage;
	@SerializedName("can_post")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean canPost;
	@SerializedName("can_see_all_posts")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean canSeeAllPosts;
	@SerializedName("can_upload_doc")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean canUploadDoc;
	@SerializedName("can_upload_video")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean canUploadVideo;
	@SerializedName("city")
	private City city;
	@SerializedName("contacts")
	private List<Contact> contacts;
	@SerializedName("counters")
	private Counters counters;
	@SerializedName("country")
	private Country country;
	@SerializedName("cover")
	private Cover cover;
	@SerializedName("crop_photo")
	private CropPhoto cropPhoto;
	@SerializedName("description")
	private String description;
	@SerializedName("fixed_post")
	private Integer fixedPost;
	@SerializedName("has_photo")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean hasPhoto;
	@SerializedName("is_favorite")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean favorite;
	@SerializedName("is_hidden_from_feed")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean hiddenFromFeed;
	@SerializedName("is_messages_blocked")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean messagesBlocked;
	@SerializedName("links")
	private List<Link> links;
	@SerializedName("main_album_id")
	private Integer mainAlbumId;
	@SerializedName("main_section")
	private Integer mainSection;
	@SerializedName("market")
	private Market market;
	@SerializedName("member_status")
	private Integer memberStatus;
	@SerializedName("members_count")
	private Integer membersCount;
	@SerializedName("place")
	private Place place;
	@SerializedName("public_date_label")
	private String public_date_label;
	@SerializedName("site")
	private String site;
	@SerializedName("start_date")
	private Object startDate;
	@SerializedName("finish_date")
	private Integer finishDate;
	@SerializedName("status")
	private String status;
	@SerializedName("trending")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean trending;
	@SerializedName("verified")
	@JsonAdapter(BoolIntAdapter.class)
	private Boolean verified;
	@SerializedName("wall")
	private Integer wall;
	@SerializedName("wiki_page")
	private String wikiPage;

	public static class Addresses {
		@SerializedName("is_enabled")
		private Boolean enabled;
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
	}

	public static class BanInfo {
		@SerializedName("end_date")
		private Integer endDate;
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
	}

	public static class City {
		@SerializedName("id")
		private Integer id;
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
	}

	public static class Contact {
		@SerializedName("user_id")
		private Integer userId;
		@SerializedName("desc")
		private String desc;
		@SerializedName("phone")
		private String phone;
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
	}

	public static class Counters {
		@SerializedName("photos")
		private Integer photos;
		@SerializedName("albums")
		private Integer albums;
		@SerializedName("audios")
		private Integer audios;
		@SerializedName("videos")
		private Integer videos;
		@SerializedName("topics")
		private Integer topics;
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
	}

	public static class Cover {
		@SerializedName("enabled")
		@JsonAdapter(BoolIntAdapter.class)
		private Boolean enabled;
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
	}

	public static class Link {
		@SerializedName("id")
		private Integer id;
		@SerializedName("url")
		private String url;
		@SerializedName("name")
		private String name;
		@SerializedName("desc")
		private String desc;
		@SerializedName("photo_50")
		private String photo50;
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
	}

	public static class Market {
		@SerializedName("enabled")
		@JsonAdapter(BoolIntAdapter.class)
		private Boolean enabled;
		@SerializedName("price_min")
		private Integer priceMin;
		@SerializedName("price_max")
		private Integer priceMax;
		@SerializedName("main_album_id")
		private Integer mainAlbumId;
		@SerializedName("contact_id")
		private Integer contactId;
		@SerializedName("currency")
		private Currency currency;
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
	}

	public static class Place {
		@SerializedName("id")
		private Integer id;
		@SerializedName("title")
		private String title;
		@SerializedName("latitude")
		private Float latitude;
		@SerializedName("longitude")
		private Float longitude;
		@SerializedName("type")
		private Integer type;
		@SerializedName("country")
		private Integer country;
		@SerializedName("city")
		private Integer city;
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
}
