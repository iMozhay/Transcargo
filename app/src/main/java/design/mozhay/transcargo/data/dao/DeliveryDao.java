package design.mozhay.transcargo.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import design.mozhay.transcargo.data.entity.Delivery;
import io.reactivex.Flowable;

@Dao
public interface DeliveryDao {

    @Query("SELECT * FROM delivery")
    Flowable<List<Delivery>> getAllDeliveries();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Delivery delivery);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Delivery delivery);

    @Delete
    void delete(Delivery delivery);

}
