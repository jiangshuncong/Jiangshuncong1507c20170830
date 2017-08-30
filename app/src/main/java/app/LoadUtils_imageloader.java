package app;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * Created by 蒋順聪 on 2017/8/30.
 */

public class LoadUtils_imageloader extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //xutils
        initview();

        //ImageLoader
        initloader();
    }

    private void initloader() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(options)
                .build();

        ImageLoader.getInstance().init(configuration);

    }

    private void initview() {
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
