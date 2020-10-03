package net.jxvtc.day0427.model;

public class Hero {
    private int image;
    private String title;
    private String secondary_text;
    private String sipporting_text;

    public Hero() {
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecondary_text() {
        return secondary_text;
    }

    public void setSecondary_text(String secondary_text) {
        this.secondary_text = secondary_text;
    }

    public String getSipporting_text() {
        return sipporting_text;
    }

    public void setSipporting_text(String sipporting_text) {
        this.sipporting_text = sipporting_text;
    }

    public Hero(int image, String title, String secondary_text, String sipporting_text) {
        this.image = image;
        this.title = title;
        this.secondary_text = secondary_text;
        this.sipporting_text = sipporting_text;
    }


}
