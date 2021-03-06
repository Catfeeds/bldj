package com.bldj.lexiang.utils;

import android.content.Context;
import android.os.PowerManager;

/**
 * 
 * @author yongbo.zhu
 * 
 */
public class WakeLockUtils {
	
	private static PowerManager.WakeLock sCpuWakeLock;
	
	public static PowerManager.WakeLock createPartialWakeLock(Context context) {
		PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
		return pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "AlarmAlertWakeLock");
	}
	
	public static void acquireCpuWakeLock(Context context) {
		if (sCpuWakeLock != null) {
			return;
		}
		
		sCpuWakeLock = createPartialWakeLock(context);
		sCpuWakeLock.acquire();
	}
	
	public static void releaseCpuLock() {
		if (sCpuWakeLock != null) {
			sCpuWakeLock.release();
			sCpuWakeLock = null;
		}
	}
}
