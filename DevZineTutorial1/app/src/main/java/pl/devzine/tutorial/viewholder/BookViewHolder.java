package pl.devzine.tutorial.viewholder;

import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import pl.devzine.tutorial.R;
import pl.devzine.tutorial.common.AbstractRecyclerViewHolder;
import pl.devzine.tutorial.model.Book;

public class BookViewHolder extends AbstractRecyclerViewHolder<Book> {

    TextView bookTitleText;
    SimpleDraweeView bookCoverDrawee;
    TextView bookAuthorText;
    TextView bookDescriptionText;

    public BookViewHolder(View itemView) {
        super(itemView);
        bookTitleText = (TextView) itemView.findViewById(R.id.book_title_text);
        bookCoverDrawee = (SimpleDraweeView) itemView.findViewById(R.id.book_cover_drawee);
        bookAuthorText = (TextView) itemView.findViewById(R.id.book_author_text);
        bookDescriptionText = (TextView) itemView.findViewById(R.id.book_description_text);
    }

    @Override
    public void bindValues(Book book, int position) {
        bookTitleText.setText(book.getTitle());
        bookCoverDrawee.setImageURI(book.getCoverUrl());
        bookAuthorText.setText(book.getAuthor());
        bookDescriptionText.setText(book.getDescription());
    }
}
