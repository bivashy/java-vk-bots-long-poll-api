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
            }

            public static class Country {
                @SerializedName("country_id")
                private Integer countryId;
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
            }

            public static class City {
                @SerializedName("city_id")
                private Integer cityId;
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
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
