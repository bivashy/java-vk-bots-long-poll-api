package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.objects.additional.Country;
import api.longpoll.bots.model.objects.additional.CropPhoto;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Describes user.
 *
 * @see <a href="https://vk.com/dev/objects/user">User</a>
 */
public class User {
    /**
     * User ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * First name.
     */
    @SerializedName("first_name")
    private String firstName;

    /**
     * Last name.
     */
    @SerializedName("last_name")
    private String lastName;

    /**
     * Returns if a profile is deleted or blocked.
     */
    @SerializedName("deactivated")
    private String deactivated;

    /**
     * <b>true</b>, if user profile is closed by his privacy settings.
     */
    @SerializedName("is_closed")
    private Boolean closed;

    /**
     * <b>true</b>, if current user can see user profile.
     */
    @SerializedName("can_access_closed")
    private Boolean canAccessClosed;

    /**
     * "About me".
     */
    @SerializedName("about")
    private String about;

    /**
     * Activities.
     */
    @SerializedName("activities")
    private String activities;

    /**
     * User's date of birth.  Returned as DD.MM.YYYY or DD.MM (if birth year is hidden). If the whole date is hidden, no field is returned.
     */
    @SerializedName("bdate")
    private String birthDate;

    /**
     * <b>true</b> if a current user is in the requested user's blacklist.
     */
    @SerializedName("blacklisted")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean blacklisted;

    /**
     * <b>true</b> if a user is in the current user's blacklist.
     */
    @SerializedName("blacklisted_by_me")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean blacklistedByMe;

    /**
     * Favorite books.
     */
    @SerializedName("books")
    private String books;

    /**
     * Whether current user can post on the wall.
     */
    @SerializedName("can_post")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canPost;

    /**
     * Whether current user can see other users' posts on the wall.
     */
    @SerializedName("can_see_all_posts")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canSeeAllPosts;

    /**
     * Whether current user can see users' audio.
     */
    @SerializedName("can_see_audio")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canSeeAudio;

    /**
     * Whether current user can send friend request to a user.
     */
    @SerializedName("can_send_friend_request")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canSendFriendRequest;

    /**
     * Whether current user can write private messages to a user.
     */
    @SerializedName("can_write_private_message")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean canWritePrivateMessage;

    /**
     * Information about user's career.
     */
    @SerializedName("career")
    private Career career;

    /**
     * Information about user's military service.
     */
    @SerializedName("military")
    private Military military;

    /**
     * Favorite movies.
     */
    @SerializedName("movies")
    private String movies;

    /**
     * Favorite music.
     */
    @SerializedName("music")
    private String music;

    /**
     * Nickname.
     */
    @SerializedName("nickname")
    private String nickname;

    /**
     * City specified on user's page in "Contacts" section.
     */
    @SerializedName("city")
    private String city;

    /**
     * Number of common friends with current user.
     */
    @SerializedName("common_count")
    private Integer commonCount;

    /**
     * Returns specified services such as: skype, facebook, twitter, livejournal, instagram.
     */
    @SerializedName("connections")
    private Map<String, String> connections;

    /**
     * Information about user's phone numbers.
     */
    @SerializedName("contacts")
    private Contacts contacts;

    /**
     * Number of various objects the user has.
     */
    @SerializedName("counters")
    private Counters counters;

    /**
     * Country specified on user's page in "Contacts" section.
     */
    @SerializedName("country")
    private Country country;

    /**
     * Data about points used for cropping of profile and preview user photos.
     */
    @SerializedName("crop_photo")
    private CropPhoto cropPhoto;

    /**
     * Page screen name.
     */
    @SerializedName("domain")
    private String domain;

    /**
     * Information about user's higher education institution.
     */
    @SerializedName("education")
    private Education education;

    /**
     * External services with export configured (twitter, facebook, livejournal, instagram).
     */
    @SerializedName("exports")
    private String exports;

    /**
     * First name in nominative case.
     */
    @SerializedName("first_name_nom")
    private String firstNameNom;

    /**
     * First name in genitive case.
     */
    @SerializedName("first_name_gen")
    private String firstNameGen;

    /**
     * First name in dative case.
     */
    @SerializedName("first_name_dat")
    private String firstNameDat;

    /**
     * First name in accusative case.
     */
    @SerializedName("first_name_acc")
    private String firstNameAcc;

    /**
     * First name in instrumental case.
     */
    @SerializedName("first_name_ins")
    private String firstNameIns;

