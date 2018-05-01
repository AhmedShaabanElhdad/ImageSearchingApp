package algawhar.com.imagesearchingapp.UI.Start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;

import algawhar.com.imagesearchingapp.R;
import algawhar.com.imagesearchingapp.UI.Search.SearchingActivity;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{


    SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchView = (SearchView) findViewById(R.id.search);
        mSearchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        Intent intent=new Intent(this, SearchingActivity.class);
        intent.putExtra("query",query);
        startActivity(intent);


        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
