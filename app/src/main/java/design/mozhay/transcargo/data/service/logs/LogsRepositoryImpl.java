package design.mozhay.transcargo.data.service.logs;

import design.mozhay.transcargo.ui.logsFragment.LogsFragment;

public class LogsRepositoryImpl implements LogsRepository {

    private LogsFragment mLogFragment;

    public LogsRepositoryImpl(LogsFragment logsFragment){
        mLogFragment = logsFragment;
    }

    @Override
    public void showMessage(String time, String message) {
        mLogFragment.setLogMessage(time, message);
    }
}
