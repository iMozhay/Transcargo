package design.mozhay.transcargo.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import design.mozhay.transcargo.App;
import design.mozhay.transcargo.data.database.DeliveryDatabase;
import design.mozhay.transcargo.di.module.ApplicationModule;
import design.mozhay.transcargo.di.module.DatabaseModule;

@Singleton
@Component(
        modules = { //подключенные модули компонента
                ApplicationModule.class,
                DatabaseModule.class,
        }
)
public interface ApplicationComponent {

    Context getContext();
    DeliveryDatabase getDeliveryDB();

    static ApplicationComponent buildComponent(App app){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(app))
                .databaseModule(new DatabaseModule(app))
                .build();
    }

    /**
     * Инекция зависимостей в application
     */
    void inject(App app);

}
