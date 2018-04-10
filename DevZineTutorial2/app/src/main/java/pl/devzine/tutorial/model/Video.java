package pl.devzine.tutorial.model;

public class Video {

    private String videoId;
    private String title;

    public Video(String videoId, String title) {
        this.videoId = videoId;
        this.title = title;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
