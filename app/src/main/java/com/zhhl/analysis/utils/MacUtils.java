package com.zhhl.analysis.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import androidx.annotation.NonNull;


/**
 * author : HLQ
 * e-mail : 925954424@qq.com
 * time   : 2018/01/17
 * desc   : 获取mac 兼容6.0获取 以及4g环境下获取失败
 * version: 1.0
 */
public class MacUtils {

    /**
     * 获取失败默认返回值
     */
    private static final String ERROR_MAC_STR = "02:00:00:00:00:00";

    // Wifi 管理器
    private static WifiManager mWifiManager;

    /*
     * 实例化WifiManager对象
     *
     * @param context 当前上下文对象
     * @return
     */
    private static WifiManager getInstant(Context context) {
        if (mWifiManager == null) {
            mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        }
        return mWifiManager;
    }

    /**
     * 开启wifi
     */
    public static void getStartWifiEnabled() {
        // 判断当前wifi状态是否为开启状态
        if (!mWifiManager.isWifiEnabled()) {
            // 打开wifi 有些设备需要授权
            mWifiManager.setWifiEnabled(true);
        }
    }

    /*
     * 获取手机设备MAC地址
     * MAC地址：物理地址、硬件地址，用来定义网络设备的位置
     * modify by heliquan at 2018年1月17日
     *
     * @param context
     * @return
     */
    public static String getMobileMAC(Context context) {
        mWifiManager = getInstant(context);
        // 如果当前设备系统大于等于6.0 使用下面的方法
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getAndroidHighVersionMac();
        } else { // 当前设备在6.0以下
            return getAndroidLowVersionMac(mWifiManager);
        }
    }

    /*
     * Android 6.0 设备兼容获取mac
     * 兼容原因：从Android 6.0之后，Android 移除了通过WiFi和蓝牙API来在应用程序中可编程的访问本地硬件标示符。
     * 现在WifiInfo.getMacAddress()和BluetoothAdapter.getAddress()方法都将返回：02:00:00:00:00:00
     *
     * @return
     */
    private static String getAndroidHighVersionMac() {
        String str = "";
        String macSerial = "";
        try {
            // 由于Android底层基于Linux系统 可以根据shell获取
            Process pp = Runtime.getRuntime().exec(
                    "cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (; null != str; ) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (macSerial == null || "".equals(macSerial)) {
            try {
                return loadFileAsString("/sys/class/net/eth0/address")
                        .toUpperCase().substring(0, 17);
            } catch (Exception e) {
                e.printStackTrace();
                macSerial = getAndroidVersion7MAC();
            }
        }
        return macSerial;
    }

    /*
     * Android 6.0 以下设备获取mac地址 获取失败默认返回：02:00:00:00:00:00
     *
     * @param wifiManager
     * @return
     */
    @NonNull
    private static String getAndroidLowVersionMac(WifiManager wifiManager) {
        try {
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            String mac = wifiInfo.getMacAddress();
            if (TextUtils.isEmpty(mac)) {
                return ERROR_MAC_STR;
            } else {
                return mac;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("mac", "get android low version mac error:" + e.getMessage());
            return ERROR_MAC_STR;
        }
    }

    /*
     * 兼容7.0获取不到的问题
     *
     * @return
     */
    private static String getAndroidVersion7MAC() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;
                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }
                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(String.format("%02X:", b));
                }
                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception e) {
            Log.e("mac", "get android version 7.0 mac error:" + e.getMessage());
        }
        return ERROR_MAC_STR;
    }

    private static String loadFileAsString(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        String text = loadReaderAsString(reader);
        reader.close();
        return text;
    }

    private static String loadReaderAsString(Reader reader) throws Exception {
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[4096];
        int readLength = reader.read(buffer);
        while (readLength >= 0) {
            builder.append(buffer, 0, readLength);
            readLength = reader.read(buffer);
        }
        return builder.toString();
    }


    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();

                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();

                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }


            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                return intIP2StringIP(wifiInfo.getIpAddress());
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }


    /**
     * * 将得到的int类型的IP转换为String类型
     * *
     * * @param ip
     * * @return
     */
    private static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." + (ip >> 24 & 0xFF);
    }

}