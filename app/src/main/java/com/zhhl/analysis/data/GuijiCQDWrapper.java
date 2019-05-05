package com.zhhl.analysis.data;

public class GuijiCQDWrapper implements Comparable<GuijiCQDWrapper> {
    public String ldmc;
    public String tj;

    @Override
    public int compareTo(GuijiCQDWrapper o) {
        return Integer.compare(this.toIntTimes(), o.toIntTimes());
    }

    private int toIntTimes() {
        return -Integer.parseInt(tj);
    }
}