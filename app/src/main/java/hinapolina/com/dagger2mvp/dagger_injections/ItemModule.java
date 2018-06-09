package hinapolina.com.dagger2mvp.dagger_injections;

import dagger.Binds;
import dagger.Module;
import hinapolina.com.dagger2mvp.Presenter.ItemPresenter;
import hinapolina.com.dagger2mvp.Presenter.ItemsContract;

// This is a Dagger module. We use this to pass in the View dependency to the
// * ItemPresenter}.
@Module
public abstract class ItemModule {
    @Binds
    abstract ItemsContract.Presenter taskPresenter(ItemPresenter presenter);
}
