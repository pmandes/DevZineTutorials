package pl.devzine.tutorial.common.youtube;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import pl.devzine.tutorial.R;
import pl.devzine.tutorial.common.recycler.AbstractRecyclerViewHolder;
import pl.devzine.tutorial.config.Config;
import pl.devzine.tutorial.model.Video;

public class ThumbnailViewHolder extends AbstractRecyclerViewHolder<Video> implements YouTubeThumbnailLoader.OnThumbnailLoadedListener {

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

        Thumbnail thumbnail = new Thumbnail(Config.Keys.YOUTUBE_API_KEY, video.getVideoId(), this);
        thumbnail.setThumbnailView(thumbnailView);
        thumbnail.init();
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
}
