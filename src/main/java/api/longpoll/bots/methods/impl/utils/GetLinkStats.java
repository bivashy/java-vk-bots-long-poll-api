package api.longpoll.bots.methods.impl.utils;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Implements <b>utils.getLinkStats</b> method.
 * <p>
 * Returns stats data for shortened link.
 *
 * @see <a href="https://vk.com/dev/utils.getLinkStats">https://vk.com/dev/utils.getLinkStats</a>
 */
public class GetLinkStats extends AuthorizedVkApiMethod<GetLinkStats.Response> {
    public GetLinkStats(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("utils.getLinkStats");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetLinkStats setKey(String key) {
        return addParam("key", key);
    }

    public GetLinkStats setSource(String source) {
        return addParam("source", source);
    }

    public GetLinkStats setAccessKey(String accessKey) {
        return addParam("access_key", accessKey);
    }

    public GetLinkStats setInterval(String interval) {
        return addParam("interval", interval);
    }

    public GetLinkStats setIntervalsCount(int intervalsCount) {
        return addParam("intervals_count", intervalsCount);
    }

    public GetLinkStats setExtended(boolean extended) {
        return addParam("extended", new BoolInt(extended));
    }

    @Override
    public GetLinkStats addParam(String key, Object value) {
        return (GetLinkStats) super.addParam(key, value);
    }

    /**
     * Response to <b>utils.getLinkStats</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Key.
             */
            @SerializedName("key")
            private String key;

            /**
             * List of stats.
             */
            @SerializedName("stats")
            private List<Stat> stats;

            /**
             * Describes stat.
             */
            public static class Stat {
                /**
                 * Timestamp.
                 */
                @SerializedName("timestamp")
                private Integer timestamp;

                /**
                 * Number of views.
                 */
                @SerializedName("views")
                private Integer views;

                /**
                 * List of sex_age.
                 */
                @SerializedName("sex_age")
                private List<SexAge> sexAges;

                /**
                 * List of countries.
                 */
                @SerializedName("countries")
                private List<Country> countries;

                /**
                 * List of cities.
                 */
                @SerializedName("cities")
                private List<City> cities;

                /**
                 * Describes sex_age.
                 */
                public static class SexAge {
                    /**
                     * Ae denotation.
                     */
                    @SerializedName("age_range")
                    private String ageRange;

                    /**
                     * Views by female users.
                     */
                    @SerializedName("female")
                    private Integer female;

                    /**
                     * Views by male users.
                     */
                    @SerializedName("male")
                    private Integer male;

                    public String getAgeRange() {
                        return ageRange;
                    }

                    public void setAgeRange(String ageRange) {
                        this.ageRange = ageRange;
                    }

                    public Integer getFemale() {
                        return female;
                    }

                    public void setFemale(Integer female) {
                        this.female = female;
                    }

                    public Integer getMale() {
                        return male;
                    }

                    public void setMale(Integer male) {
                        this.male = male;
                    }

                    @Override
                    public String toString() {
                        return "SexAge{" +
                                "ageRange='" + ageRange + '\'' +
                                ", female=" + female +
                                ", male=" + male +
                                '}';
                    }
                }

                /**
                 * Describes country.
                 */
                public static class Country {
                    /**
                     * Country ID.
                     */
                    @SerializedName("country_id")
                    private Integer countryId;

                    /**
                     * Views number.
                     */
                    @SerializedName("views")
                    private Integer views;

                    public Integer getCountryId() {
                        return countryId;
                    }

                    public void setCountryId(Integer countryId) {
                        this.countryId = countryId;
                    }

                    public Integer getViews() {
                        return views;
                    }

                    public void setViews(Integer views) {
                        this.views = views;
                    }

                    @Override
                    public String toString() {
                        return "Country{" +
                                "countryId=" + countryId +
                                ", views=" + views +
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
                    @SerializedName("city_id")
                    private Integer cityId;

                    /**
                     * Views number.
                     */
                    @SerializedName("views")
                    private Integer views;

                    public Integer getCityId() {
                        return cityId;
                    }

                    public void setCityId(Integer cityId) {
                        this.cityId = cityId;
                    }

                    public Integer getViews() {
                        return views;
                    }

                    public void setViews(Integer views) {
                        this.views = views;
                    }

                    @Override
                    public String toString() {
                        return "City{" +
                                "cityId=" + cityId +
                                ", views=" + views +
                                '}';
                    }
                }

                public Integer getTimestamp() {
                    return timestamp;
                }

                public void setTimestamp(Integer timestamp) {
                    this.timestamp = timestamp;
                }

                public Integer getViews() {
                    return views;
                }

                public void setViews(Integer views) {
                    this.views = views;
                }

                public List<SexAge> getSexAges() {
                    return sexAges;
                }

                public void setSexAges(List<SexAge> sexAges) {
                    this.sexAges = sexAges;
                }

                public List<Country> getCountries() {
                    return countries;
                }

                public void setCountries(List<Country> countries) {
                    this.countries = countries;
                }

                public List<City> getCities() {
                    return cities;
                }

                public void setCities(List<City> cities) {
                    this.cities = cities;
                }

                @Override
                public String toString() {
                    return "Stat{" +
                            "timestamp=" + timestamp +
                            ", views=" + views +
                            ", sexAges=" + sexAges +
                            ", countries=" + countries +
                            ", cities=" + cities +
                            '}';
                }
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public List<Stat> getStats() {
                return stats;
            }

            public void setStats(List<Stat> stats) {
                this.stats = stats;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "key='" + key + '\'' +
                        ", stats=" + stats +
                        '}';
            }
        }
    }
}
