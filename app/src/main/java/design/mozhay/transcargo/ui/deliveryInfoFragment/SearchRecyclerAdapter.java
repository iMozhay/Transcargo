package design.mozhay.transcargo.ui.deliveryInfoFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import design.mozhay.transcargo.data.entity.model.SearchResult;
import design.mozhay.transcargo.databinding.CardviewSearchResultBinding;

public class SearchRecyclerAdapter extends RecyclerView.Adapter {

    private CardviewSearchResultBinding mSearchBinding;
    private List<SearchResult> mSearchList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mSearchBinding = CardviewSearchResultBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new SearchViewHolder(mSearchBinding.getRoot());

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof SearchViewHolder){
            ((SearchViewHolder) holder).setPosition(position);
            ((SearchViewHolder) holder).bind(mSearchList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder{

        private int mPosition;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setPosition(int position){
            mPosition = position;
        }

        public void bind(SearchResult result){
            mSearchBinding.searchCompanyName.setText(result.getCompanyName());
            mSearchBinding.searchCompanyPrice.setText(result.getCompanyPrice());
        }
    }
}
