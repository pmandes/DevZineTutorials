package pl.devzine.tutorial.common.youtube;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import pl.devzine.tutorial.R;
import pl.devzine.tutorial.common.recycler.AbstractRecyclerViewHolder;
import pl.devzine.tutorial.config.Config;
import pl.devzine.tutorial.model.Video;

public class ThumbnailViewHolder extends AbstractRecyclerViewHolder<Video>
        implements YouTubeThumbnailLoader.OnThumbnailLoadedListener, YouTubeThumbnailView.OnInitializedListener {

    private static final String TAG = ThumbnailViewHolder.class.getName();

    YouTubeThumbnailView thumbnailView;
    TextView tilteTextView;
    ProgressBar progressBar;

    public ThumbnailViewHolder(View itemView) {
        super(itemView);
        thumbnailView = itemView.findViewById(R.id.youtube_thumb_view);
        tilteTextView = itemView.findViewById(R.id.video_title);
        progressBar = itemView.findViewById(R.id.progress_bar);
    }

    @Override
    public void bindValues(Video video, int position) {
        tilteTextView.setText(video.getTitle());
        thumbnailView.setTag(video.getVideoId());
        thumbnailView.initialize(Config.Keys.YOUTUBE_API_KEY, this);
    }

    @Override
    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
        progressBar.setVisibility(View.GONE);
        Log.d(TAG, "onThumbnailLoaded: " + s);
    }

    @Override
    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {
        progressBar.setVisibility(View.GONE);
        Log.e(TAG, "onThumbnailError: " + errorReason.toString());
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
        Log.d(TAG, "onInitializationSuccess");
        youTubeThumbnailLoader.setOnThumbnailLoadedListener(this);
        youTubeThumbnailLoader.setVideo(thumbnailView.getTag().toString());
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
        progressBar.setVisibility(View.GONE);
        Log.e(TAG, "onInitializationFailure: " + youTubeInitializationResult.toString());
    }
}
