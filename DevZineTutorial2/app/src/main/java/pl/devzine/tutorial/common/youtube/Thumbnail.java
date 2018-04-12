package pl.devzine.tutorial.common.youtube;

import android.util.Log;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class Thumbnail implements YouTubeThumbnailView.OnInitializedListener {

    private static final String TAG = Thumbnail.class.getName();

    private YouTubeThumbnailLoader.OnThumbnailLoadedListener listener;

    private YouTubeThumbnailView thumbnailView;
    private String key;
    private String videoId;

    public Thumbnail(String key, String videoId, YouTubeThumbnailLoader.OnThumbnailLoadedListener listener) {
        this.key = key;
        this.videoId = videoId;
        this.listener = listener;
    }

    public void init() {
        thumbnailView.setTag(videoId);
        thumbnailView.initialize(key, this);
    }

    public void setThumbnailView(YouTubeThumbnailView thumbnailView) {
        this.thumbnailView = thumbnailView;
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
        Log.d(TAG, "onInitializationSuccess");
        youTubeThumbnailLoader.setOnThumbnailLoadedListener(listener);
        youTubeThumbnailLoader.setVideo(thumbnailView.getTag().toString());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
        Log.e(TAG, "onInitializationFailure: " + youTubeInitializationResult.toString());
    }
}
