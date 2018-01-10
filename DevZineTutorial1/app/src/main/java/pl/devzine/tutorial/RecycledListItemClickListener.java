package pl.devzine.tutorial;

import pl.devzine.tutorial.model.Book;
import pl.devzine.tutorial.model.Dvd;

public interface RecycledListItemClickListener {

    void onBookItemClickListener(Book model);

    void onDVDItemClickListener(Dvd model);
}
