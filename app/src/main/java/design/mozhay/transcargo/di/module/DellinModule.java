package design.mozhay.transcargo.di.module;

import android.app.Application;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import design.mozhay.transcargo.data.entity.rest.dellin.RestApiDellin;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DellinModule {

    public DellinModule(Application app){

    }

    @Singleton
    @Provides
    RestApiDellin getRestApiDellin(Retrofit retrofit){
        return retrofit.create(RestApiDellin.class);
    }

    @Singleton
    @Provides
    Retrofit getRetrofit(){
        return new Retrofit
                .Builder()
                .baseUrl("https://api.dellin.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


}
