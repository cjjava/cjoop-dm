package com.cjoop.dm;

import java.awt.HeadlessException;
import java.io.File;

public class Utils {
    static String osName = System.getProperty("os.name");
    static String osArch = System.getProperty("os.arch");
    static File dirTempWritable = null;
    
    public static boolean isWindows() {
        return osName != null && osName.toLowerCase().startsWith("windows");
    }

    
    public static boolean isMac() {
        return osName != null && osName.toLowerCase().startsWith("mac");
    }

    
    public static boolean is64Bit() {
        return osArch.contains("64");
    }

    
    public static boolean is32Bit() {
        return !is64Bit();
    }
    
    public static File getTempFolderWritable() {
        if(dirTempWritable != null) {
            return dirTempWritable;
        }

        File[] dirs = new File[] {
            new File(System.getProperty("java.io.tmpdir")), 
            new File(System.getProperty("user.dir")), 
            new File(Utils.isWindows() ?
                ((System.getProperty("java.io.tmpdir") != null && System.getProperty("java.io.tmpdir").length() > 0 ? System.getProperty("java.io.tmpdir").substring(0, 1) : "C") + ":\\") : "/") 
        };

        for(File dir : dirs) {
            if(testCreateFileInside(dir)) {
                dirTempWritable = dir;
                return dirTempWritable;
            }
        }

        StringBuilder errorMesg = new StringBuilder("Failed to find a writable temp directory. Tried: ");
        for(int i = 0; i < dirs.length; i++) {
            errorMesg.append(i == 0 ? "" : ", ");
            errorMesg.append(dirs[i].getAbsolutePath());
        }

        displayErrorDialogAndThrowException(errorMesg.toString(), null, true);
        return null;
    }
    
    public static void displayErrorDialogAndThrowException(String errorMesg, Throwable t, boolean rethrowException) {
        try {
            if(errorMesg != null && errorMesg.length() > 80) {
                errorMesg = errorMesg.replaceAll("(.{80})", "$1\n");
            }
            System.err.println(errorMesg);
        } catch (HeadlessException e) {
            e.printStackTrace();
        }
        if(rethrowException) {
            throw new RuntimeException(errorMesg, t);
        }
    }
    
    public static boolean testCreateFileInside(File folder) {
        if(! folder.exists()) { 
            try {
                folder.mkdirs();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(! folder.isDirectory()) {
            return false;
        }

        File f = new File(folder, "t-" + System.currentTimeMillis() + "-" + StringUtils.randomAlphanumeric(3));
        try {
            boolean fileCreated = f.createNewFile();
            f.delete();
            return fileCreated;
        } catch (Throwable t) {
            return false;
        }
    }
}
