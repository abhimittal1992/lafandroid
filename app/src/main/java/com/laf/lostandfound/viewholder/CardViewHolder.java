package com.laf.lostandfound.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.laf.lostandfound.R;

/**
 * Created by durlabhsharma on 9/5/17.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {
    private TextView cardTitle;
    private TextView cardDesc;

    public CardViewHolder(View v) {
        super(v);
        cardTitle = (TextView) v.findViewById(R.id.cardTitle);
        cardDesc = (TextView) v.findViewById(R.id.cardDesc);
    }


    public TextView getCardDesc() {
        return cardDesc;
    }

    public void setCardDesc(TextView cardDesc) {
        this.cardDesc = cardDesc;
    }

    public TextView getCardTitle() {

        return cardTitle;
    }

    public void setCardTitle(TextView cardTitle) {
        this.cardTitle = cardTitle;
    }
}
