package pl.devzine.tutorial.viewholder;

import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import pl.devzine.tutorial.R;
import pl.devzine.tutorial.common.AbstractRecyclerViewHolder;
import pl.devzine.tutorial.model.Dvd;

public class DVDViewHolder extends AbstractRecyclerViewHolder<Dvd> {

    TextView dvdTitleText;
    SimpleDraweeView dvdCoverDrawee;
    TextView dvdDescriptionText;

    public DVDViewHolder(View itemView) {
        super(itemView);
        dvdTitleText = (TextView) itemView.findViewById(R.id.dvd_title_text);
        dvdCoverDrawee = (SimpleDraweeView) itemView.findViewById(R.id.dvd_cover_drawee);
        dvdDescriptionText = (TextView) itemView.findViewById(R.id.dvd_description_text);
    }

    @Override
    public void bindValues(Dvd dvd, int position) {
        dvdTitleText.setText(dvd.getTitle());
        dvdCoverDrawee.setImageURI(dvd.getCoverUrl());
        dvdDescriptionText.setText(dvd.getDescription());
    }
}
