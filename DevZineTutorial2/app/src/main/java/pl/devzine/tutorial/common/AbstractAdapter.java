package pl.devzine.tutorial.common;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractAdapter<I, VH extends AbstractRecyclerViewHolder>
        extends RecyclerView.Adapter<VH> implements ItemClickListener {

    protected List<I> items;

    public AbstractAdapter() {
        this.items = new ArrayList<>();
    }

    public void setItems(Collection<I> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public I getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected View inflateView(ViewGroup parent, int layoutId) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }

}
