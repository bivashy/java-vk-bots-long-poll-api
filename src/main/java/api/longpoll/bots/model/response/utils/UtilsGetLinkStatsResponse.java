package api.longpoll.bots.model.response.utils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>utils.getLinkStats</b> request.
 */
public class UtilsGetLinkStatsResponse {
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
