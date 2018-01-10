package pl.devzine.tutorial.viewholder;

import android.view.View;
import android.widget.TextView;

import pl.devzine.tutorial.R;
import pl.devzine.tutorial.common.AbstractRecyclerViewHolder;
import pl.devzine.tutorial.model.Header;

public class HeaderViewHolder extends AbstractRecyclerViewHolder<Header> {

    TextView titleTextView;
    TextView subtitleTextView;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        titleTextView = (TextView) itemView.findViewById(R.id.header_title_text);
        subtitleTextView = (TextView) itemView.findViewById(R.id.header_subtitle_text);
    }

    @Override
    public void bindValues(Header item, int position) {

        titleTextView.setText(item.getTitle());
        subtitleTextView.setText(item.getSubTitle());
    }
}
