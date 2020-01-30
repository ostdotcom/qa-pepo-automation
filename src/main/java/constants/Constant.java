package constants;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Constant {

    public static final String PROJECTPATH = System.getProperty("user.dir");
    public static final String ENVIRONMENT = System.getProperty("env",getEnvironment());
    public static final String USERDEVICE = System.getProperty("device",getUserDevice());




    public static final String ANDROID = "android";
    public static final String ios = "ios";




    public static class DATAFILEPATH{

        public static final String CONFIGDATAFILEPATH = "config/config_data.json";
      //  public static final String USERTEMPDATAFILE = PROJECTPATH + java.io.File.separatorChar + "config"+ java.io.File.separatorChar+ "user_temp.json";

    }


    public static class CAPABILTIES{

        public static final String DEVICENAME = "deviceName";
        public static final String PLATFORMVERSION = "platformVersion";
        public static final String PLATFORMNAME = "platformName";
        public static final String AUTOMATIONNAME = "automationName";
        public static final String APP = "app";
        public static final String UDID = "udid";
    }


    private static String getEnvironment()  {
        String env = null;
        try {
            JsonObject jsonObject= new Gson().fromJson(new FileReader(DATAFILEPATH.CONFIGDATAFILEPATH),JsonObject.class);
            env = jsonObject.get("environment").getAsString();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return env;
    }

    private static String getUserDevice() {
        String env = null;
        try {
            JsonObject jsonObject= new Gson().fromJson(new FileReader(DATAFILEPATH.CONFIGDATAFILEPATH),JsonObject.class);
            env = jsonObject.get("userDevice").getAsString();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return env;
    }
}
