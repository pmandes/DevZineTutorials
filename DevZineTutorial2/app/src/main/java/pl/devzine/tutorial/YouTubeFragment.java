package pl.devzine.tutorial;

import android.os.Bundle;
import android.util.Log;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

public class YouTubeFragment extends YouTubePlayerSupportFragment {

    public static final String VIDEO_ID = "VIDEO_ID";
    public static final String API_KEY = "API_KEY";

    public YouTubeFragment() {
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        Bundle data = getArguments();
        String key = data.getString(API_KEY);
        final String videoId = data.getString(VIDEO_ID);

        initialize(key, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
                if (!wasRestored) {
                    youTubePlayer.cueVideo(videoId);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.e("", youTubeInitializationResult.toString());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
