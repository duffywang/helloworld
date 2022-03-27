package RPC;

/**
 * @auther : wangyufei
 * @date : 2020-11-23
 **/
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + "--> I am ok." : "I am ok";
    }
}
