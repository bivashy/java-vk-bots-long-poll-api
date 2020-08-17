package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.BoolIntAdapter;
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

	public class Addresses {
		@SerializedName("is_enabled")
		private Boolean enabled;
		@SerializedName("main_address_id")
		private Integer mainAddressId;

		public Boolean getEnabled() {
			return enabled;
		}

		public Addresses setEnabled(Boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public Integer getMainAddressId() {
			return mainAddressId;
		}

		public Addresses setMainAddressId(Integer mainAddressId) {
			this.mainAddressId = mainAddressId;
			return this;
		}
	}

	public class BanInfo {
		@SerializedName("end_date")
		private Integer endDate;
		@SerializedName("comment")
		private String comment;

		public Integer getEndDate() {
			return endDate;
		}

		public BanInfo setEndDate(Integer endDate) {
			this.endDate = endDate;
			return this;
		}

		public String getComment() {
			return comment;
		}

		public BanInfo setComment(String comment) {
			this.comment = comment;
			return this;
		}
	}

	public class City {
		@SerializedName("id")
		private Integer id;
		@SerializedName("title")
		private String title;

		public Integer getId() {
			return id;
		}

		public City setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getTitle() {
			return title;
		}

		public City setTitle(String title) {
			this.title = title;
			return this;
		}
	}

	public class Contact {
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

		public Contact setUserId(Integer userId) {
			this.userId = userId;
			return this;
		}

		public String getDesc() {
			return desc;
		}

		public Contact setDesc(String desc) {
			this.desc = desc;
			return this;
		}

		public String getPhone() {
			return phone;
		}

		public Contact setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public String getEmail() {
			return email;
		}

		public Contact setEmail(String email) {
			this.email = email;
			return this;
		}
	}

	public class Counters {
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

		public Counters setPhotos(Integer photos) {
			this.photos = photos;
			return this;
		}

		public Integer getAlbums() {
			return albums;
		}

		public Counters setAlbums(Integer albums) {
			this.albums = albums;
			return this;
		}

		public Integer getAudios() {
			return audios;
		}

		public Counters setAudios(Integer audios) {
			this.audios = audios;
			return this;
		}

		public Integer getVideos() {
			return videos;
		}

		public Counters setVideos(Integer videos) {
			this.videos = videos;
			return this;
		}

		public Integer getTopics() {
			return topics;
		}

		public Counters setTopics(Integer topics) {
			this.topics = topics;
			return this;
		}

		public Integer getDocs() {
			return docs;
		}

		public Counters setDocs(Integer docs) {
			this.docs = docs;
			return this;
		}
	}

	public class Country {
		@SerializedName("id")
		private Integer id;
		@SerializedName("title")
		private String title;

		public Integer getId() {
			return id;
		}

		public Country setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getTitle() {
			return title;
		}

		public Country setTitle(String title) {
			this.title = title;
			return this;
		}
	}

	public class Cover {
		@SerializedName("enabled")
		@JsonAdapter(BoolIntAdapter.class)
		private Boolean enabled;
		@SerializedName("images")
		private List<Image> images;

		public Boolean getEnabled() {
			return enabled;
		}

		public Cover setEnabled(Boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public List<Image> getImages() {
			return images;
		}

		public Cover setImages(List<Image> images) {
			this.images = images;
			return this;
		}
	}

	public class CropPhoto {
		@SerializedName("photo")
		private Photo photo;
		@SerializedName("crop")
		private Crop crop;
		@SerializedName("rect")
		private Crop rect;

		public class Crop {
			@SerializedName("x")
			private Float x;
			@SerializedName("y")
			private Float y;
			@SerializedName("x2")
			private Float x2;
			@SerializedName("y")
			private Float y2;

			public Float getX() {
				return x;
			}

			public Crop setX(Float x) {
				this.x = x;
				return this;
			}

			public Float getY() {
				return y;
			}

			public Crop setY(Float y) {
				this.y = y;
				return this;
			}

			public Float getX2() {
				return x2;
			}

			public Crop setX2(Float x2) {
				this.x2 = x2;
				return this;
			}

			public Float getY2() {
				return y2;
			}

			public Crop setY2(Float y2) {
				this.y2 = y2;
				return this;
			}
		}

		public Photo getPhoto() {
			return photo;
		}

		public CropPhoto setPhoto(Photo photo) {
			this.photo = photo;
			return this;
		}

		public Crop getCrop() {
			return crop;
		}

		public CropPhoto setCrop(Crop crop) {
			this.crop = crop;
			return this;
		}

		public Crop getRect() {
			return rect;
		}

		public CropPhoto setRect(Crop rect) {
			this.rect = rect;
			return this;
		}
	}

	public class Link {
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

		public Link setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getUrl() {
			return url;
		}

		public Link setUrl(String url) {
			this.url = url;
			return this;
		}

		public String getName() {
			return name;
		}

		public Link setName(String name) {
			this.name = name;
			return this;
		}

		public String getDesc() {
			return desc;
		}

		public Link setDesc(String desc) {
			this.desc = desc;
			return this;
		}

		public String getPhoto50() {
			return photo50;
		}

		public Link setPhoto50(String photo50) {
			this.photo50 = photo50;
			return this;
		}

		public String getPhoto100() {
			return photo100;
		}

		public Link setPhoto100(String photo100) {
			this.photo100 = photo100;
			return this;
		}
	}

	public class Market {
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

		public Market setEnabled(Boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		public Integer getPriceMin() {
			return priceMin;
		}

		public Market setPriceMin(Integer priceMin) {
			this.priceMin = priceMin;
			return this;
		}

		public Integer getPriceMax() {
			return priceMax;
		}

		public Market setPriceMax(Integer priceMax) {
			this.priceMax = priceMax;
			return this;
		}

		public Integer getMainAlbumId() {
			return mainAlbumId;
		}

		public Market setMainAlbumId(Integer mainAlbumId) {
			this.mainAlbumId = mainAlbumId;
			return this;
		}

		public Integer getContactId() {
			return contactId;
		}

		public Market setContactId(Integer contactId) {
			this.contactId = contactId;
			return this;
		}

		public Currency getCurrency() {
			return currency;
		}

		public Market setCurrency(Currency currency) {
			this.currency = currency;
			return this;
		}

		public String getCurrencyText() {
			return currencyText;
		}

		public Market setCurrencyText(String currencyText) {
			this.currencyText = currencyText;
			return this;
		}
	}

	public class Place {
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

		public Place setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getTitle() {
			return title;
		}

		public Place setTitle(String title) {
			this.title = title;
			return this;
		}

		public Float getLatitude() {
			return latitude;
		}

		public Place setLatitude(Float latitude) {
			this.latitude = latitude;
			return this;
		}

		public Float getLongitude() {
			return longitude;
		}

		public Place setLongitude(Float longitude) {
			this.longitude = longitude;
			return this;
		}

		public Integer getType() {
			return type;
		}

		public Place setType(Integer type) {
			this.type = type;
			return this;
		}

		public Integer getCountry() {
			return country;
		}

		public Place setCountry(Integer country) {
			this.country = country;
			return this;
		}

		public Integer getCity() {
			return city;
		}

		public Place setCity(Integer city) {
			this.city = city;
			return this;
		}

		public String getAddress() {
			return address;
		}

		public Place setAddress(String address) {
			this.address = address;
			return this;
		}
	}

	public Integer getId() {
		return id;
	}

	public Community setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Community setName(String name) {
		this.name = name;
		return this;
	}

	public String getScreenName() {
		return screenName;
	}

	public Community setScreenName(String screenName) {
		this.screenName = screenName;
		return this;
	}

	public Integer getIsClosed() {
		return isClosed;
	}

	public Community setIsClosed(Integer isClosed) {
		this.isClosed = isClosed;
		return this;
	}

	public String getDeactivated() {
		return deactivated;
	}

	public Community setDeactivated(String deactivated) {
		this.deactivated = deactivated;
		return this;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public Community setAdmin(Boolean admin) {
		this.admin = admin;
		return this;
	}

	public Integer getAdminLevel() {
		return adminLevel;
	}

	public Community setAdminLevel(Integer adminLevel) {
		this.adminLevel = adminLevel;
		return this;
	}

	public Boolean getMember() {
		return member;
	}

	public Community setMember(Boolean member) {
		this.member = member;
		return this;
	}

	public Boolean getAdvertiser() {
		return advertiser;
	}

	public Community setAdvertiser(Boolean advertiser) {
		this.advertiser = advertiser;
		return this;
	}

	public Integer getInvitedBy() {
		return invitedBy;
	}

	public Community setInvitedBy(Integer invitedBy) {
		this.invitedBy = invitedBy;
		return this;
	}

	public String getType() {
		return type;
	}

	public Community setType(String type) {
		this.type = type;
		return this;
	}

	public String getPhoto50() {
		return photo50;
	}

	public Community setPhoto50(String photo50) {
		this.photo50 = photo50;
		return this;
	}

	public String getPhoto100() {
		return photo100;
	}

	public Community setPhoto100(String photo100) {
		this.photo100 = photo100;
		return this;
	}

	public String getPhoto200() {
		return photo200;
	}

	public Community setPhoto200(String photo200) {
		this.photo200 = photo200;
		return this;
	}

	public String getActivity() {
		return activity;
	}

	public Community setActivity(String activity) {
		this.activity = activity;
		return this;
	}

	public Addresses getAddresses() {
		return addresses;
	}

	public Community setAddresses(Addresses addresses) {
		this.addresses = addresses;
		return this;
	}

	public Integer getAgeLimits() {
		return ageLimits;
	}

	public Community setAgeLimits(Integer ageLimits) {
		this.ageLimits = ageLimits;
		return this;
	}

	public BanInfo getBanInfo() {
		return banInfo;
	}

	public Community setBanInfo(BanInfo banInfo) {
		this.banInfo = banInfo;
		return this;
	}

	public Boolean getCanCreateTopic() {
		return canCreateTopic;
	}

	public Community setCanCreateTopic(Boolean canCreateTopic) {
		this.canCreateTopic = canCreateTopic;
		return this;
	}

	public Boolean getCanMessage() {
		return canMessage;
	}

	public Community setCanMessage(Boolean canMessage) {
		this.canMessage = canMessage;
		return this;
	}

	public Boolean getCanPost() {
		return canPost;
	}

	public Community setCanPost(Boolean canPost) {
		this.canPost = canPost;
		return this;
	}

	public Boolean getCanSeeAllPosts() {
		return canSeeAllPosts;
	}

	public Community setCanSeeAllPosts(Boolean canSeeAllPosts) {
		this.canSeeAllPosts = canSeeAllPosts;
		return this;
	}

	public Boolean getCanUploadDoc() {
		return canUploadDoc;
	}

	public Community setCanUploadDoc(Boolean canUploadDoc) {
		this.canUploadDoc = canUploadDoc;
		return this;
	}

	public Boolean getCanUploadVideo() {
		return canUploadVideo;
	}

	public Community setCanUploadVideo(Boolean canUploadVideo) {
		this.canUploadVideo = canUploadVideo;
		return this;
	}

	public City getCity() {
		return city;
	}

	public Community setCity(City city) {
		this.city = city;
		return this;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public Community setContacts(List<Contact> contacts) {
		this.contacts = contacts;
		return this;
	}

	public Counters getCounters() {
		return counters;
	}

	public Community setCounters(Counters counters) {
		this.counters = counters;
		return this;
	}

	public Country getCountry() {
		return country;
	}

	public Community setCountry(Country country) {
		this.country = country;
		return this;
	}

	public Cover getCover() {
		return cover;
	}

	public Community setCover(Cover cover) {
		this.cover = cover;
		return this;
	}

	public CropPhoto getCropPhoto() {
		return cropPhoto;
	}

	public Community setCropPhoto(CropPhoto cropPhoto) {
		this.cropPhoto = cropPhoto;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public Community setDescription(String description) {
		this.description = description;
		return this;
	}

	public Integer getFixedPost() {
		return fixedPost;
	}

	public Community setFixedPost(Integer fixedPost) {
		this.fixedPost = fixedPost;
		return this;
	}

	public Boolean getHasPhoto() {
		return hasPhoto;
	}

	public Community setHasPhoto(Boolean hasPhoto) {
		this.hasPhoto = hasPhoto;
		return this;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public Community setFavorite(Boolean favorite) {
		this.favorite = favorite;
		return this;
	}

	public Boolean getHiddenFromFeed() {
		return hiddenFromFeed;
	}

	public Community setHiddenFromFeed(Boolean hiddenFromFeed) {
		this.hiddenFromFeed = hiddenFromFeed;
		return this;
	}

	public Boolean getMessagesBlocked() {
		return messagesBlocked;
	}

	public Community setMessagesBlocked(Boolean messagesBlocked) {
		this.messagesBlocked = messagesBlocked;
		return this;
	}

	public List<Link> getLinks() {
		return links;
	}

	public Community setLinks(List<Link> links) {
		this.links = links;
		return this;
	}

	public Integer getMainAlbumId() {
		return mainAlbumId;
	}

	public Community setMainAlbumId(Integer mainAlbumId) {
		this.mainAlbumId = mainAlbumId;
		return this;
	}

	public Integer getMainSection() {
		return mainSection;
	}

	public Community setMainSection(Integer mainSection) {
		this.mainSection = mainSection;
		return this;
	}

	public Market getMarket() {
		return market;
	}

	public Community setMarket(Market market) {
		this.market = market;
		return this;
	}

	public Integer getMemberStatus() {
		return memberStatus;
	}

	public Community setMemberStatus(Integer memberStatus) {
		this.memberStatus = memberStatus;
		return this;
	}

	public Integer getMembersCount() {
		return membersCount;
	}

	public Community setMembersCount(Integer membersCount) {
		this.membersCount = membersCount;
		return this;
	}

	public Place getPlace() {
		return place;
	}

	public Community setPlace(Place place) {
		this.place = place;
		return this;
	}

	public String getPublic_date_label() {
		return public_date_label;
	}

	public Community setPublic_date_label(String public_date_label) {
		this.public_date_label = public_date_label;
		return this;
	}

	public String getSite() {
		return site;
	}

	public Community setSite(String site) {
		this.site = site;
		return this;
	}

	public Object getStartDate() {
		return startDate;
	}

	public Community setStartDate(Object startDate) {
		this.startDate = startDate;
		return this;
	}

	public Integer getFinishDate() {
		return finishDate;
	}

	public Community setFinishDate(Integer finishDate) {
		this.finishDate = finishDate;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Community setStatus(String status) {
		this.status = status;
		return this;
	}

	public Boolean getTrending() {
		return trending;
	}

	public Community setTrending(Boolean trending) {
		this.trending = trending;
		return this;
	}

	public Boolean getVerified() {
		return verified;
	}

	public Community setVerified(Boolean verified) {
		this.verified = verified;
		return this;
	}

	public Integer getWall() {
		return wall;
	}

	public Community setWall(Integer wall) {
		this.wall = wall;
		return this;
	}

	public String getWikiPage() {
		return wikiPage;
	}

	public Community setWikiPage(String wikiPage) {
		this.wikiPage = wikiPage;
		return this;
	}
}
