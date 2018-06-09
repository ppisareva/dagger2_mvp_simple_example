package hinapolina.com.dagger2mvp.dagger_injections;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hinapolina.com.dagger2mvp.View.MainActivity;

@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = ItemModule.class)
    abstract MainActivity mainActivity();
}
