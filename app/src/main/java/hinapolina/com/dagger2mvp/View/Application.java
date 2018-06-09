package hinapolina.com.dagger2mvp.View;

import com.orm.SugarContext;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import hinapolina.com.dagger2mvp.Data.ItemRepository;
import hinapolina.com.dagger2mvp.dagger_injections.DaggerApplicationComponent;

public class Application extends DaggerApplication  {

    @Inject
    ItemRepository itemRepository;


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }

}
