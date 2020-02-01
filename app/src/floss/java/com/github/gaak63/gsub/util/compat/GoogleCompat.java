package com.github.gaak63.gsub.util.compat;

import android.content.Context;
import android.support.v7.media.MediaRouter;

import com.github.gaak63.gsub.service.DownloadService;
import com.github.gaak63.gsub.service.RemoteController;


// Provides stubs for Google-related functionality
public final class GoogleCompat {

    public static boolean playServicesAvailable(Context context) {
        return false;
    }

    public static void installProvider(Context context) throws Exception {
    }

    public static boolean castAvailable() {
        return false;
    }

    public static RemoteController getController(DownloadService downloadService, MediaRouter.RouteInfo info) {
        return null;
    }

    public static String getCastControlCategory() {
        return null;
    }
}
