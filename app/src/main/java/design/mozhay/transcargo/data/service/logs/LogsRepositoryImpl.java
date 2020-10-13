package design.mozhay.transcargo.data.service.logs;

import design.mozhay.transcargo.ui.logsFragment.LogsFragment;

public class LogsRepositoryImpl implements LogsRepository {

    private LogsFragment mLogFragment;

    public LogsRepositoryImpl(){
    }

    @Override
    public void showMessage(String time, String message) {
        if (mLogFragment != null) {
            mLogFragment.setLogMessage(time, message);
        }
    }

    @Override
    public void setLogFragment(LogsFragment logFragment) {
        mLogFragment = logFragment;
    }
}
