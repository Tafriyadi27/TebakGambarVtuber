package com.skullbreraker.tebakgambarvtuber.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VtuberModel {
    @SerializedName("id_vtuber")
    @Expose
    private Integer idVtuber;
    @SerializedName("nama_vtuber")
    @Expose
    private String namaVtuber;
    @SerializedName("level_id_level")
    @Expose
    private Integer levelIdLevel;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("level")
    @Expose
    private Level level;

    public Integer getIdVtuber() {
        return idVtuber;
    }

    public void setIdVtuber(Integer idVtuber) {
        this.idVtuber = idVtuber;
    }

    public String getNamaVtuber() {
        return namaVtuber;
    }

    public void setNamaVtuber(String namaVtuber) {
        this.namaVtuber = namaVtuber;
    }

    public Integer getLevelIdLevel() {
        return levelIdLevel;
    }

    public void setLevelIdLevel(Integer levelIdLevel) {
        this.levelIdLevel = levelIdLevel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public class Level {

        @SerializedName("is_solved")
        @Expose
        private Boolean isSolved;

        public Boolean getIsSolved() {
            return isSolved;
        }

        public void setIsSolved(Boolean isSolved) {
            this.isSolved = isSolved;
        }

    }
}
