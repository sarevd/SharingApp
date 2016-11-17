package codeo.com.sharingapp;

import android.content.pm.PackageManager;

/**
 * Created by Darko Sarev on 11/1/2016.
 */

public class Util {
    public static boolean isPackageInstalled(String packagename, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packagename, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
