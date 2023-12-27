package FinalTest;

public class CPU {
    private String name;
    private int coresCount;
    private  float Freqency;

    public CPU(String name, int coresCount, float freqency) {
        this.name = name;
        this.coresCount = coresCount;
        Freqency = freqency;
    }

    public String getName() {
        return name;
    }

    public int getCoresCount() {
        return coresCount;
    }

    public float getFreqency() {
        return Freqency;
    }
}
