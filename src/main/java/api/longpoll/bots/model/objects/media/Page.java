package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

/**
 * Describes Page object.
 */
public class Page {
    @SerializedName("created")
    private Integer created;

    @SerializedName("edited")
    private Integer edited;

    @SerializedName("group_id")
    private Integer groupId;

    @SerializedName("id")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("view_url")
    private String viewUrl;

    @SerializedName("views")
    private Integer views;

    @SerializedName("who_can_edit")
    private Integer whoCanEdit;

    @SerializedName("who_can_view")
    private Integer whoCanView;

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getEdited() {
        return edited;
    }

    public void setEdited(Integer edited) {
        this.edited = edited;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

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

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getWhoCanEdit() {
        return whoCanEdit;
    }

    public void setWhoCanEdit(Integer whoCanEdit) {
        this.whoCanEdit = whoCanEdit;
    }

    public Integer getWhoCanView() {
        return whoCanView;
    }

    public void setWhoCanView(Integer whoCanView) {
        this.whoCanView = whoCanView;
    }

    @Override
    public String toString() {
        return "Page{" +
                "created=" + created +
                ", edited=" + edited +
                ", groupId=" + groupId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", viewUrl='" + viewUrl + '\'' +
                ", views=" + views +
                ", whoCanEdit=" + whoCanEdit +
                ", whoCanView=" + whoCanView +
                '}';
    }
}
