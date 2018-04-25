package kz.cheesenology.yandextask.model;

public class AdapterModel {
    String URL;
    String prewiewURL;

    public AdapterModel(String URL, String prewiewURL) {
        this.URL = URL;
        this.prewiewURL = prewiewURL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getPrewiewURL() {
        return prewiewURL;
    }

    public void setPrewiewURL(String prewiewURL) {
        this.prewiewURL = prewiewURL;
    }
}

