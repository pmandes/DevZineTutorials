package pl.devzine.tutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import pl.devzine.tutorial.api.MockAPI;
import pl.devzine.tutorial.model.Book;
import pl.devzine.tutorial.model.Dvd;

public class MainActivity extends AppCompatActivity implements RecycledListItemClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView listRecyclerView;
    private RecycledListAdapter adapter;
    private List<RecycledListItem> items = new ArrayList<RecycledListItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initViews();
    }

    protected void initViews() {
        listRecyclerView = (RecyclerView) findViewById(R.id.list_recycler);

        adapter = new RecycledListAdapter();
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listRecyclerView.setAdapter(adapter);

        items = MockAPI.retrieveData();
        adapter.setItems(items);
        adapter.setItemClickListener(this);
    }

    @Override
    public void onBookItemClickListener(Book book) {
        Log.d(TAG, "Book clicked: " + book.toString());
    }

    @Override
    public void onDVDItemClickListener(Dvd dvd) {
        Log.d(TAG, "DVD clicked: " + dvd.toString());
    }
}
