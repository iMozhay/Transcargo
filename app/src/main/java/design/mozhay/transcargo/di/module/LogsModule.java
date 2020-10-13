package design.mozhay.transcargo.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import design.mozhay.transcargo.data.service.logs.LogsRepository;
import design.mozhay.transcargo.data.service.logs.LogsRepositoryImpl;

@Module
public class LogsModule {

    private LogsRepository mLogsService;

    public LogsModule(){
        mLogsService = new LogsRepositoryImpl();
    }

    @Singleton
    @Provides
    LogsRepository getLogsRepo(){
        return mLogsService;
    }
}
