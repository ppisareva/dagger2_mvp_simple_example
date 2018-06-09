package hinapolina.com.dagger2mvp.dagger_injections;


import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import hinapolina.com.dagger2mvp.View.Application;
import hinapolina.com.dagger2mvp.Data.ItemRepository;

@Singleton
@Component(modules = {ItemRepositoryModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidInjectionModule.class})

public interface  ApplicationComponent extends AndroidInjector<Application>  {

    ItemRepository getTasksRepository();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        ApplicationComponent.Builder application(Application application);

        ApplicationComponent build();
    }
}
