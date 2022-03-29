package src.coder;

/**
 * @auther : wangyufei
 * @date : 2020-12-04
 **/
public class Switch {

    private coder.Switchable switchable;

    public Switch(coder.Switchable switchable) {
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
