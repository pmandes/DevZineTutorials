package pl.devzine.tutorial;

import pl.devzine.tutorial.model.Book;
import pl.devzine.tutorial.model.Dvd;
import pl.devzine.tutorial.model.Header;

public class RecycledListItem {

    public enum ItemType {
        HEADER, BOOK, DVD
    }

    private ItemType type;

    private Header header;
    private Book book;
    private Dvd dvd;

    public RecycledListItem(Header header) {
        this.header = header;
        this.type = ItemType.HEADER;
    }

    public RecycledListItem(Book book) {
        this.book = book;
        this.type = ItemType.BOOK;
    }

    public RecycledListItem(Dvd book) {
        this.dvd = book;
        this.type = ItemType.DVD;
    }

    public ItemType getType() {
        return type;
    }

    public Object getValue() {
        if (ItemType.HEADER.equals(this.type)) {
            return this.header;
        } else if (ItemType.BOOK.equals(this.type)) {
            return this.book;
        } else if (ItemType.DVD.equals(this.type)) {
            return this.dvd;
        } else {
            return null;
        }
    }
}
