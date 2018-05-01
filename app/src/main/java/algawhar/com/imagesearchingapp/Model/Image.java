package algawhar.com.imagesearchingapp.Model;

/**
 * Created by Ahmed Shaban on 30/04/2018.
 */

public class Image {

    private String urls;
    private String id;
    private int views;
    private int downloads;

    public Image(String urls, String id, int views, int downloads) {
        this.urls = urls;
        this.id = id;
        this.views = views;
        this.downloads = downloads;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }
}
