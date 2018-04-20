package kz.cheesenology.yandextask.model;

public class AdapterModel {
    String image;

    public AdapterModel(String image) {
        this.image = image;
    }

    public String getImgURL() {
        return image;
    }

    public void setImgURL(String image) {
        this.image = image;
    }
}
