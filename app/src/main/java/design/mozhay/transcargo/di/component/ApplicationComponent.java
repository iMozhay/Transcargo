package design.mozhay.transcargo.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import design.mozhay.transcargo.App;
import design.mozhay.transcargo.data.database.DeliveryDatabase;
import design.mozhay.transcargo.data.entity.rest.dellin.RestApiDellin;
import design.mozhay.transcargo.data.service.logs.LogsRepository;
import design.mozhay.transcargo.di.module.ApplicationModule;
import design.mozhay.transcargo.di.module.DatabaseModule;
import design.mozhay.transcargo.di.module.DellinModule;
import design.mozhay.transcargo.di.module.GTDModule;
import design.mozhay.transcargo.di.module.LogsModule;

@Singleton
@Component(
        modules = { //подключенные модули компонента
                ApplicationModule.class,
                DatabaseModule.class,
                LogsModule.class,
                DellinModule.class,
                GTDModule.class
        }
)
public interface ApplicationComponent {

    Context getContext();
    DeliveryDatabase getDeliveryDB();
    RestApiDellin getRestApiDellin();
    LogsRepository getLogsRepo();

    static ApplicationComponent buildComponent(App app){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(app))
                .databaseModule(new DatabaseModule(app))
                .logsModule(new LogsModule())
                .dellinModule(new DellinModule(app))
                .gTDModule(new GTDModule())
                .build();
    }

    /**
     * Инекция зависимостей в application
     */
    void inject(App app);

}