    /**
     * First name in prepositional case.
     */
    @SerializedName("first_name_abl")
    private String firstNameAbl;

    /**
     * Number of followers.
     */
    @SerializedName("followers_count")
    private Integer followersCount;

    /**
     * Friend status with a current user.
     */
    @SerializedName("friend_status")
    private Integer friendStatus;

    /**
     * Favorite games.
     */
    @SerializedName("games")
    private String games;

    /**
     * Whether the user's mobile phone number is available.
     */
    @SerializedName("has_mobile")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean hasMobile;

    /**
     * Whether the user has profile photo.
     */
    @SerializedName("has_photo")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean hasPhoto;

    /**
     * User's home town name.
     */
    @SerializedName("home_town")
    private String homeTown;

    /**
     * Interests.
     */
    @SerializedName("interests")
    private String interests;

    /**
     * Whether the user is in faves of current user.
     */
    @SerializedName("is_favorite")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean favorite;

    /**
     * Whether the user is a friend of current user.
     */
    @SerializedName("is_friend")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean friend;

    /**
     * Whether the user is hidden from current user's feed.
     */
    @SerializedName("is_hidden_from_feed")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean hiddenFromFeed;

    /**
     * Last name in nominative case.
     */
    @SerializedName("last_name_nom")
    private String lastNameNom;

    /**
     * Last name in genitive case.
     */
    @SerializedName("last_name_gen")
    private String lastNameGen;

    /**
     * Last name in dative case.
     */
    @SerializedName("last_name_dat")
    private String lastNameDat;

    /**
     * Last name in accusative case.
     */
    @SerializedName("last_name_acc")
    private String lastNameAcc;

    /**
     * Last name in instrumental case.
     */
    @SerializedName("last_name_ins")
    private String lastNameIns;

    /**
     * Last name in prepositional case.
     */
    @SerializedName("last_name_abl")
    private String lastNameAbl;

    /**
     * Last visit date.
     */
    @SerializedName("last_seen")
    private LastSeen lastSeen;

    /**
     * Comma-separated friend lists IDs the user is included to.
     */
    @SerializedName("lists")
    private String lists;

    /**
     * Maiden name.
     */
    @SerializedName("maiden_name")
    private String maidenName;

    /**
     * User's occupation.
     */
    @SerializedName("occupation")
    private Occupation occupation;

    /**
     * Whether the user is online.
     */
    @SerializedName("online")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean online;

    /**
     * Information from the "Personal views" section.
     */
    @SerializedName("personal")
    private Personal personal;

    /**
     * URL of square photo of the user with 50 pixels in width.
     */
    @SerializedName("photo_50")
    private String photo_50;

    /**
     * URL of square photo of the user with 100 pixels in width.
     */
    @SerializedName("photo_100")
    private String photo_100;

    /**
     * URL of user's photo with 200 pixels in width.
     */
    @SerializedName("photo_200_orig")
    private String photo_200_orig;

    /**
     * URL of square photo of the user with 200 pixels in width.
     */
    @SerializedName("photo_200")
    private String photo_200;

    /**
     * URL of user's photo with 400 pixels in width.
     */
    @SerializedName("photo_400_orig")
    private String photo_400_orig;

    /**
     * String ID of the main profile photo in format {user_id}_{photo_id}, e.g., 6492_192164258.
     */
    @SerializedName("photo_id")
    private String photo_id;

    /**
     * URL of square photo of the user with maximum width.
     */
    @SerializedName("photo_max")
    private String photo_max;

    /**
     * URL of user's photo of maximum size.
     */
    @SerializedName("photo_max_orig")
    private String photo_max_orig;

    /**
     * Favorite quotes.
     */
    @SerializedName("quotes")
    private String quotes;

    /**
     * Current user's relatives list.
     */
    @SerializedName("relatives")
    private List<Relative> relatives;

    /**
     * User relationship status.
     */
    @SerializedName("relation")
    private Integer relation;

    /**
     * List of schools where user studied.
     */
    @SerializedName("schools")
    private List<School> schools;

    /**
     * User page's screen name.
     */
    @SerializedName("screen_name")
    private String screen_name;

    /**
     * User sex.
     */
    @SerializedName("sex")
    private Integer sex;

    /**
     * Returns a website address from a user profile.
     */
    @SerializedName("site")
    private String site;

    /**
     * User status.
     */
    @SerializedName("status")
    private String status;

    /**
     * User time zone.
     */
    @SerializedName("timezone")
    private Integer timezone;

    /**
     * Whether the user a "fire" pictogram.
     */
    @SerializedName("trending")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean trending;

