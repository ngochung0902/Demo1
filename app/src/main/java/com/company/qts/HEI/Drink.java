package com.company.qts.hei;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by MyPC on 09/08/2017.
 */
public class Drink {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mixologist_id")
    @Expose
    private String mixologistId;
    @SerializedName("mix_name")
    @Expose
    private String mixName;
    @SerializedName("spirit_id")
    @Expose
    private String spiritId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("created")
    @Expose
    private String created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMixologistId() {
        return mixologistId;
    }

    public void setMixologistId(String mixologistId) {
        this.mixologistId = mixologistId;
    }

    public String getMixName() {
        return mixName;
    }

    public void setMixName(String mixName) {
        this.mixName = mixName;
    }

    public String getSpiritId() {
        return spiritId;
    }

    public void setSpiritId(String spiritId) {
        this.spiritId = spiritId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mixologistId='" + mixologistId + '\'' +
                ", mixName='" + mixName + '\'' +
                ", spiritId='" + spiritId + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
