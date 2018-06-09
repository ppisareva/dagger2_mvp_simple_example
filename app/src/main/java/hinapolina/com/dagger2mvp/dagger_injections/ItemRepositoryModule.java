package hinapolina.com.dagger2mvp.dagger_injections;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import hinapolina.com.dagger2mvp.Data.ItemDataSource;
import hinapolina.com.dagger2mvp.Data.ItemLocalDataSource;
import hinapolina.com.dagger2mvp.Data.ItemRemoteDataSource;
import hinapolina.com.dagger2mvp.Data.Local;
import hinapolina.com.dagger2mvp.Data.Remote;
import hinapolina.com.dagger2mvp.Utils.AppExecutors;
import hinapolina.com.dagger2mvp.Utils.DiskIOThreadExecutor;

@Module
public abstract class ItemRepositoryModule {
    private static final int THREAD_COUNT = 3;

    @Singleton
    @Binds
    @Local
    abstract ItemDataSource provideTasksLocalDataSource(ItemLocalDataSource dataSource);

    @Singleton
    @Binds
    @Remote
    abstract ItemDataSource provideTasksRemoteDataSource(ItemRemoteDataSource dataSource);
    

    @Singleton
    @Provides
    static AppExecutors provideAppExecutors() {
        return new AppExecutors(new DiskIOThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT),
                new AppExecutors.MainThreadExecutor());
    }
}