    /**
     * Favorite TV shows.
     */
    @SerializedName("tv")
    private String tv;

    /**
     * List of higher education institutions where user studied.
     */
    @SerializedName("universities")
    private List<University> universities;

    /**
     * <b>true</b> if the profile is verified.
     */
    @SerializedName("verified")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean verified;

    /**
     * Wall default.
     */
    @SerializedName("wall_default")
    private String wall_default;

    /**
     * Describes career.
     */
    public static class Career {
        /**
         * Community ID.
         */
        @SerializedName("group_id")
        private Integer groupId;

        /**
         * Company name.
         */
        @SerializedName("company")
        private String company;

        /**
         * Country ID.
         */
        @SerializedName("country_id")
        private Integer countryId;

        /**
         * City ID.
         */
        @SerializedName("city_id")
        private Integer cityId;

        /**
         * City name.
         */
        @SerializedName("city_name")
        private Integer cityName;

        /**
         * Career beginning year.
         */
        @SerializedName("from")
        private Integer from;

        /**
         * Career ending year.
         */
        @SerializedName("until")
        private Integer until;

        /**
         * Position.
         */
        @SerializedName("position")
        private String position;

        public Integer getGroupId() {
            return groupId;
        }

        public void setGroupId(Integer groupId) {
            this.groupId = groupId;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public Integer getCityName() {
            return cityName;
        }

        public void setCityName(Integer cityName) {
            this.cityName = cityName;
        }

        public Integer getFrom() {
            return from;
        }

        public void setFrom(Integer from) {
            this.from = from;
        }

        public Integer getUntil() {
            return until;
        }

        public void setUntil(Integer until) {
            this.until = until;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        @Override
        public String toString() {
            return "Career{" +
                    "groupId=" + groupId +
                    ", company='" + company + '\'' +
                    ", countryId=" + countryId +
                    ", cityId=" + cityId +
                    ", cityName=" + cityName +
                    ", from=" + from +
                    ", until=" + until +
                    ", position='" + position + '\'' +
                    '}';
        }
    }

    /**
     * Describes city.
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
     * Describes user's phone numbers.
     */
    public static class Contacts {
        /**
         * User's mobile phone number.
         */
        @SerializedName("mobile_phone")
        private String mobilePhone;

        /**
         * User's additional phone number.
         */
        @SerializedName("home_phone")
        private String homePhone;

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getHomePhone() {
            return homePhone;
        }

        public void setHomePhone(String homePhone) {
            this.homePhone = homePhone;
        }

        @Override
        public String toString() {
            return "Contacts{" +
                    "mobilePhone='" + mobilePhone + '\'' +
                    ", homePhone='" + homePhone + '\'' +
                    '}';
        }
    }

    /**
     * Describes user's counters.
     */
    public static class Counters {
        /**
         * Number of photo albums.
         */
        @SerializedName("albums")
        private Integer albums;

        /**
         * Number of videos.
         */
        @SerializedName("videos")
        private Integer videos;

        /**
         * Number of audios.
         */
        @SerializedName("audios")
        private Integer audios;

        /**
         * Number of photos.
         */
        @SerializedName("photos")
        private Integer photos;

        /**
         * Number of notes.
         */
        @SerializedName("notes")
        private Integer notes;

        /**
         * Number of friends.
         */
        @SerializedName("friends")
        private Integer friends;

        /**
         * Number of communities.
         */
        @SerializedName("groups")
        private Integer groups;

        /**
         * Number of online friends.
         */
        @SerializedName("online_friends")
        private Integer onlineFriends;

        /**
         * Number of mutual friends.
         */
        @SerializedName("mutual_friends")
        private Integer mutualFriends;

        /**
         * Number of videos the user is tagged on.
         */
        @SerializedName("user_videos")
        private Integer userVideos;

        /**
         * Number of followers.
         */
        @SerializedName("followers")
        private Integer followers;

        /**
         * Number of subscriptions.
         */
        @SerializedName("pages")
        private Integer pages;

        public Integer getAlbums() {
            return albums;
        }

        public void setAlbums(Integer albums) {
            this.albums = albums;
        }

        public Integer getVideos() {
            return videos;
        }

        public void setVideos(Integer videos) {
            this.videos = videos;
        }

        public Integer getAudios() {
            return audios;
        }

        public void setAudios(Integer audios) {
            this.audios = audios;
        }

        public Integer getPhotos() {
            return photos;
        }

        public void setPhotos(Integer photos) {
            this.photos = photos;
        }

        public Integer getNotes() {
            return notes;
        }

        public void setNotes(Integer notes) {
            this.notes = notes;
        }

        public Integer getFriends() {
            return friends;
        }

        public void setFriends(Integer friends) {
            this.friends = friends;
        }

        public Integer getGroups() {
            return groups;
        }

        public void setGroups(Integer groups) {
            this.groups = groups;
        }

        public Integer getOnlineFriends() {
            return onlineFriends;
        }

        public void setOnlineFriends(Integer onlineFriends) {
            this.onlineFriends = onlineFriends;
        }

        public Integer getMutualFriends() {
            return mutualFriends;
        }

        public void setMutualFriends(Integer mutualFriends) {
            this.mutualFriends = mutualFriends;
        }

        public Integer getUserVideos() {
            return userVideos;
        }

        public void setUserVideos(Integer userVideos) {
            this.userVideos = userVideos;
        }

        public Integer getFollowers() {
            return followers;
        }

        public void setFollowers(Integer followers) {
            this.followers = followers;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        @Override
        public String toString() {
            return "Counters{" +
                    "albums=" + albums +
                    ", videos=" + videos +
                    ", audios=" + audios +
                    ", photos=" + photos +
                    ", notes=" + notes +
                    ", friends=" + friends +
                    ", groups=" + groups +
                    ", onlineFriends=" + onlineFriends +
                    ", mutualFriends=" + mutualFriends +
                    ", userVideos=" + userVideos +
                    ", followers=" + followers +
                    ", pages=" + pages +
                    '}';
        }
    }

    /**
     * Describes higher education institution.
     */
    public static class Education {
        /**
         * University ID.
         */
        @SerializedName("university")
        private Integer university;

        /**
         * University name.
         */
        @SerializedName("university_name")
        private String universityName;

        /**
         * Faculty ID.
         */
        @SerializedName("faculty")
        private Integer faculty;

        /**
         * Faculty name.
         */
        @SerializedName("faculty_name")
        private String facultyName;

        /**
         * Graduation year.
         */
        @SerializedName("graduation")
        private Integer graduation;

        public Integer getUniversity() {
            return university;
        }

        public void setUniversity(Integer university) {
            this.university = university;
        }

        public String getUniversityName() {
            return universityName;
        }

        public void setUniversityName(String universityName) {
            this.universityName = universityName;
        }

        public Integer getFaculty() {
            return faculty;
        }

        public void setFaculty(Integer faculty) {
            this.faculty = faculty;
        }

        public String getFacultyName() {
            return facultyName;
        }

        public void setFacultyName(String facultyName) {
            this.facultyName = facultyName;
        }

        public Integer getGraduation() {
            return graduation;
        }

        public void setGraduation(Integer graduation) {
            this.graduation = graduation;
        }

        @Override
        public String toString() {
            return "Education{" +
                    "university=" + university +
                    ", universityName='" + universityName + '\'' +
                    ", faculty=" + faculty +
                    ", facultyName='" + facultyName + '\'' +
                    ", graduation=" + graduation +
                    '}';
        }
    }

    /**
     * Describes last_seen object.
     */
    public static class LastSeen {
        /**
         * Last visit date (in Unixtime).
         */
        @SerializedName("time")
        private Integer time;

        /**
         * Type of the platform that used for the last authorization.
         */
        @SerializedName("platform")
        private Integer platform;

        public Integer getTime() {
            return time;
        }

        public void setTime(Integer time) {
            this.time = time;
        }

        public Integer getPlatform() {
            return platform;
        }

        public void setPlatform(Integer platform) {
            this.platform = platform;
        }

        @Override
        public String toString() {
            return "LastSeen{" +
                    "time=" + time +
                    ", platform=" + platform +
                    '}';
        }
    }

    /**
     * Describes military service.
     */
    public static class Military {
        /**
         * Unit number.
         */
        @SerializedName("unit")
        private String unit;

        /**
         * Unit ID.
         */
        @SerializedName("unit_id")
        private Integer unitId;

        /**
         * Country ID.
         */
        @SerializedName("country_id")
        private Integer countyId;

        /**
         * Service starting year.
         */
        @SerializedName("from")
        private Integer from;

        /**
         * Service ending year.
         */
        @SerializedName("until")
        private Integer until;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public Integer getUnitId() {
            return unitId;
        }

        public void setUnitId(Integer unitId) {
            this.unitId = unitId;
        }

        public Integer getCountyId() {
            return countyId;
        }

        public void setCountyId(Integer countyId) {
            this.countyId = countyId;
        }

        public Integer getFrom() {
            return from;
        }

        public void setFrom(Integer from) {
            this.from = from;
        }

        public Integer getUntil() {
            return until;
        }

        public void setUntil(Integer until) {
            this.until = until;
        }

        @Override
        public String toString() {
            return "Military{" +
                    "unit='" + unit + '\'' +
                    ", unitId=" + unitId +
                    ", countyId=" + countyId +
                    ", from=" + from +
                    ", until=" + until +
                    '}';
        }
    }

    /**
     * Describes occupation.
     */
    public static class Occupation {
        /**
         * Possible values: work, school, university.
         */
        @SerializedName("type")
        private String type;

        /**
         * ID of school, university, company group.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * Name of school, university or work place.
         */
        @SerializedName("name")
        private String name;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        @Override
        public String toString() {
            return "Occupation{" +
                    "type='" + type + '\'' +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * Describes "Personal views" section.
     */
    public static class Personal {
        /**
         * Political views.
         */
        @SerializedName("political")
        private Integer political;

        /**
         * Languages.
         */
        @SerializedName("langs")
        private List<String> langs;

        /**
         * World view.
         */
        @SerializedName("religion")
        private String religion;

        /**
         * Inspired by.
         */
        @SerializedName("inspired_by")
        private String inspired_by;

        /**
         * Improtant in others.
         */
        @SerializedName("people_main")
        private Integer people_main;

        /**
         * Personal priority.
         */
        @SerializedName("life_main")
        private Integer life_main;

        /**
         * Views on smoking.
         */
        @SerializedName("smoking")
        private Integer smoking;

        /**
         * Views on alcohol.
         */
        @SerializedName("alcohol")
        private Integer alcohol;

        public Integer getPolitical() {
            return political;
        }

        public void setPolitical(Integer political) {
            this.political = political;
        }

        public List<String> getLangs() {
            return langs;
        }

        public void setLangs(List<String> langs) {
            this.langs = langs;
        }

        public String getReligion() {
            return religion;
        }

        public void setReligion(String religion) {
            this.religion = religion;
        }

        public String getInspired_by() {
            return inspired_by;
        }

        public void setInspired_by(String inspired_by) {
            this.inspired_by = inspired_by;
        }

        public Integer getPeople_main() {
            return people_main;
        }

        public void setPeople_main(Integer people_main) {
            this.people_main = people_main;
        }

        public Integer getLife_main() {
            return life_main;
        }

        public void setLife_main(Integer life_main) {
            this.life_main = life_main;
        }

        public Integer getSmoking() {
            return smoking;
        }

        public void setSmoking(Integer smoking) {
            this.smoking = smoking;
        }

        public Integer getAlcohol() {
            return alcohol;
        }

        public void setAlcohol(Integer alcohol) {
            this.alcohol = alcohol;
        }

        @Override
        public String toString() {
            return "Personal{" +
                    "political=" + political +
                    ", langs=" + langs +
                    ", religion='" + religion + '\'' +
                    ", inspired_by='" + inspired_by + '\'' +
                    ", people_main=" + people_main +
                    ", life_main=" + life_main +
                    ", smoking=" + smoking +
                    ", alcohol=" + alcohol +
                    '}';
        }
    }

    /**
     * Describes relative.
     */
    public static class Relative {
        /**
         * Relative id.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * Relative name.
         */
        @SerializedName("name")
        private String name;

        /**
         * Relationship type.
         */
        @SerializedName("type")
        private String type;

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Relative{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    /**
     * Describes school.
     */
    public static class School {
        /**
         * School ID.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * ID of the country the school is located in.
         */
        @SerializedName("country")
        private Integer country;

        /**
         * ID of the city the school is located in
         */
        @SerializedName("city")
        private Integer city;

        /**
         * School name.
         */
        @SerializedName("name")
        private String name;

        /**
         * Year the user started to study.
         */
        @SerializedName("year_from")
        private Integer yearFrom;

        /**
         * Year the user finished to study.
         */
        @SerializedName("year_to")
        private Integer yearTo;

        /**
         * Graduation year.
         */
        @SerializedName("year_graduated")
        private Integer yearGraduated;

        /**
         * School class letter.
         */
        @SerializedName("class")
        private String className;

        /**
         * Speciality.
         */
        @SerializedName("speciality")
        private String speciality;

        /**
         * Type ID.
         */
        @SerializedName("type")
        private Integer type;

        /**
         * Type name.
         */
        @SerializedName("type_str")
        private String type_str;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getYearFrom() {
            return yearFrom;
        }

        public void setYearFrom(Integer yearFrom) {
            this.yearFrom = yearFrom;
        }

        public Integer getYearTo() {
            return yearTo;
        }

        public void setYearTo(Integer yearTo) {
            this.yearTo = yearTo;
        }

        public Integer getYearGraduated() {
            return yearGraduated;
        }

        public void setYearGraduated(Integer yearGraduated) {
            this.yearGraduated = yearGraduated;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getType_str() {
            return type_str;
        }

        public void setType_str(String type_str) {
            this.type_str = type_str;
        }

        @Override
        public String toString() {
            return "School{" +
                    "id=" + id +
                    ", country=" + country +
                    ", city=" + city +
                    ", name='" + name + '\'' +
                    ", yearFrom=" + yearFrom +
                    ", yearTo=" + yearTo +
                    ", yearGraduated=" + yearGraduated +
                    ", className='" + className + '\'' +
                    ", speciality='" + speciality + '\'' +
                    ", type=" + type +
                    ", type_str='" + type_str + '\'' +
                    '}';
        }
    }

    /**
     * Describes higher education institution.
     */
    public static class University {
        /**
         * University ID.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * ID of the country the university is located in.
         */
        @SerializedName("country")
        private Integer country;

        /**
         * ID of the city the university is located in.
         */
        @SerializedName("city")
        private Integer city;

        /**
         * University name.
         */
        @SerializedName("name")
        private String name;

        /**
         * Faculty ID.
         */
        @SerializedName("faculty")
        private Integer faculty;

        /**
         * Faculty name.
         */
        @SerializedName("faculty_name")
        private String faculty_name;

        /**
         * University chair ID.
         */
        @SerializedName("chair")
        private String chair;

        /**
         * Chair name.
         */
        @SerializedName("chair_name")
        private String chair_name;

        /**
         * Graduation year.
         */
        @SerializedName("graduation")
        private Integer graduation;

        /**
         * Eucation form.
         */
        @SerializedName("education_form")
        private String education_form;

        /**
         * Status.
         */
        @SerializedName("education_status")
        private String education_status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getFaculty() {
            return faculty;
        }

        public void setFaculty(Integer faculty) {
            this.faculty = faculty;
        }

        public String getFaculty_name() {
            return faculty_name;
        }

        public void setFaculty_name(String faculty_name) {
            this.faculty_name = faculty_name;
        }

        public String getChair() {
            return chair;
        }

        public void setChair(String chair) {
            this.chair = chair;
        }

        public String getChair_name() {
            return chair_name;
        }

        public void setChair_name(String chair_name) {
            this.chair_name = chair_name;
        }

        public Integer getGraduation() {
            return graduation;
        }

        public void setGraduation(Integer graduation) {
            this.graduation = graduation;
        }

        public String getEducation_form() {
            return education_form;
        }

        public void setEducation_form(String education_form) {
            this.education_form = education_form;
        }

        public String getEducation_status() {
            return education_status;
        }

        public void setEducation_status(String education_status) {
            this.education_status = education_status;
        }

        @Override
        public String toString() {
            return "University{" +
                    "id=" + id +
                    ", country=" + country +
                    ", city=" + city +
                    ", name='" + name + '\'' +
                    ", faculty=" + faculty +
                    ", faculty_name='" + faculty_name + '\'' +
                    ", chair='" + chair + '\'' +
                    ", chair_name='" + chair_name + '\'' +
                    ", graduation=" + graduation +
                    ", education_form='" + education_form + '\'' +
                    ", education_status='" + education_status + '\'' +
                    '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(String deactivated) {
        this.deactivated = deactivated;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getCanAccessClosed() {
        return canAccessClosed;
    }

    public void setCanAccessClosed(Boolean canAccessClosed) {
        this.canAccessClosed = canAccessClosed;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public Boolean getBlacklistedByMe() {
        return blacklistedByMe;
    }

    public void setBlacklistedByMe(Boolean blacklistedByMe) {
        this.blacklistedByMe = blacklistedByMe;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
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

    public Boolean getCanSeeAudio() {
        return canSeeAudio;
    }

    public void setCanSeeAudio(Boolean canSeeAudio) {
        this.canSeeAudio = canSeeAudio;
    }

    public Boolean getCanSendFriendRequest() {
        return canSendFriendRequest;
    }

    public void setCanSendFriendRequest(Boolean canSendFriendRequest) {
        this.canSendFriendRequest = canSendFriendRequest;
    }

    public Boolean getCanWritePrivateMessage() {
        return canWritePrivateMessage;
    }

    public void setCanWritePrivateMessage(Boolean canWritePrivateMessage) {
        this.canWritePrivateMessage = canWritePrivateMessage;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Military getMilitary() {
        return military;
    }

    public void setMilitary(Military military) {
        this.military = military;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCommonCount() {
        return commonCount;
    }

    public void setCommonCount(Integer commonCount) {
        this.commonCount = commonCount;
    }

    public Map<String, String> getConnections() {
        return connections;
    }

    public void setConnections(Map<String, String> connections) {
        this.connections = connections;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
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

    public CropPhoto getCropPhoto() {
        return cropPhoto;
    }

    public void setCropPhoto(CropPhoto cropPhoto) {
        this.cropPhoto = cropPhoto;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getExports() {
        return exports;
    }

    public void setExports(String exports) {
        this.exports = exports;
    }

    public String getFirstNameNom() {
        return firstNameNom;
    }

    public void setFirstNameNom(String firstNameNom) {
        this.firstNameNom = firstNameNom;
    }

    public String getFirstNameGen() {
        return firstNameGen;
    }

    public void setFirstNameGen(String firstNameGen) {
        this.firstNameGen = firstNameGen;
    }

    public String getFirstNameDat() {
        return firstNameDat;
    }

    public void setFirstNameDat(String firstNameDat) {
        this.firstNameDat = firstNameDat;
    }

    public String getFirstNameAcc() {
        return firstNameAcc;
    }

    public void setFirstNameAcc(String firstNameAcc) {
        this.firstNameAcc = firstNameAcc;
    }

    public String getFirstNameIns() {
        return firstNameIns;
    }

    public void setFirstNameIns(String firstNameIns) {
        this.firstNameIns = firstNameIns;
    }

    public String getFirstNameAbl() {
        return firstNameAbl;
    }

    public void setFirstNameAbl(String firstNameAbl) {
        this.firstNameAbl = firstNameAbl;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public Boolean getHasMobile() {
        return hasMobile;
    }

    public void setHasMobile(Boolean hasMobile) {
        this.hasMobile = hasMobile;
    }

    public Boolean getHasPhoto() {
        return hasPhoto;
    }

    public void setHasPhoto(Boolean hasPhoto) {
        this.hasPhoto = hasPhoto;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getFriend() {
        return friend;
    }

    public void setFriend(Boolean friend) {
        this.friend = friend;
    }

    public Boolean getHiddenFromFeed() {
        return hiddenFromFeed;
    }

    public void setHiddenFromFeed(Boolean hiddenFromFeed) {
        this.hiddenFromFeed = hiddenFromFeed;
    }

    public String getLastNameNom() {
        return lastNameNom;
    }

    public void setLastNameNom(String lastNameNom) {
        this.lastNameNom = lastNameNom;
    }

    public String getLastNameGen() {
        return lastNameGen;
    }

    public void setLastNameGen(String lastNameGen) {
        this.lastNameGen = lastNameGen;
    }

    public String getLastNameDat() {
        return lastNameDat;
    }

    public void setLastNameDat(String lastNameDat) {
        this.lastNameDat = lastNameDat;
    }

    public String getLastNameAcc() {
        return lastNameAcc;
    }

    public void setLastNameAcc(String lastNameAcc) {
        this.lastNameAcc = lastNameAcc;
    }

    public String getLastNameIns() {
        return lastNameIns;
    }

    public void setLastNameIns(String lastNameIns) {
        this.lastNameIns = lastNameIns;
    }

    public String getLastNameAbl() {
        return lastNameAbl;
    }

    public void setLastNameAbl(String lastNameAbl) {
        this.lastNameAbl = lastNameAbl;
    }

    public LastSeen getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(LastSeen lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getLists() {
        return lists;
    }

    public void setLists(String lists) {
        this.lists = lists;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getPhoto_50() {
        return photo_50;
    }

    public void setPhoto_50(String photo_50) {
        this.photo_50 = photo_50;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public void setPhoto_100(String photo_100) {
        this.photo_100 = photo_100;
    }

    public String getPhoto_200_orig() {
        return photo_200_orig;
    }

    public void setPhoto_200_orig(String photo_200_orig) {
        this.photo_200_orig = photo_200_orig;
    }

    public String getPhoto_200() {
        return photo_200;
    }

    public void setPhoto_200(String photo_200) {
        this.photo_200 = photo_200;
    }

    public String getPhoto_400_orig() {
        return photo_400_orig;
    }

    public void setPhoto_400_orig(String photo_400_orig) {
        this.photo_400_orig = photo_400_orig;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
    }

    public String getPhoto_max() {
        return photo_max;
    }

    public void setPhoto_max(String photo_max) {
        this.photo_max = photo_max;
    }

    public String getPhoto_max_orig() {
        return photo_max_orig;
    }

    public void setPhoto_max_orig(String photo_max_orig) {
        this.photo_max_orig = photo_max_orig;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public List<Relative> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Relative> relatives) {
        this.relatives = relatives;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Boolean getTrending() {
        return trending;
    }

    public void setTrending(Boolean trending) {
        this.trending = trending;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getWall_default() {
        return wall_default;
    }

    public void setWall_default(String wall_default) {
        this.wall_default = wall_default;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deactivated='" + deactivated + '\'' +
                ", closed=" + closed +
                ", canAccessClosed=" + canAccessClosed +
                ", about='" + about + '\'' +
                ", activities='" + activities + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", blacklisted=" + blacklisted +
                ", blacklistedByMe=" + blacklistedByMe +
                ", books='" + books + '\'' +
                ", canPost=" + canPost +
                ", canSeeAllPosts=" + canSeeAllPosts +
                ", canSeeAudio=" + canSeeAudio +
                ", canSendFriendRequest=" + canSendFriendRequest +
                ", canWritePrivateMessage=" + canWritePrivateMessage +
                ", career=" + career +
                ", military=" + military +
                ", movies='" + movies + '\'' +
                ", music='" + music + '\'' +
                ", nickname='" + nickname + '\'' +
                ", city='" + city + '\'' +
                ", commonCount=" + commonCount +
                ", connections=" + connections +
                ", contacts=" + contacts +
                ", counters=" + counters +
                ", country=" + country +
                ", cropPhoto=" + cropPhoto +
                ", domain='" + domain + '\'' +
                ", education=" + education +
                ", exports='" + exports + '\'' +
                ", firstNameNom='" + firstNameNom + '\'' +
                ", firstNameGen='" + firstNameGen + '\'' +
                ", firstNameDat='" + firstNameDat + '\'' +
                ", firstNameAcc='" + firstNameAcc + '\'' +
                ", firstNameIns='" + firstNameIns + '\'' +
                ", firstNameAbl='" + firstNameAbl + '\'' +
                ", followersCount=" + followersCount +
                ", friendStatus=" + friendStatus +
                ", games='" + games + '\'' +
                ", hasMobile=" + hasMobile +
                ", hasPhoto=" + hasPhoto +
                ", homeTown='" + homeTown + '\'' +
                ", interests='" + interests + '\'' +
                ", favorite=" + favorite +
                ", friend=" + friend +
                ", hiddenFromFeed=" + hiddenFromFeed +
                ", lastNameNom='" + lastNameNom + '\'' +
                ", lastNameGen='" + lastNameGen + '\'' +
                ", lastNameDat='" + lastNameDat + '\'' +
                ", lastNameAcc='" + lastNameAcc + '\'' +
                ", lastNameIns='" + lastNameIns + '\'' +
                ", lastNameAbl='" + lastNameAbl + '\'' +
                ", lastSeen=" + lastSeen +
                ", lists='" + lists + '\'' +
                ", maidenName='" + maidenName + '\'' +
                ", occupation=" + occupation +
                ", online=" + online +
                ", personal=" + personal +
                ", photo_50='" + photo_50 + '\'' +
                ", photo_100='" + photo_100 + '\'' +
                ", photo_200_orig='" + photo_200_orig + '\'' +
                ", photo_200='" + photo_200 + '\'' +
                ", photo_400_orig='" + photo_400_orig + '\'' +
                ", photo_id='" + photo_id + '\'' +
                ", photo_max='" + photo_max + '\'' +
                ", photo_max_orig='" + photo_max_orig + '\'' +
                ", quotes='" + quotes + '\'' +
                ", relatives=" + relatives +
                ", relation=" + relation +
                ", schools=" + schools +
                ", screen_name='" + screen_name + '\'' +
                ", sex=" + sex +
                ", site='" + site + '\'' +
                ", status='" + status + '\'' +
                ", timezone=" + timezone +
                ", trending=" + trending +
                ", tv='" + tv + '\'' +
                ", universities=" + universities +
                ", verified=" + verified +
                ", wall_default='" + wall_default + '\'' +
                '}';
    }
}
