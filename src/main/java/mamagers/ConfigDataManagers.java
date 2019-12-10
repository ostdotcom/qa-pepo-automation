package mamagers;

import constants.Constant;
import com.google.gson.Gson;
import javafx.application.Platform;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConfigDataManagers {

    public static final ConfigDataManagers data=loadData();

    /**
     * This function will return the config_data.json file as Java object.
     * @return
     */
    private static ConfigDataManagers loadData()  {

        try {
            return new Gson().fromJson(new FileReader(Constant.DATAFILEPATH.CONFIGDATAFILEPATH),ConfigDataManagers.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ConfigDataManagers();
        }
    }


    public String platformName;
    public String userDevice;

    public  AndroidManager android;
    public  IosManager ios;


    public static PlatformOs platformOs = getPlatformObject();

    private static PlatformOs getPlatformObject() {

        if(ConfigDataManagers.data.platformName.equalsIgnoreCase(Constant.ANDROID))
        {
            return ConfigDataManagers.data.android;
        }
        else if(ConfigDataManagers.data.platformName.equalsIgnoreCase(Constant.ios))
        {
            return ConfigDataManagers.data.ios;
        }
        else {
            throw new RuntimeException("Not Expected");
        }
    }
}
