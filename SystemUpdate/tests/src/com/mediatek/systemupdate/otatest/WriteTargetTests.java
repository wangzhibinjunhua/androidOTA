package com.mediatek.systemupdate.otatest;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.test.AndroidTestCase;
import android.util.Log;

import java.util.List;


/**
 * Get Downloaded new version's package information and old version's package information. Include
 * package name, APK source directory, shared user ID. The new version's package information should
 * be pull to PC.
 *
 * @author mtk80800
 *
 */
public class WriteTargetTests extends AndroidTestCase {
    private static final String TAG = "SystemUpdate/WriteTargetTests";

    protected void setUp() throws Exception {
        mContext = getContext();
        super.setUp();
    }

    public void testWriteTargetPackageInfo() {
        PackageManager pm = mContext.getPackageManager();
        List<PackageInfo> packageInfoList = pm
                .getInstalledPackages(PackageManager.GET_SIGNATURES);
        Log.e(TAG, "package number is " + packageInfoList.size());
        Util.writePackageInfoToFile(mContext, Util.PACKAGE_INFO_TARGET_FILE, packageInfoList);
    }

}
