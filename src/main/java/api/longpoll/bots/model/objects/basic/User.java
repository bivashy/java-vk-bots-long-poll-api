package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.objects.additional.Country;
import api.longpoll.bots.model.objects.additional.CropPhoto;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class User {
    @SerializedName("id")
    private Integer id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("deactivated")
    private String deactivated;
    @SerializedName("is_closed")
    private Boolean closed;
    @SerializedName("can_access_closed")
    private Boolean canAccessClosed;
    @SerializedName("about")
    private String about;
    @SerializedName("activities")
    private String activities;
    @SerializedName("bdate")
    private String birthDate;
    @SerializedName("blacklisted")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean blacklisted;
    @SerializedName("blacklisted_by_me")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean blacklistedByMe;
    @SerializedName("books")
    private String books;
    @SerializedName("can_post")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean canPost;
    @SerializedName("can_see_all_posts")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean canSeeAllPosts;
    @SerializedName("can_see_audio")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean canSeeAudio;
    @SerializedName("can_send_friend_request")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean canSendFriendRequest;
    @SerializedName("can_write_private_message")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean canWritePrivateMessage;
    @SerializedName("career")
    private Career career;
    @SerializedName("military")
    private Military military;
    @SerializedName("movies")
    private String movies;
    @SerializedName("music")
    private String music;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("city")
    private String city;
    @SerializedName("common_count")
    private Integer commonCount;
    @SerializedName("connections")
    private Map<String, String> connections; //todo check https://vk.com/support?act=show&id=37960706
    @SerializedName("contacts")
    private Contacts contacts;
    @SerializedName("counters")
    private Counters counters;
    @SerializedName("country")
    private Country country;
    @SerializedName("crop_photo")
    private CropPhoto cropPhoto;
    @SerializedName("domain")
    private String domain;
    @SerializedName("education")
    private Education education;
    @SerializedName("exports")
    private String exports;
    @SerializedName("first_name_nom")
    private String firstNameNom;
    @SerializedName("first_name_gen")
    private String firstNameGen;
    @SerializedName("first_name_dat")
    private String firstNameDat;
    @SerializedName("first_name_acc")
    private String firstNameAcc;
    @SerializedName("first_name_ins")
    private String firstNameIns;
    @SerializedName("first_name_abl")
    private String firstNameAbl;
    @SerializedName("followers_count")
    private Integer followersCount;
    @SerializedName("friend_status")
    private Integer friendStatus;
    @SerializedName("games")
    private String games;
    @SerializedName("has_mobile")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean hasMobile;
    @SerializedName("has_photo")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean hasPhoto;
    @SerializedName("home_town")
    private String homeTown;
    @SerializedName("interests")
    private String interests;
    @SerializedName("is_favorite")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean favorite;
    @SerializedName("is_friend")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean friend;
    @SerializedName("is_hidden_from_feed")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean hiddenFromFeed;
    @SerializedName("last_name_nom")
    private String lastNameNom;
    @SerializedName("last_name_gen")
    private String lastNameGen;
    @SerializedName("last_name_dat")
    private String lastNameDat;
    @SerializedName("last_name_acc")
    private String lastNameAcc;
    @SerializedName("last_name_ins")
    private String lastNameIns;
    @SerializedName("last_name_abl")
    private String lastNameAbl;
    @SerializedName("last_seen")
    private LastSeen lastSeen;
    @SerializedName("lists")
    private String lists;
    @SerializedName("maiden_name")
    private String maidenName;
    @SerializedName("occupation")
    private Occupation occupation;
    @SerializedName("online")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean online;
    @SerializedName("personal")
    private Personal personal;
    @SerializedName("photo_50")
    private String photo_50;
    @SerializedName("photo_100")
    private String photo_100;
    @SerializedName("photo_200_orig")
    private String photo_200_orig;
    @SerializedName("photo_200")
    private String photo_200;
    @SerializedName("photo_400_orig")
    private String photo_400_orig;
    @SerializedName("photo_id")
    private String photo_id;
    @SerializedName("photo_max")
    private String photo_max;
    @SerializedName("photo_max_orig")
    private String photo_max_orig;
    @SerializedName("quotes")
    private String quotes;
    @SerializedName("relatives")
    private List<Relative> relatives;
    @SerializedName("relation")
    private Integer relation;
    @SerializedName("schools")
    private List<School> schools;
    @SerializedName("screen_name")
    private String screen_name;
    @SerializedName("sex")
    private Integer sex;
    @SerializedName("site")
    private String site;
    @SerializedName("status")
    private String status;
    @SerializedName("timezone")
    private Integer timezone;
    @SerializedName("trending")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean trending;
    @SerializedName("tv")
    private String tv;
    @SerializedName("universities")
    private List<University> universities;
    @SerializedName("verified")
    @JsonAdapter(BoolIntAdapter.class)
    private Boolean verified;
    @SerializedName("wall_default")
    private String wall_default;

    public static class Career {
        @SerializedName("group_id")
        private Integer groupId;
        @SerializedName("company")
        private String company;
        @SerializedName("country_id")
        private Integer countryId;
        @SerializedName("city_id")
        private Integer cityId;
        @SerializedName("city_name")
        private Integer cityName;
        @SerializedName("from")
        private Integer from;
        @SerializedName("until")
        private Integer until;
        @SerializedName("position")
        private String position;

        public Career() {
        }

        public Integer getGroupId() {
            return groupId;
        }

        public Career setGroupId(Integer groupId) {
            this.groupId = groupId;
            return this;
        }

        public String getCompany() {
            return company;
        }

        public Career setCompany(String company) {
            this.company = company;
            return this;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public Career setCountryId(Integer countryId) {
            this.countryId = countryId;
            return this;
        }

        public Integer getCityId() {
            return cityId;
        }

        public Career setCityId(Integer cityId) {
            this.cityId = cityId;
            return this;
        }

        public Integer getCityName() {
            return cityName;
        }

        public Career setCityName(Integer cityName) {
            this.cityName = cityName;
            return this;
        }

        public Integer getFrom() {
            return from;
        }

        public Career setFrom(Integer from) {
            this.from = from;
            return this;
        }

        public Integer getUntil() {
            return until;
        }

        public Career setUntil(Integer until) {
            this.until = until;
            return this;
        }

        public String getPosition() {
            return position;
        }

        public Career setPosition(String position) {
            this.position = position;
            return this;
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

    public static class Contacts {
        @SerializedName("mobile_phone")
        private String mobilePhone;
        @SerializedName("home_phone")
        private String homePhone;

        public String getMobilePhone() {
            return mobilePhone;
        }

        public Contacts setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public String getHomePhone() {
            return homePhone;
        }

        public Contacts setHomePhone(String homePhone) {
            this.homePhone = homePhone;
            return this;
        }
    }

    public static  class Counters {
        @SerializedName("albums")
        private Integer albums;
        @SerializedName("videos")
        private Integer videos;
        @SerializedName("audios")
        private Integer audios;
        @SerializedName("photos")
        private Integer photos;
        @SerializedName("notes")
        private Integer notes;
        @SerializedName("friends")
        private Integer friends;
        @SerializedName("groups")
        private Integer groups;
        @SerializedName("online_friends")
        private Integer onlineFriends;
        @SerializedName("mutual_friends")
        private Integer mutualFriends;
        @SerializedName("user_videos")
        private Integer userVideos;
        @SerializedName("followers")
        private Integer followers;
        @SerializedName("pages")
        private Integer pages;

        public Integer getAlbums() {
            return albums;
        }

        public Counters setAlbums(Integer albums) {
            this.albums = albums;
            return this;
        }

        public Integer getVideos() {
            return videos;
        }

        public Counters setVideos(Integer videos) {
            this.videos = videos;
            return this;
        }

        public Integer getAudios() {
            return audios;
        }

        public Counters setAudios(Integer audios) {
            this.audios = audios;
            return this;
        }

        public Integer getPhotos() {
            return photos;
        }

        public Counters setPhotos(Integer photos) {
            this.photos = photos;
            return this;
        }

        public Integer getNotes() {
            return notes;
        }

        public Counters setNotes(Integer notes) {
            this.notes = notes;
            return this;
        }

        public Integer getFriends() {
            return friends;
        }

        public Counters setFriends(Integer friends) {
            this.friends = friends;
            return this;
        }

        public Integer getGroups() {
            return groups;
        }

        public Counters setGroups(Integer groups) {
            this.groups = groups;
            return this;
        }

        public Integer getOnlineFriends() {
            return onlineFriends;
        }

        public Counters setOnlineFriends(Integer onlineFriends) {
            this.onlineFriends = onlineFriends;
            return this;
        }

        public Integer getMutualFriends() {
            return mutualFriends;
        }

        public Counters setMutualFriends(Integer mutualFriends) {
            this.mutualFriends = mutualFriends;
            return this;
        }

        public Integer getUserVideos() {
            return userVideos;
        }

        public Counters setUserVideos(Integer userVideos) {
            this.userVideos = userVideos;
            return this;
        }

        public Integer getFollowers() {
            return followers;
        }

        public Counters setFollowers(Integer followers) {
            this.followers = followers;
            return this;
        }

        public Integer getPages() {
            return pages;
        }

        public Counters setPages(Integer pages) {
            this.pages = pages;
            return this;
        }
    }

    public static class Education {
        @SerializedName("university")
        private Integer university;
        @SerializedName("university_name")
        private String universityName;
        @SerializedName("faculty")
        private Integer faculty;
        @SerializedName("faculty_name")
        private String facultyName;
        @SerializedName("graduation")
        private Integer graduation;

        public Integer getUniversity() {
            return university;
        }

        public Education setUniversity(Integer university) {
            this.university = university;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public Education setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public Integer getFaculty() {
            return faculty;
        }

        public Education setFaculty(Integer faculty) {
            this.faculty = faculty;
            return this;
        }

        public String getFacultyName() {
            return facultyName;
        }

        public Education setFacultyName(String facultyName) {
            this.facultyName = facultyName;
            return this;
        }

        public Integer getGraduation() {
            return graduation;
        }

        public Education setGraduation(Integer graduation) {
            this.graduation = graduation;
            return this;
        }
    }

    public static class LastSeen {
        @SerializedName("time")
        private Integer time;
        @SerializedName("platform")
        private Integer platform;

        public Integer getTime() {
            return time;
        }

        public LastSeen setTime(Integer time) {
            this.time = time;
            return this;
        }

        public Integer getPlatform() {
            return platform;
        }

        public LastSeen setPlatform(Integer platform) {
            this.platform = platform;
            return this;
        }
    }

    public static class Military {
        @SerializedName("unit")
        private String unit;
        @SerializedName("unit_id")
        private Integer unitId;
        @SerializedName("country_id")
        private Integer countyId;
        @SerializedName("from")
        private Integer from;
        @SerializedName("until")
        private Integer until;

        public String getUnit() {
            return unit;
        }

        public Military setUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public Integer getUnitId() {
            return unitId;
        }

        public Military setUnitId(Integer unitId) {
            this.unitId = unitId;
            return this;
        }

        public Integer getCountyId() {
            return countyId;
        }

        public Military setCountyId(Integer countyId) {
            this.countyId = countyId;
            return this;
        }

        public Integer getFrom() {
            return from;
        }

        public Military setFrom(Integer from) {
            this.from = from;
            return this;
        }

        public Integer getUntil() {
            return until;
        }

        public Military setUntil(Integer until) {
            this.until = until;
            return this;
        }
    }

    public static class Occupation {
        @SerializedName("type")
        private String type;
        @SerializedName("id")
        private Integer id;
        @SerializedName("name")
        private String name;

        public String getType() {
            return type;
        }

        public Occupation setType(String type) {
            this.type = type;
            return this;
        }

        public Integer getId() {
            return id;
        }

        public Occupation setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Occupation setName(String name) {
            this.name = name;
            return this;
        }
    }

    public static class Personal {
        @SerializedName("political")
        private Integer political;
        @SerializedName("langs")
        private List<String> langs; //todo https://vk.com/support?act=show&id=37960706
        @SerializedName("religion")
        private String religion;
        @SerializedName("inspired_by")
        private String inspired_by;
        @SerializedName("people_main")
        private Integer people_main;
        @SerializedName("life_main")
        private Integer life_main;
        @SerializedName("smoking")
        private Integer smoking;
        @SerializedName("alcohol")
        private Integer alcohol;

        public Integer getPolitical() {
            return political;
        }

        public Personal setPolitical(Integer political) {
            this.political = political;
            return this;
        }

        public List<String> getLangs() {
            return langs;
        }

        public Personal setLangs(List<String> langs) {
            this.langs = langs;
            return this;
        }

        public String getReligion() {
            return religion;
        }

        public Personal setReligion(String religion) {
            this.religion = religion;
            return this;
        }

        public String getInspired_by() {
            return inspired_by;
        }

        public Personal setInspired_by(String inspired_by) {
            this.inspired_by = inspired_by;
            return this;
        }

        public Integer getPeople_main() {
            return people_main;
        }

        public Personal setPeople_main(Integer people_main) {
            this.people_main = people_main;
            return this;
        }

        public Integer getLife_main() {
            return life_main;
        }

        public Personal setLife_main(Integer life_main) {
            this.life_main = life_main;
            return this;
        }

        public Integer getSmoking() {
            return smoking;
        }

        public Personal setSmoking(Integer smoking) {
            this.smoking = smoking;
            return this;
        }

        public Integer getAlcohol() {
            return alcohol;
        }

        public Personal setAlcohol(Integer alcohol) {
            this.alcohol = alcohol;
            return this;
        }
    }

    public static class Relative {
        @SerializedName("id")
        private Integer id;
        @SerializedName("name")
        private String name;
        @SerializedName("type")
        private String type;

        public Integer getId() {
            return id;
        }

        public Relative setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Relative setName(String name) {
            this.name = name;
            return this;
        }

        public String getType() {
            return type;
        }

        public Relative setType(String type) {
            this.type = type;
            return this;
        }
    }

    public static class School {
        @SerializedName("id")
        private Integer id;
        @SerializedName("country")
        private Integer country;
        @SerializedName("city")
        private Integer city;
        @SerializedName("name")
        private String name;
        @SerializedName("year_from")
        private Integer yearFrom;
        @SerializedName("year_to")
        private Integer yearTo;
        @SerializedName("year_graduated")
        private Integer yearGraduated;
        @SerializedName("class")
        private String className;
        @SerializedName("speciality")
        private String speciality;
        @SerializedName("type")
        private Integer type;
        @SerializedName("type_str")
        private String type_str;

        public Integer getId() {
            return id;
        }

        public School setId(Integer id) {
            this.id = id;
            return this;
        }

        public Integer getCountry() {
            return country;
        }

        public School setCountry(Integer country) {
            this.country = country;
            return this;
        }

        public Integer getCity() {
            return city;
        }

        public School setCity(Integer city) {
            this.city = city;
            return this;
        }

        public String getName() {
            return name;
        }

        public School setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getYearFrom() {
            return yearFrom;
        }

        public School setYearFrom(Integer yearFrom) {
            this.yearFrom = yearFrom;
            return this;
        }

        public Integer getYearTo() {
            return yearTo;
        }

        public School setYearTo(Integer yearTo) {
            this.yearTo = yearTo;
            return this;
        }

        public Integer getYearGraduated() {
            return yearGraduated;
        }

        public School setYearGraduated(Integer yearGraduated) {
            this.yearGraduated = yearGraduated;
            return this;
        }

        public String getClassName() {
            return className;
        }

        public School setClassName(String className) {
            this.className = className;
            return this;
        }

        public String getSpeciality() {
            return speciality;
        }

        public School setSpeciality(String speciality) {
            this.speciality = speciality;
            return this;
        }

        public Integer getType() {
            return type;
        }

        public School setType(Integer type) {
            this.type = type;
            return this;
        }

        public String getType_str() {
            return type_str;
        }

        public School setType_str(String type_str) {
            this.type_str = type_str;
            return this;
        }
    }

    public static class University {
        @SerializedName("id")
        private Integer id;
        @SerializedName("country")
        private Integer country;
        @SerializedName("city")
        private Integer city;
        @SerializedName("name")
        private String name;
        @SerializedName("faculty")
        private Integer faculty;
        @SerializedName("faculty_name")
        private String faculty_name;
        @SerializedName("chair")
        private String chair;
        @SerializedName("chair_name")
        private String chair_name;
        @SerializedName("graduation")
        private Integer graduation;
        @SerializedName("education_form")
        private String education_form;
        @SerializedName("education_status")
        private String education_status;

        public Integer getId() {
            return id;
        }

        public University setId(Integer id) {
            this.id = id;
            return this;
        }

        public Integer getCountry() {
            return country;
        }

        public University setCountry(Integer country) {
            this.country = country;
            return this;
        }

        public Integer getCity() {
            return city;
        }

        public University setCity(Integer city) {
            this.city = city;
            return this;
        }

        public String getName() {
            return name;
        }

        public University setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getFaculty() {
            return faculty;
        }

        public University setFaculty(Integer faculty) {
            this.faculty = faculty;
            return this;
        }

        public String getFaculty_name() {
            return faculty_name;
        }

        public University setFaculty_name(String faculty_name) {
            this.faculty_name = faculty_name;
            return this;
        }

        public String getChair() {
            return chair;
        }

        public University setChair(String chair) {
            this.chair = chair;
            return this;
        }

        public String getChair_name() {
            return chair_name;
        }

        public University setChair_name(String chair_name) {
            this.chair_name = chair_name;
            return this;
        }

        public Integer getGraduation() {
            return graduation;
        }

        public University setGraduation(Integer graduation) {
            this.graduation = graduation;
            return this;
        }

        public String getEducation_form() {
            return education_form;
        }

        public University setEducation_form(String education_form) {
            this.education_form = education_form;
            return this;
        }

        public String getEducation_status() {
            return education_status;
        }

        public University setEducation_status(String education_status) {
            this.education_status = education_status;
            return this;
        }
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public User setDeactivated(String deactivated) {
        this.deactivated = deactivated;
        return this;
    }

    public Boolean getClosed() {
        return closed;
    }

    public User setClosed(Boolean closed) {
        this.closed = closed;
        return this;
    }

    public Boolean getCanAccessClosed() {
        return canAccessClosed;
    }

    public User setCanAccessClosed(Boolean canAccessClosed) {
        this.canAccessClosed = canAccessClosed;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public User setAbout(String about) {
        this.about = about;
        return this;
    }

    public String getActivities() {
        return activities;
    }

    public User setActivities(String activities) {
        this.activities = activities;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public User setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Boolean getBlacklisted() {
        return blacklisted;
    }

    public User setBlacklisted(Boolean blacklisted) {
        this.blacklisted = blacklisted;
        return this;
    }

    public Boolean getBlacklistedByMe() {
        return blacklistedByMe;
    }

    public User setBlacklistedByMe(Boolean blacklistedByMe) {
        this.blacklistedByMe = blacklistedByMe;
        return this;
    }

    public String getBooks() {
        return books;
    }

    public User setBooks(String books) {
        this.books = books;
        return this;
    }

    public Boolean getCanPost() {
        return canPost;
    }

    public User setCanPost(Boolean canPost) {
        this.canPost = canPost;
        return this;
    }

    public Boolean getCanSeeAllPosts() {
        return canSeeAllPosts;
    }

    public User setCanSeeAllPosts(Boolean canSeeAllPosts) {
        this.canSeeAllPosts = canSeeAllPosts;
        return this;
    }

    public Boolean getCanSeeAudio() {
        return canSeeAudio;
    }

    public User setCanSeeAudio(Boolean canSeeAudio) {
        this.canSeeAudio = canSeeAudio;
        return this;
    }

    public Boolean getCanSendFriendRequest() {
        return canSendFriendRequest;
    }

    public User setCanSendFriendRequest(Boolean canSendFriendRequest) {
        this.canSendFriendRequest = canSendFriendRequest;
        return this;
    }

    public Boolean getCanWritePrivateMessage() {
        return canWritePrivateMessage;
    }

    public User setCanWritePrivateMessage(Boolean canWritePrivateMessage) {
        this.canWritePrivateMessage = canWritePrivateMessage;
        return this;
    }

    public Career getCareer() {
        return career;
    }

    public User setCareer(Career career) {
        this.career = career;
        return this;
    }

    public Military getMilitary() {
        return military;
    }

    public User setMilitary(Military military) {
        this.military = military;
        return this;
    }

    public String getMovies() {
        return movies;
    }

    public User setMovies(String movies) {
        this.movies = movies;
        return this;
    }

    public String getMusic() {
        return music;
    }

    public User setMusic(String music) {
        this.music = music;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public Integer getCommonCount() {
        return commonCount;
    }

    public User setCommonCount(Integer commonCount) {
        this.commonCount = commonCount;
        return this;
    }

    public Map<String, String> getConnections() {
        return connections;
    }

    public User setConnections(Map<String, String> connections) {
        this.connections = connections;
        return this;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public User setContacts(Contacts contacts) {
        this.contacts = contacts;
        return this;
    }

    public Counters getCounters() {
        return counters;
    }

    public User setCounters(Counters counters) {
        this.counters = counters;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public User setCountry(Country country) {
        this.country = country;
        return this;
    }

    public CropPhoto getCropPhoto() {
        return cropPhoto;
    }

    public User setCropPhoto(CropPhoto cropPhoto) {
        this.cropPhoto = cropPhoto;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public User setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public Education getEducation() {
        return education;
    }

    public User setEducation(Education education) {
        this.education = education;
        return this;
    }

    public String getExports() {
        return exports;
    }

    public User setExports(String exports) {
        this.exports = exports;
        return this;
    }

    public String getFirstNameNom() {
        return firstNameNom;
    }

    public User setFirstNameNom(String firstNameNom) {
        this.firstNameNom = firstNameNom;
        return this;
    }

    public String getFirstNameGen() {
        return firstNameGen;
    }

    public User setFirstNameGen(String firstNameGen) {
        this.firstNameGen = firstNameGen;
        return this;
    }

    public String getFirstNameDat() {
        return firstNameDat;
    }

    public User setFirstNameDat(String firstNameDat) {
        this.firstNameDat = firstNameDat;
        return this;
    }

    public String getFirstNameAcc() {
        return firstNameAcc;
    }

    public User setFirstNameAcc(String firstNameAcc) {
        this.firstNameAcc = firstNameAcc;
        return this;
    }

    public String getFirstNameIns() {
        return firstNameIns;
    }

    public User setFirstNameIns(String firstNameIns) {
        this.firstNameIns = firstNameIns;
        return this;
    }

    public String getFirstNameAbl() {
        return firstNameAbl;
    }

    public User setFirstNameAbl(String firstNameAbl) {
        this.firstNameAbl = firstNameAbl;
        return this;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public User setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
        return this;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public User setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
        return this;
    }

    public String getGames() {
        return games;
    }

    public User setGames(String games) {
        this.games = games;
        return this;
    }

    public Boolean getHasMobile() {
        return hasMobile;
    }

    public User setHasMobile(Boolean hasMobile) {
        this.hasMobile = hasMobile;
        return this;
    }

    public Boolean getHasPhoto() {
        return hasPhoto;
    }

    public User setHasPhoto(Boolean hasPhoto) {
        this.hasPhoto = hasPhoto;
        return this;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public User setHomeTown(String homeTown) {
        this.homeTown = homeTown;
        return this;
    }

    public String getInterests() {
        return interests;
    }

    public User setInterests(String interests) {
        this.interests = interests;
        return this;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public User setFavorite(Boolean favorite) {
        this.favorite = favorite;
        return this;
    }

    public Boolean getFriend() {
        return friend;
    }

    public User setFriend(Boolean friend) {
        this.friend = friend;
        return this;
    }

    public Boolean getHiddenFromFeed() {
        return hiddenFromFeed;
    }

    public User setHiddenFromFeed(Boolean hiddenFromFeed) {
        this.hiddenFromFeed = hiddenFromFeed;
        return this;
    }

    public String getLastNameNom() {
        return lastNameNom;
    }

    public User setLastNameNom(String lastNameNom) {
        this.lastNameNom = lastNameNom;
        return this;
    }

    public String getLastNameGen() {
        return lastNameGen;
    }

    public User setLastNameGen(String lastNameGen) {
        this.lastNameGen = lastNameGen;
        return this;
    }

    public String getLastNameDat() {
        return lastNameDat;
    }

    public User setLastNameDat(String lastNameDat) {
        this.lastNameDat = lastNameDat;
        return this;
    }

    public String getLastNameAcc() {
        return lastNameAcc;
    }

    public User setLastNameAcc(String lastNameAcc) {
        this.lastNameAcc = lastNameAcc;
        return this;
    }

    public String getLastNameIns() {
        return lastNameIns;
    }

    public User setLastNameIns(String lastNameIns) {
        this.lastNameIns = lastNameIns;
        return this;
    }

    public String getLastNameAbl() {
        return lastNameAbl;
    }

    public User setLastNameAbl(String lastNameAbl) {
        this.lastNameAbl = lastNameAbl;
        return this;
    }

    public LastSeen getLastSeen() {
        return lastSeen;
    }

    public User setLastSeen(LastSeen lastSeen) {
        this.lastSeen = lastSeen;
        return this;
    }

    public String getLists() {
        return lists;
    }

    public User setLists(String lists) {
        this.lists = lists;
        return this;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public User setMaidenName(String maidenName) {
        this.maidenName = maidenName;
        return this;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public User setOccupation(Occupation occupation) {
        this.occupation = occupation;
        return this;
    }

    public Boolean getOnline() {
        return online;
    }

    public User setOnline(Boolean online) {
        this.online = online;
        return this;
    }

    public Personal getPersonal() {
        return personal;
    }

    public User setPersonal(Personal personal) {
        this.personal = personal;
        return this;
    }

    public String getPhoto_50() {
        return photo_50;
    }

    public User setPhoto_50(String photo_50) {
        this.photo_50 = photo_50;
        return this;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public User setPhoto_100(String photo_100) {
        this.photo_100 = photo_100;
        return this;
    }

    public String getPhoto_200_orig() {
        return photo_200_orig;
    }

    public User setPhoto_200_orig(String photo_200_orig) {
        this.photo_200_orig = photo_200_orig;
        return this;
    }

    public String getPhoto_200() {
        return photo_200;
    }

    public User setPhoto_200(String photo_200) {
        this.photo_200 = photo_200;
        return this;
    }

    public String getPhoto_400_orig() {
        return photo_400_orig;
    }

    public User setPhoto_400_orig(String photo_400_orig) {
        this.photo_400_orig = photo_400_orig;
        return this;
    }

    public String getPhoto_id() {
        return photo_id;
    }

    public User setPhoto_id(String photo_id) {
        this.photo_id = photo_id;
        return this;
    }

    public String getPhoto_max() {
        return photo_max;
    }

    public User setPhoto_max(String photo_max) {
        this.photo_max = photo_max;
        return this;
    }

    public String getPhoto_max_orig() {
        return photo_max_orig;
    }

    public User setPhoto_max_orig(String photo_max_orig) {
        this.photo_max_orig = photo_max_orig;
        return this;
    }

    public String getQuotes() {
        return quotes;
    }

    public User setQuotes(String quotes) {
        this.quotes = quotes;
        return this;
    }

    public List<Relative> getRelatives() {
        return relatives;
    }

    public User setRelatives(List<Relative> relatives) {
        this.relatives = relatives;
        return this;
    }

    public Integer getRelation() {
        return relation;
    }

    public User setRelation(Integer relation) {
        this.relation = relation;
        return this;
    }

    public List<School> getSchools() {
        return schools;
    }

    public User setSchools(List<School> schools) {
        this.schools = schools;
        return this;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public User setScreen_name(String screen_name) {
        this.screen_name = screen_name;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public User setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public String getSite() {
        return site;
    }

    public User setSite(String site) {
        this.site = site;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public User setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public User setTimezone(Integer timezone) {
        this.timezone = timezone;
        return this;
    }

    public Boolean getTrending() {
        return trending;
    }

    public User setTrending(Boolean trending) {
        this.trending = trending;
        return this;
    }

    public String getTv() {
        return tv;
    }

    public User setTv(String tv) {
        this.tv = tv;
        return this;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public User setUniversities(List<University> universities) {
        this.universities = universities;
        return this;
    }

    public Boolean getVerified() {
        return verified;
    }

    public User setVerified(Boolean verified) {
        this.verified = verified;
        return this;
    }

    public String getWall_default() {
        return wall_default;
    }

    public User setWall_default(String wall_default) {
        this.wall_default = wall_default;
        return this;
    }
}
