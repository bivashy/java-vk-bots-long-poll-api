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
    private Map<String, String> connections;
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

    public static class Contacts {
        @SerializedName("mobile_phone")
        private String mobilePhone;
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
    }

    public static class LastSeen {
        @SerializedName("time")
        private Integer time;
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
}
