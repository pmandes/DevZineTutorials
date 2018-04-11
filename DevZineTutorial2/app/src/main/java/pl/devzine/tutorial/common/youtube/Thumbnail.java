package pl.devzine.tutorial.common.youtube;

import android.util.Log;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class Thumbnail implements YouTubeThumbnailView.OnInitializedListener, YouTubeThumbnailLoader.OnThumbnailLoadedListener {

    private static final String TAG = Thumbnail.class.getName();

    private YouTubeThumbnailView thumbnailView;
    private String key;
    private String videoId;

    public Thumbnail(String key, String videoId) {
        this.key = key;
        this.videoId = videoId;
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
        youTubeThumbnailLoader.setOnThumbnailLoadedListener(this);
        youTubeThumbnailLoader.setVideo(thumbnailView.getTag().toString());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
        Log.e(TAG, "onInitializationFailure: " + youTubeInitializationResult.toString());
    }

    @Override
    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
        Log.d(TAG, "onThumbnailLoaded: " + s);
    }

    @Override
    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
        Log.e(TAG, "onThumbnailError: " + errorReason.toString());
    }
}
