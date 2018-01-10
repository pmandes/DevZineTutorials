package pl.devzine.tutorial;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import pl.devzine.tutorial.common.AbstractAdapter;
import pl.devzine.tutorial.common.AbstractRecyclerViewHolder;
import pl.devzine.tutorial.model.Book;
import pl.devzine.tutorial.model.Dvd;
import pl.devzine.tutorial.viewholder.BookViewHolder;
import pl.devzine.tutorial.viewholder.DVDViewHolder;
import pl.devzine.tutorial.viewholder.HeaderViewHolder;

public class RecycledListAdapter extends AbstractAdapter<RecycledListItem, AbstractRecyclerViewHolder> {

    private static final String TAG = RecycledListAdapter.class.getSimpleName();

    private RecycledListItemClickListener listener;

    @Override
    public AbstractRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        AbstractRecyclerViewHolder viewHolder = null;

        switch (RecycledListItem.ItemType.values()[viewType]) {
            case HEADER:
                viewHolder = new HeaderViewHolder(inflateView(parent, R.layout.header_item_layout));
                break;
            case DVD:
                viewHolder = new DVDViewHolder(inflateView(parent, R.layout.dvd_item_layout));
                break;
            case BOOK:
                viewHolder = new BookViewHolder(inflateView(parent, R.layout.book_item_layout));
                break;
        }

        viewHolder.setItemClickListener(this);

        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType().ordinal();
    }

    @Override
    public void onBindViewHolder(AbstractRecyclerViewHolder holder, int position) {
        holder.bindValues(getItem(position).getValue(), position);
    }

    @Override
    public void onItemClick(View view, int position) {

        Log.d(TAG, "onItemClick: " + Integer.toString(position));

        int itemViewType = getItemViewType(position);

        switch (RecycledListItem.ItemType.values()[itemViewType]) {
            case BOOK:
                listener.onBookItemClickListener((Book) items.get(position).getValue());
                break;
            case DVD:
                listener.onDVDItemClickListener((Dvd) items.get(position).getValue());
                break;
            case HEADER:
            default:
                break;
        }
    }

    public void setItemClickListener(RecycledListItemClickListener listener) {
        this.listener = listener;
    }
}
