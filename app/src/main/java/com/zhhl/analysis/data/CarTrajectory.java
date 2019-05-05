package com.zhhl.analysis.data;


import androidx.annotation.NonNull;

import static com.zhhl.analysis.utils.DateUtil.parseDate;

/**
 * Created by miao on 2018/10/10.
 */
public class CarTrajectory implements Comparable<CarTrajectory> {
    private int type = 0;
    private long time;

    private CarTrajectoryBayonet.ObjBean bayonet;

    public CarTrajectory() {
    }

    public CarTrajectory(CarTrajectoryBayonet.ObjBean bayonet) {
        setData(bayonet);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public CarTrajectoryBayonet.ObjBean getBayonet() {
        return bayonet;
    }

    private void setData(CarTrajectoryBayonet.ObjBean o) {
        bayonet = o;
        String csrq = bayonet.getJgsj();
        time = parseDate("yyyy-MM-dd HH:mm:ss", csrq);
        type = 1;

    }

    @Override
    public int compareTo(@NonNull CarTrajectory o) {
        if (this.time - o.time < 0) return 1;
        else if (this.time - o.time > 0) return -1;
        else return 0;
    }
}
