package com.example.jfuentesj.practicaservicio.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jfuentesj on 3/27/2018.
 */

public class YelmocinesResponse {
    private List<Movies> movies;
    private List<Routes> routes;
    private List<Schedules> schedules;

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }

    public List<Schedules> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedules> schedules) {
        this.schedules = schedules;
    }

    public class Movies {
        private int id;
        private String name;
        private String code;
        private String rating;
        private String length;
        private String synopsis;
        private String genre;
        private List<Media> media;
        private int position;
        private List<String> categories;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getSynopsis() {
            return synopsis;
        }

        public void setSynopsis(String synopsis) {
            this.synopsis = synopsis;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public List<Media> getMedia() {
            return media;
        }

        public void setMedia(List<Media> media) {
            this.media = media;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public class Media {
            private String type;
            private String code;
            private String resource;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getResource() {
                return resource;
            }

            public void setResource(String resource) {
                this.resource = resource;
            }
        }
    }

    public class Routes {
        private String code;
        private Object sizes;

        public class Sizes {
            private String large;
            private String medium;
            private String small;
            @SerializedName("x-large")
            private String xLarge;

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getxLarge() {
                return xLarge;
            }

            public void setxLarge(String xLarge) {
                this.xLarge = xLarge;
            }
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getSizes() {
            return sizes;
        }

        public void setSizes(Object sizes) {
            this.sizes = sizes;
        }
    }

    public class Schedules {
        @SerializedName("movie_id")
        private int movieId;
        @SerializedName("cinema_id")
        private int cinemaId;
        @SerializedName("city_id")
        private int cityId;
        @SerializedName("is_special_prices")
        private boolean isSpecialPrices;
        private List<Dates> dates;

        public class Dates {
            private String date;
            private List<Formats> formats;

            public class Formats {
                @SerializedName("format_id")
                private int formatId;
                @SerializedName("vista_id")
                private String vistaId;
                private String language;
                private List<Showtimes> showtimes;

                public class Showtimes {
                    @SerializedName("vista_id")
                    private String vistaId;
                    private String datetime;
                    private int screen;
                    private Object settings;
                    @SerializedName("early_morning")
                    private boolean earlyMorning;

                    public String getVistaId() {
                        return vistaId;
                    }

                    public void setVistaId(String vistaId) {
                        this.vistaId = vistaId;
                    }

                    public String getDatetime() {
                        return datetime;
                    }

                    public void setDatetime(String datetime) {
                        this.datetime = datetime;
                    }

                    public int getScreen() {
                        return screen;
                    }

                    public void setScreen(int screen) {
                        this.screen = screen;
                    }

                    public Object getSettings() {
                        return settings;
                    }

                    public void setSettings(Object settings) {
                        this.settings = settings;
                    }

                    public boolean isEarlyMorning() {
                        return earlyMorning;
                    }

                    public void setEarlyMorning(boolean earlyMorning) {
                        this.earlyMorning = earlyMorning;
                    }
                }

                public int getFormatId() {
                    return formatId;
                }

                public void setFormatId(int formatId) {
                    this.formatId = formatId;
                }

                public String getVistaId() {
                    return vistaId;
                }

                public void setVistaId(String vistaId) {
                    this.vistaId = vistaId;
                }

                public String getLanguage() {
                    return language;
                }

                public void setLanguage(String language) {
                    this.language = language;
                }

                public List<Showtimes> getShowtimes() {
                    return showtimes;
                }

                public void setShowtimes(List<Showtimes> showtimes) {
                    this.showtimes = showtimes;
                }
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public List<Formats> getFormats() {
                return formats;
            }

            public void setFormats(List<Formats> formats) {
                this.formats = formats;
            }
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public boolean isSpecialPrices() {
            return isSpecialPrices;
        }

        public void setSpecialPrices(boolean specialPrices) {
            isSpecialPrices = specialPrices;
        }

        public List<Dates> getDates() {
            return dates;
        }

        public void setDates(List<Dates> dates) {
            this.dates = dates;
        }
    }
}