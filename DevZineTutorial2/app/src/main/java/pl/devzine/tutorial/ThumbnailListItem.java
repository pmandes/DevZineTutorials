package pl.devzine.tutorial;

import pl.devzine.tutorial.model.Video;

public class ThumbnailListItem {

    public enum ItemType {
        VIDEO
    }

    private ItemType type;
    private Video video;

    public ThumbnailListItem(Video video) {
        this.video = video;
        this.type = ItemType.VIDEO;
    }

    public ItemType getType() {
        return type;
    }

    public Object getValue() {
        if (ItemType.VIDEO.equals(this.type)) {
            return this.video;
        } else {
            return null;
        }
    }
}
