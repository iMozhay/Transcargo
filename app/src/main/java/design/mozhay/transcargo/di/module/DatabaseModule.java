package design.mozhay.transcargo.di.module;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import design.mozhay.transcargo.data.database.DeliveryDatabase;

@Module
public class DatabaseModule{

    private DeliveryDatabase mDeliveryDB;

    public DatabaseModule(Context context){

        mDeliveryDB = Room
                .databaseBuilder(context, DeliveryDatabase.class, "delivery")
                .addMigrations(new Migration(1, 2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {

                    }
                })
                .build();
    }

    @Singleton
    @Provides
    DeliveryDatabase getAppDeliveryDB(){
        return mDeliveryDB;
    }
}
