package za.co.josiahthobejane.josipweb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

public class UserLocationData {

    @SerializedName("ip")
    @Expose
    private String ip;

    @SerializedName("location")
    @Expose
    public  Map<Object, String> userLocation = new HashMap<Object, String>();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Map<Object, String> getLocation() {
        return userLocation;
    }

    public void setLocation(HashMap<Object, String> userLocation) {
        this.userLocation = userLocation;
    }

}