package helloworld.src.coder;

/**
 * @auther : wangyufei
 * @date : 2020-12-04
 **/
public class Light extends coder.Switchable {

    private boolean light;

    public Light(boolean isOn) {
        this.light = false;
    }

    @Override
    public void turnOn() {
        light = true;
    }

    @Override
    public void turnOff() {
        light = false;
    }

    @Override
    public boolean isOn() {
        return light;
    }
}
