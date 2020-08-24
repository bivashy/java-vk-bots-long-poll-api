package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UtilsGetLinkStatsResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("key")
        private String key;
        @SerializedName("stats")
        private List<Stat> stats;

        public static class Stat {
            @SerializedName("timestamp")
            private Integer timestamp;
            @SerializedName("views")
            private Integer views;
            @SerializedName("sex_age")
            private List<SexAge> sexAges;
            @SerializedName("countries")
            private List<Country> countries;
            @SerializedName("cities")
            private List<City> cities;

            public static class SexAge {
                @SerializedName("age_range")
                private String ageRange;
                @SerializedName("female")
                private Integer female;
                @SerializedName("male")
                private Integer male;

                public String getAgeRange() {
                    return ageRange;
                }

                public SexAge setAgeRange(String ageRange) {
                    this.ageRange = ageRange;
                    return this;
                }

                public Integer getFemale() {
                    return female;
                }

                public SexAge setFemale(Integer female) {
                    this.female = female;
                    return this;
                }

                public Integer getMale() {
                    return male;
                }

                public SexAge setMale(Integer male) {
                    this.male = male;
                    return this;
                }
            }

            public static class Country {
                @SerializedName("country_id")
                private Integer countryId;
                @SerializedName("views")
                private Integer views;

                public Integer getCountryId() {
                    return countryId;
                }

                public Country setCountryId(Integer countryId) {
                    this.countryId = countryId;
                    return this;
                }

                public Integer getViews() {
                    return views;
                }

                public Country setViews(Integer views) {
                    this.views = views;
                    return this;
                }
            }

            public static class City {
                @SerializedName("city_id")
                private Integer cityId;
                @SerializedName("views")
                private Integer views;

                public Integer getCityId() {
                    return cityId;
                }

                public City setCityId(Integer cityId) {
                    this.cityId = cityId;
                    return this;
                }

                public Integer getViews() {
                    return views;
                }

                public City setViews(Integer views) {
                    this.views = views;
                    return this;
                }
            }

            public Integer getTimestamp() {
                return timestamp;
            }

            public Stat setTimestamp(Integer timestamp) {
                this.timestamp = timestamp;
                return this;
            }

            public Integer getViews() {
                return views;
            }

            public Stat setViews(Integer views) {
                this.views = views;
                return this;
            }

            public List<SexAge> getSexAges() {
                return sexAges;
            }

            public Stat setSexAges(List<SexAge> sexAges) {
                this.sexAges = sexAges;
                return this;
            }

            public List<Country> getCountries() {
                return countries;
            }

            public Stat setCountries(List<Country> countries) {
                this.countries = countries;
                return this;
            }

            public List<City> getCities() {
                return cities;
            }

            public Stat setCities(List<City> cities) {
                this.cities = cities;
                return this;
            }
        }

        public String getKey() {
            return key;
        }

        public Response setKey(String key) {
            this.key = key;
            return this;
        }

        public List<Stat> getStats() {
            return stats;
        }

        public Response setStats(List<Stat> stats) {
            this.stats = stats;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public UtilsGetLinkStatsResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
