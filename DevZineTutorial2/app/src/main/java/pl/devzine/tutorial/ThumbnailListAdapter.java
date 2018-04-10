package pl.devzine.tutorial;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import pl.devzine.tutorial.common.AbstractAdapter;
import pl.devzine.tutorial.common.AbstractRecyclerViewHolder;
import pl.devzine.tutorial.model.Video;
import pl.devzine.tutorial.viewholder.ThumbnailViewHolder;

public class ThumbnailListAdapter extends AbstractAdapter<ThumbnailListItem, AbstractRecyclerViewHolder> {

    private static final String TAG = ThumbnailListAdapter.class.getSimpleName();

    private ThumbnailClickListener listener;

    @Override
    public AbstractRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        AbstractRecyclerViewHolder viewHolder = null;

        switch (ThumbnailListItem.ItemType.values()[viewType]) {
            case VIDEO:
                viewHolder = new ThumbnailViewHolder(inflateView(parent, R.layout.thumbnail_item_layout));
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

        switch (ThumbnailListItem.ItemType.values()[itemViewType]) {
            case VIDEO:
                listener.onThumbnailClicked((Video) items.get(position).getValue());
                break;
            default:
                break;
        }
    }

    public void setItemClickListener(ThumbnailClickListener listener) {
        this.listener = listener;
    }
}
