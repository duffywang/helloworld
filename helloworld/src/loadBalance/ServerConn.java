package loadBalance;

/**
 * @auther : wangyufei
 * @date : 2020-11-26
 **/
public class ServerConn {

    private double weight;
    private String ip;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
