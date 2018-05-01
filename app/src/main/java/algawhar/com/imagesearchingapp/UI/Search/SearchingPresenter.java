package algawhar.com.imagesearchingapp.UI.Search;

public interface SearchingPresenter {

    void onResume();

    void onDestroy();

    void search(String query, int pageNum);

    //void download(String url);
}
