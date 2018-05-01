package algawhar.com.imagesearchingapp.Retrofit;

import java.util.List;

import algawhar.com.imagesearchingapp.Model.Result;

/**
 * Created by Ahmed Shaban on 30/04/2018.
 */

public class ResultImageModel {
    private int total;
    private int total_pages;
    private List<Result> results;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
