package pl.devzine.tutorial;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pl.devzine.tutorial.config.Config;
import pl.devzine.tutorial.model.Video;

public class  MainActivity extends AppCompatActivity implements ThumbnailClickListener {

    private RecyclerView thumbnailsRecycler;
    private ThumbnailListAdapter adapter;
    private List<Thumbnail> items = new ArrayList<Thumbnail>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initVideo(Config.Keys.YOUTUBE_API_KEY, "Q0CbN8sfihY");

        adapter = new ThumbnailListAdapter();

        thumbnailsRecycler = findViewById(R.id.thumbnails_recycler);
        thumbnailsRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        thumbnailsRecycler.setAdapter(adapter);

        adapter.setItems(getVideoData());
        adapter.setItemClickListener(this);
    }

    private void initVideo(String key, String videoId) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        YouTubeFragment fragment = new YouTubeFragment();

        Bundle bundle = new Bundle();
        bundle.putString(YouTubeFragment.VIDEO_ID, videoId);
        bundle.putString(YouTubeFragment.API_KEY, key);

        fragment.setArguments(bundle);
        ft.add(R.id.youtube_frame_layout, fragment).commit();
    }

    @Override
    public void onThumbnailClicked(Video video) {
        Log.d("CLICK", "video: " + video.toString());
    }

    private List<ThumbnailListItem> getVideoData() {

        List<ThumbnailListItem> list = new ArrayList<>();

        Video v1 = new Video("bD7bpG-zDJQ", "The Phantom Menace");
        Video v2 = new Video("gYbW1F_c9eM", "Attack Of The Clones");
        Video v3 = new Video("5UnjrG_N8hU", "Revenge Of The Sith");
        Video v4 = new Video("vZ734NWnAHA", "A New Hope");
        Video v5 = new Video("JNwNXF9Y6kY", "The Empire Strikes Back");
        Video v6 = new Video("16YLjTkK5jE", "Return Of The Jedi");
        Video v7 = new Video("sGbxmsDFVnE", "The Force Awakens");
        Video v8 = new Video("Q0CbN8sfihY", "The Last Jedi");

        list.add(new ThumbnailListItem(v1));
        list.add(new ThumbnailListItem(v2));
        list.add(new ThumbnailListItem(v3));
        list.add(new ThumbnailListItem(v4));
        list.add(new ThumbnailListItem(v5));
        list.add(new ThumbnailListItem(v6));
        list.add(new ThumbnailListItem(v7));
        list.add(new ThumbnailListItem(v8));

        return list;
    }
}
