package algawhar.com.imagesearchingapp.Model;

import java.util.List;

/**
 * Created by Ahmed Shaban on 30/04/2018.
 */

public class Result {
    private String id;
    private String created_at;
    private String updated_at;
    private String description;
    private int width;
    private int height;
    private Urls urls;
    private int views;
    private int downloads;
    private int likes;

    public Result(String id, String created_at, String updated_at, int width, int height, Urls urls, int views, int downloads) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.width = width;
        this.height = height;
        this.urls = urls;
        this.views = views;
        this.downloads = downloads;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
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


