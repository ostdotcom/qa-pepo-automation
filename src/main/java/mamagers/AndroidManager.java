package mamagers;

import javafx.application.Platform;

import java.util.List;

public class AndroidManager implements PlatformOs {

    public String automationName;
    public String app;
    public List<DevicesManagers> devices;

    @Override
    public String getAutomationName() {
        return automationName;
    }

    @Override
    public String getApp() {
        return app;
    }

    @Override
    public DevicesManagers getdevice() {

        DevicesManagers devicesManagers = null;
        int arraySize = ConfigDataManagers.data.android.devices.size();

        // Assigning token economy of matching with given Symbol

        for(int i = 0; i < arraySize; i++)
        {
            if(ConfigDataManagers.data.android.devices.get(i).userDevice.equalsIgnoreCase(ConfigDataManagers.data.userDevice))
            {
                devicesManagers = ConfigDataManagers.data.android.devices.get(i);
                break;
            }
        }
        return devicesManagers;
    }

}
