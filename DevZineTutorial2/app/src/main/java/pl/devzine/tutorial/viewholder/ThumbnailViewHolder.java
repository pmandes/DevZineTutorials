package pl.devzine.tutorial.viewholder;

import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeThumbnailView;

import pl.devzine.tutorial.R;
import pl.devzine.tutorial.Thumbnail;
import pl.devzine.tutorial.common.AbstractRecyclerViewHolder;
import pl.devzine.tutorial.config.Config;
import pl.devzine.tutorial.model.Video;

public class ThumbnailViewHolder extends AbstractRecyclerViewHolder<Video> {

    YouTubeThumbnailView thumbnailView;
    TextView tilteTextView;

    public ThumbnailViewHolder(View itemView) {
        super(itemView);
        thumbnailView = itemView.findViewById(R.id.youtube_thumb_view);
        tilteTextView = itemView.findViewById(R.id.video_title);
    }

    @Override
    public void bindValues(Video video, int position) {
        tilteTextView.setText(video.getTitle());

        Thumbnail thumbnail = new Thumbnail(Config.Keys.YOUTUBE_API_KEY, video.getVideoId());
        thumbnail.setThumbnailView(thumbnailView);
        thumbnail.init();
    }
}
