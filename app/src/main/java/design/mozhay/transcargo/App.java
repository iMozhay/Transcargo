package design.mozhay.transcargo;

import android.app.Application;

import design.mozhay.transcargo.data.database.DeliveryDatabase;
import design.mozhay.transcargo.data.entity.rest.dellin.RestApiDellin;
import design.mozhay.transcargo.di.component.ApplicationComponent;

public class App extends Application {

    private static ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = ApplicationComponent.buildComponent(this);
        mAppComponent.inject(this);
    }

    public static DeliveryDatabase getAppDeliveryDB(){
        return mAppComponent.getDeliveryDB();
    }

    public static RestApiDellin getRestApiDellin(){
        return mAppComponent.getRestApiDellin();
    }
}
