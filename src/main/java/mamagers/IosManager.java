package mamagers;

import java.util.List;

public class IosManager implements PlatformOs{

    public String getAutomationName() {
        return automationName;
    }

    public String getApp() {
        return app;
    }

    @Override
    public DevicesManagers getdevice() {

        DevicesManagers devicesManagers = null;
        int arraySize = ConfigDataManagers.data.ios.devices.size();

        // Assigning token economy of matching with given Symbol

        for(int i = 0; i < arraySize; i++)
        {
            if(ConfigDataManagers.data.ios.devices.get(i).userDevice.equalsIgnoreCase(ConfigDataManagers.data.userDevice))
            {
                devicesManagers = ConfigDataManagers.data.ios.devices.get(i);
                break;
            }
        }
        return devicesManagers;
    }

    public List<DevicesManagers> getDevices() {
        return devices;
    }

    public String automationName;
    public String app;
    public List<DevicesManagers> devices;
}
