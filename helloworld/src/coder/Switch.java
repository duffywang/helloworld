package coder;

/**
 * @auther : wangyufei
 * @date : 2020-12-04
 **/
public class Switch {

    private Switchable switchable;

    public Switch(Switchable switchable) {
        this.switchable = switchable;
    }

    public void press() {
        if (switchable.isOn()) {
            switchable.turnOff();
        } else {
            switchable.turnOn();
        }
    }
}
