package pl.devzine.tutorial;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import pl.devzine.tutorial.common.youtube.ThumbnailClickListener;
import pl.devzine.tutorial.common.youtube.ThumbnailListAdapter;
import pl.devzine.tutorial.common.youtube.ThumbnailListItem;
import pl.devzine.tutorial.common.youtube.YouTubeFragment;
import pl.devzine.tutorial.config.Config;
import pl.devzine.tutorial.model.Video;

public class  MainActivity extends AppCompatActivity implements ThumbnailClickListener {

    private static final String TAG = MainActivity.class.getName();

    private RecyclerView thumbnailsRecycler;
    private ThumbnailListAdapter adapter;
    private YouTubeFragment playerFragment;

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
        playerFragment = new YouTubeFragment();

        Bundle bundle = new Bundle();
        bundle.putString(YouTubeFragment.VIDEO_ID, videoId);
        bundle.putString(YouTubeFragment.API_KEY, key);

        playerFragment.setArguments(bundle);
        ft.add(R.id.youtube_frame_layout, playerFragment).commit();
    }

    @Override
    public void onThumbnailClicked(Video video) {
        Log.d(TAG, "video: " + video.toString());
        playerFragment.playVideo(video.getVideoId());
    }

    private List<ThumbnailListItem> getVideoData() {

        List<ThumbnailListItem> list = Arrays.asList(
            new ThumbnailListItem(new Video("bD7bpG-zDJQ", "The Phantom Menace")),
            new ThumbnailListItem(new Video("gYbW1F_c9eM", "Attack Of The Clones")),
            new ThumbnailListItem(new Video("5UnjrG_N8hU", "Revenge Of The Sith")),
            new ThumbnailListItem(new Video("vZ734NWnAHA", "A New Hope")),
            new ThumbnailListItem(new Video("JNwNXF9Y6kY", "The Empire Strikes Back")),
            new ThumbnailListItem(new Video("16YLjTkK5jE", "Return Of The Jedi")),
            new ThumbnailListItem(new Video("sGbxmsDFVnE", "The Force Awakens")),
            new ThumbnailListItem(new Video("Q0CbN8sfihY", "The Last Jedi"))
        );

        return list;
    }
}
