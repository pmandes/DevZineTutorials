package pl.devzine.tutorial.api;

import java.util.ArrayList;
import java.util.List;

import pl.devzine.tutorial.RecycledListItem;
import pl.devzine.tutorial.model.Book;
import pl.devzine.tutorial.model.Dvd;
import pl.devzine.tutorial.model.Header;

public class MockAPI {

    public static List<RecycledListItem> retrieveData() {

        List<RecycledListItem> data = new ArrayList<RecycledListItem>();

        RecycledListItem header1 = new RecycledListItem(new Header("Section header 1", "This is section subheader 1"));
        data.add(header1);

        for (int i = 0; i < 10; i++) {
            RecycledListItem book = new RecycledListItem(new Book("Book Title " + i, "Author Anonymous", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", ""));
            data.add(book);
        }

        RecycledListItem header2 = new RecycledListItem(new Header("Section header 2", "This is section subheader 2"));
        data.add(header2);

        for (int i = 0; i < 10; i++) {
            RecycledListItem dvd = new RecycledListItem(new Dvd("DVD Title " + i, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", ""));
            data.add(dvd);
        }

        return data;
    }
}
