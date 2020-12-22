package town.biscuit.ondesismique;

public class Preset {
    public String name;
    public long[] timings;
    public int repeat;

    Preset(String name, long[] timings, int repeat) {
        this.name = name;
        this.timings = timings;
        this.repeat = repeat;
    }
}
