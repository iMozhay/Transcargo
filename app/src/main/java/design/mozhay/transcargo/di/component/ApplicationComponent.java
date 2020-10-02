package design.mozhay.transcargo.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import design.mozhay.transcargo.App;
import design.mozhay.transcargo.data.database.DeliveryDatabase;
import design.mozhay.transcargo.data.entity.rest.dellin.RestApiDellin;
import design.mozhay.transcargo.di.module.ApplicationModule;
import design.mozhay.transcargo.di.module.DatabaseModule;
import design.mozhay.transcargo.di.module.DellinModule;
import design.mozhay.transcargo.di.module.GTDModule;

@Singleton
@Component(
        modules = { //подключенные модули компонента
                ApplicationModule.class,
                DatabaseModule.class,
                DellinModule.class,
                GTDModule.class
        }
)
public interface ApplicationComponent {

    Context getContext();
    DeliveryDatabase getDeliveryDB();
    RestApiDellin getRestApiDellin();

    static ApplicationComponent buildComponent(App app){
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(app))
                .databaseModule(new DatabaseModule(app))
                .dellinModule(new DellinModule())
                .gTDModule(new GTDModule())
                .build();
    }

    /**
     * Инекция зависимостей в application
     */
    void inject(App app);

}
