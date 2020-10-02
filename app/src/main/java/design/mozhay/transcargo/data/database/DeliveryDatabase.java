package design.mozhay.transcargo.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import design.mozhay.transcargo.data.dao.DeliveryDao;
import design.mozhay.transcargo.data.entity.model.Delivery;

@Database(entities = {Delivery.class}, version = 1, exportSchema = false)
public abstract class DeliveryDatabase extends RoomDatabase {

    public abstract DeliveryDao getDeliveryDao();

}