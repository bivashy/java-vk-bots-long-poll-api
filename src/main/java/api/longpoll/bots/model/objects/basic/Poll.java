package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.objects.media.Photo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Object describes poll.
 *
 * @see <a href="https://vk.com/dev/objects/poll">Poll</a>
 */
public class Poll implements Attachable {
    /**
     * Poll ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Poll owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Creation date in Unixtime.
     */
    @SerializedName("created")
    private Integer created;

    /**
     * Question text.
     */
    @SerializedName("question")
    private String question;

    /**
     * Votes count.
     */
    @SerializedName("votes")
    private Integer votes;

    /**
     * Poll options.
     */
    @SerializedName("answers")
    private List<Answer> answers;

    /**
     * If the poll is anonymous.
     */
    @SerializedName("anonymous")
    private Boolean anonymous;

    /**
     * If the poll allows multiple choice.
     */
    @SerializedName("multiple")
    private Boolean multiple;

    /**
     * Current user's chosen answers.
     */
    @SerializedName("answer_ids")
    private List<Integer> answerIds;

    /**
     * End date in Unixtime. 0 if poll's lifetime not limited.
     */
    @SerializedName("end_date")
    private Integer endDate;

    /**
     * If the poll is closed.
     */
    @SerializedName("closed")
    private Boolean closed;

    /**
     * If the poll is attached to a board.
     */
    @SerializedName("is_board")
    private Boolean isBoard;

    /**
     * If the poll can be edited by current user.
     */
    @SerializedName("can_edit")
    private Boolean canEdit;

    /**
     * If current user can vote.
     */
    @SerializedName("can_vote")
    private Boolean canVote;

    /**
     * If current user can report the poll.
     */
    @SerializedName("can_report")
    private Boolean canReport;

    /**
     * If current user can share the poll.
     */
    @SerializedName("can_share")
    private Boolean canShare;

    /**
     * Poll author's ID.
     */
    @SerializedName("author_id")
    private Integer authorId;

    /**
     * Poll's photo.
     */
    @SerializedName("photo")
    private Photo photo;

    /**
     * Poll's background.
     */
    @SerializedName("background")
    private Background background;

    /**
     * IDs of 3 friends voted the poll.
     */
    @SerializedName("friends")
    private List<Friend> friends;

    /**
     * Poll option.
     */
    public static class Answer {
        /**
         * Option ID
         */
        @SerializedName("id")
        private Integer id;

        /**
         * Option text.
         */
        @SerializedName("text")
        private String text;

        /**
         * Voters count.
         */
        @SerializedName("votes")
        private Integer votes;

        /**
         * Option rate.
         */
        @SerializedName("rate")
        private Double rate;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getVotes() {
            return votes;
        }

        public void setVotes(Integer votes) {
            this.votes = votes;
        }

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }


        @Override
        public String toString() {
            return "Answer{" +
                    "id=" + id +
                    ", text='" + text + '\'' +
                    ", votes=" + votes +
                    ", rate=" + rate +
                    '}';
        }
    }

    /**
     * Describes poll's background.
     */
    public static class Background {
        /**
         * Background ID.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * Background type. Possible values: gradient, tile.
         */
        @SerializedName("type")
        private String type;

        /**
         * (for type = gradient) gradient angle for X axe.
         */
        @SerializedName("angle")
        private Integer angle;

        /**
         * HEX-code for alternative color (without #).
         */
        @SerializedName("color")
        private String color;

        /**
         * (for type = tile) tile's width.
         */
        @SerializedName("width")
        private Integer width;

        /**
         * (for type = tile) tile's height.
         */
        @SerializedName("height")
        private Integer height;

        /**
         * (for type = tile) tile's image.
         */
        @SerializedName("images")
        private List<PhotoSize> images;

        /**
         * (for type = gradient) gradient's points.
         */
        @SerializedName("points")
        private List<Point> points;

        /**
         * Describes gradient's point.
         */
        public static class Point {
            /**
             * Gradient't point position.
             */
            @SerializedName("position")
            private Double position;

            /**
             * Gradient't point color.
             */
            @SerializedName("color")
            private String color;

            public Double getPosition() {
                return position;
            }

            public void setPosition(Double position) {
                this.position = position;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            @Override
            public String toString() {
                return "Point{" +
                        "position=" + position +
                        ", color='" + color + '\'' +
                        '}';
            }
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getAngle() {
            return angle;
        }

        public void setAngle(Integer angle) {
            this.angle = angle;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public List<PhotoSize> getImages() {
            return images;
        }

        public void setImages(List<PhotoSize> images) {
            this.images = images;
        }

        public List<Point> getPoints() {
            return points;
        }

        public void setPoints(List<Point> points) {
            this.points = points;
        }

        @Override
        public String toString() {
            return "Background{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    ", angle=" + angle +
                    ", color='" + color + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", images=" + images +
                    ", points=" + points +
                    '}';
        }
    }

    /**
     * Friend ID.
     */
    public static class Friend {
        /**
         * Friend ID.
         */
        @SerializedName("id")
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Friend{" +
                    "id=" + id +
                    '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public List<Integer> getAnswerIds() {
        return answerIds;
    }

    public void setAnswerIds(List<Integer> answerIds) {
        this.answerIds = answerIds;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Boolean getBoard() {
        return isBoard;
    }

    public void setBoard(Boolean board) {
        isBoard = board;
    }

    public Boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Boolean getCanVote() {
        return canVote;
    }

    public void setCanVote(Boolean canVote) {
        this.canVote = canVote;
    }

    public Boolean getCanReport() {
        return canReport;
    }

    public void setCanReport(Boolean canReport) {
        this.canReport = canReport;
    }

    public Boolean getCanShare() {
        return canShare;
    }

    public void setCanShare(Boolean canShare) {
        this.canShare = canShare;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", created=" + created +
                ", question='" + question + '\'' +
                ", votes=" + votes +
                ", answers=" + answers +
                ", anonymous=" + anonymous +
                ", multiple=" + multiple +
                ", answerIds=" + answerIds +
                ", endDate=" + endDate +
                ", closed=" + closed +
                ", isBoard=" + isBoard +
                ", canEdit=" + canEdit +
                ", canVote=" + canVote +
                ", canReport=" + canReport +
                ", canShare=" + canShare +
                ", authorId=" + authorId +
                ", photo=" + photo +
                ", background=" + background +
                ", friends=" + friends +
                '}';
    }
}
