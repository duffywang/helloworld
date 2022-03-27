package loadBalance;

import java.util.List;
import java.util.Random;

/**
 * @auther : wangyufei
 * @date : 2020-11-26
 **/
public class weighted {
    public String doSelect(List<ServerConn> serverList) {
        Random random = new Random();

        int len = serverList.size();
        if (len == 1) return serverList.get(0).getIp();
        double[] weightAccumulate = new double[len];
        int totalWeight = 0;
        boolean sameWeight = true;
        double lastWeight = -1;
        for (int i = 0; i < len; i++) {

            totalWeight += serverList.get(i).getWeight();
            weightAccumulate[i] = totalWeight;

            if (sameWeight && i > 0 && Double.compare(serverList.get(i).getWeight(), lastWeight) != 0) {
                sameWeight = false;
            }
            lastWeight = serverList.get(i).getWeight();
        }

        if (!sameWeight && Double.compare(totalWeight, 0) > 0) {
            double offset = random.nextDouble() * totalWeight;
            for (int i = 0; i < len; i++) {
                if (Double.compare(offset, weightAccumulate[i]) > 0) {
                    return serverList.get(i).getIp();
                }
            }
        }
        return serverList.get(random.nextInt(len)).getIp();


    }


}
