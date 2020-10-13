package design.mozhay.transcargo.data.service.logs;

import design.mozhay.transcargo.ui.logsFragment.LogsFragment;

public interface LogsRepository {

    void showMessage(String time, String message);

    void setLogFragment(LogsFragment logFragment);
}
