package pl.devzine.tutorial.common.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class AbstractRecyclerViewHolder<T> extends RecyclerView.ViewHolder
        implements View.OnClickListener {

    protected ItemClickListener mItemClickListener;

    public AbstractRecyclerViewHolder(View itemView) {
        super(itemView);
        super.itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (mItemClickListener != null) {
            int adapterPosition = getAdapterPosition();
            if (adapterPosition != RecyclerView.NO_POSITION) {
                mItemClickListener.onItemClick(view, adapterPosition);
            }
        }
    }

    public abstract void bindValues(T item, int position);
}
