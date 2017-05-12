package com.laf.lostandfound.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laf.lostandfound.R;
import com.laf.lostandfound.dto.BaseCardDto;
import com.laf.lostandfound.viewholder.CardViewHolder;

import java.util.List;

/**
 * Created by durlabhsharma on 9/5/17.
 */

public class HomeCardAdapter extends RecyclerView.Adapter<CardViewHolder>{

    private List<BaseCardDto> cardDtoList;
    public HomeCardAdapter(List<BaseCardDto> cardDtoList) {
        this.cardDtoList = cardDtoList;
    }

    @Override
    public int getItemCount() {
        return cardDtoList.size();
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.home_card, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        BaseCardDto cardDto = cardDtoList.get(position);
        holder.getCardTitle().setText(cardDto.getCardTitle());
        holder.getCardDesc().setText(cardDto.getCardDesc());
    }

}

