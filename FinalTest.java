package FinalTest;


import practic4.Printer;

import java.util.*;

public class FinalTest {
    public static Optional<NoteBook> getMaxParam(int param, Set<NoteBook> noteBookSet){
        Optional<NoteBook> max = noteBookSet.stream().max(new Comparator<>() {
            public int compare(NoteBook o1, NoteBook o2) {
                float oVal1 = o1.getParam(param);
                float oVal2 = o2.getParam(param);
                if (oVal1 > oVal2) {
                    return 1;
                } else if (oVal1 < oVal2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return max;
    }
    public static Optional<NoteBook> getMinParam(int param, Set<NoteBook> noteBookSet){
        Optional<NoteBook> min = noteBookSet.stream().min(new Comparator<>() {
            public int compare(NoteBook o1, NoteBook o2) {
                float oVal1 = o1.getParam(param);
                float oVal2 = o2.getParam(param);
                if (oVal1 > oVal2) {
                    return 1;
                } else if (oVal1 < oVal2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return min;
    }
    private static Map<Integer, String> categories = new HashMap<Integer, String>();
    public static Set<NoteBook> sortNoteBook(Set<NoteBook> noteBookSet, int param, float min, float max){
        Set<NoteBook> result = new HashSet<>();

        for (NoteBook noteBook: noteBookSet){
            if (noteBook.getParam(param) > min && noteBook.getParam(param) < max){ result.add(noteBook);}
        }
        return result;
    }
    public static Set<NoteBook> sortNoteBookUp(Set<NoteBook> noteBookSet, int param, float max){
        NoteBook minNote = getMinParam(param, noteBookSet).get();
        return sortNoteBook(noteBookSet, param, (int) minNote.getParam(param) - 1 , max);
    }
    public static Set<NoteBook> sortNoteBookBottom(Set<NoteBook> noteBookSet, int param, float min){
        NoteBook maxNote = getMaxParam(param, noteBookSet).get();
        return sortNoteBook(noteBookSet, param, min, (int) maxNote.getParam(param) + 1);
    }
    public static String ansUser(Scanner in){
        System.out.println("Введите параметры фильтрации в формате: ПАРАМЕТР ОТ ДО");
        System.out.println("1 " + categories.get(1));
        System.out.println("2 " + categories.get(2));
        System.out.println("3 " + categories.get(3));
        System.out.println("1 " + categories.get(4));
        System.out.println("5 " + categories.get(5));
        System.out.println("6 " + categories.get(6));
        System.out.println("7 " + categories.get(7));
        String input = in.nextLine();
        return input;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Set<NoteBook> noteBookSet = new HashSet<>();
        categories.put(1, "price");
        categories.put(2, "diagonal");
        categories.put(3, "ram");
        categories.put(4, "hdd");
        categories.put(5, "ssd");
        categories.put(6, "coresCount");
        categories.put(7, "frequency");
        noteBookSet.add(new NoteBook("Laptopus1", 100000, (float) 15.6, 16, 512, 1024, 8, (float) 1.4));
        noteBookSet.add(new NoteBook("Laptopus2", 120000, (float) 17, 16, 512, 1024, 8, (float) 1.4));
        noteBookSet.add(new NoteBook("Laptopus3", 110000, (float) 15.6, 16, 512, 1024, 8, (float) 1.4));
        noteBookSet.add(new NoteBook("Laptopus4", 105000, (float) 17, 16, 512, 1024, 8, (float) 1.4));
        noteBookSet.add(new NoteBook("Laptopus5", 100600, (float) 15.6, 16, 512, 1024, 8, (float) 1.4));

        String input = ansUser(in);
        int param;
        float min;
        float max;
        Set<NoteBook> noteBookSetTemp = new HashSet<>(noteBookSet);
        while (!input.toLowerCase().equals("cтоп")){
            if (input.toLowerCase().equals("исходный")){
                noteBookSetTemp = new HashSet<>(noteBookSet);
                System.out.println(noteBookSetTemp);
            }
            try {
                String[] inputSplit = input.split(" ");
                param = Integer.parseInt(inputSplit[0]);
                min = Float.parseFloat(inputSplit[1]);
                max = Float.parseFloat(inputSplit[2]);
                noteBookSetTemp = sortNoteBook(noteBookSetTemp, param, min, max);
                System.out.println(noteBookSetTemp);

            }catch (Exception e){
                System.out.println("Вы ввели некорректное значение");
            }
            input = ansUser(in);
        }


    }
}
