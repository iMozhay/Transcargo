package design.mozhay.transcargo.di.module;

import android.app.Application;

import dagger.Module;
import design.mozhay.transcargo.data.service.logs.LogsRepository;
import design.mozhay.transcargo.data.service.logs.LogsRepositoryImpl;

@Module
public class LogsModule {

    private LogsRepository mLogsService;

    public LogsModule(Application app){
        //mLogsService =

    }

}
