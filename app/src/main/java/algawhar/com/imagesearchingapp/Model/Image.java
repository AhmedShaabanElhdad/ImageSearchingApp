package algawhar.com.imagesearchingapp.Model;

/**
 * Created by Ahmed Shaban on 30/04/2018.
 */

public class Image {

    private String urls;
    private String id;
    private String description;
    private int likes;

    public Image(String urls, String id, String description, int likes) {
        this.urls = urls;
        this.id = id;
        this.description = description;
        this.likes = likes;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
