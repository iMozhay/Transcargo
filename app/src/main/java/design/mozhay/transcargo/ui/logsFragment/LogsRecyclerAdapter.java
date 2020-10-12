package design.mozhay.transcargo.ui.logsFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import design.mozhay.transcargo.data.entity.model.LogMessage;
import design.mozhay.transcargo.databinding.CardviewLogStringBinding;

public class LogsRecyclerAdapter extends RecyclerView.Adapter {

    private List<LogMessage> mLogs = new ArrayList<>();
    private CardviewLogStringBinding mLogBinding;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mLogBinding = CardviewLogStringBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LogsViewHolder(mLogBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof LogsViewHolder){
            ((LogsViewHolder) holder).setPosition(position);
            ((LogsViewHolder) holder).bind(mLogs.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return mLogs.size();
    }

    public class LogsViewHolder extends RecyclerView.ViewHolder{

        private int mPosition;

        public LogsViewHolder(@NonNull CardviewLogStringBinding logBinding) {
            super(logBinding.getRoot());
        }

        public void setPosition(int position){
            mPosition = position;
        }

        public void bind(LogMessage message){
            mLogBinding.cardviewLogStringTime.setText(message.getLogTime());
            mLogBinding.cardviewLogStringMessage.setText(message.getLogMessage());
        }
    }

    public void addLogMessage(String time, String message){
        LogMessage logMessage = new LogMessage();
        logMessage.setLogTime(time);
        logMessage.setLogMessage(message);
        mLogs.add(logMessage);
        notifyDataSetChanged();
    }
}
