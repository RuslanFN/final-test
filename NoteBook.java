package FinalTest;

import java.util.HashMap;
import java.util.Map;

public class NoteBook {
    private String Name;
    private float price;
    private float Diagonal;
    private float RAM;
    private float HDD;
    private float SSD;
    private float CoresCount;
    private float frequency;
    private Map<Integer, Float>  fieldsParam = new HashMap<>();
    public NoteBook(String name, float price, float diagonal, float ram, float hdd, float ssd, float coresCount, float frequency) {
        Name = name;
        this.price = price;
        Diagonal = diagonal;
        RAM = ram;
        HDD = hdd;
        SSD = ssd;
        CoresCount = coresCount;
        this.frequency = frequency;
        fieldsParam.put(1, price);
        fieldsParam.put(2, diagonal);
        fieldsParam.put(3, ram);
        fieldsParam.put(4, hdd);
        fieldsParam.put(5, ssd);
        fieldsParam.put(6, coresCount);
        fieldsParam.put(7, frequency);

    }
    public NoteBook(String name, float price, float diagonal, float ram, float hdd, float ssd, CPU cpu){
        Name = name;
        this.price = price;
        Diagonal = diagonal;
        RAM = ram;
        HDD = hdd;
        SSD = ssd;
        CoresCount = cpu.getCoresCount();
        this.frequency = cpu.getFreqency();
        fieldsParam.put(1, price);
        fieldsParam.put(2, diagonal);
        fieldsParam.put(3, ram);
        fieldsParam.put(4, hdd);
        fieldsParam.put(5, ssd);
        fieldsParam.put(6, (float) cpu.getCoresCount());
        fieldsParam.put(7, cpu.getFreqency());
    }
    public float getParam(int param){
        return fieldsParam.get(param);
    }
    public NoteBook(String name, float diagonal, float ram, float hdd, float ssd, CPU cpu) {this(name,0, diagonal, ram,
            hdd, ssd, cpu);}
    public NoteBook(String name, float diagonal, float ram, float hdd, float ssd, float coresCount, float frequency) {this(name, 0, diagonal, ram,
            hdd, ssd, coresCount, frequency);}

    public String toString() {
        return Name + Float.toString(price) + Float.toString(Diagonal);
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiagonal() {
        return Diagonal;
    }

    public float getRAM() {
        return RAM;
    }

    public float getHDD() {
        return HDD;
    }

    public float getSSD() {
        return SSD;
    }

    public float getFrequency() {
        return frequency;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getCoresCount() {
        return CoresCount;
    }

}
