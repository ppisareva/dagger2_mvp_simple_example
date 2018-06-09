package hinapolina.com.dagger2mvp.Utils;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by polina on 4/15/18.
 */

public class DiskIOThreadExecutor implements Executor {

    private final Executor mDiskIO;


    public DiskIOThreadExecutor() {
        mDiskIO = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mDiskIO.execute(command);
    }
}