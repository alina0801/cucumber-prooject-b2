package practice;

public class Pencil {
    public String color;
    public static String brand = "Zebra";

    boolean hasEraser;

    public Pencil() {

    }

    public Pencil(String color) {
        this.color = color;

        // Pencil this = new Pencil();
        //this.color = color;
        //instance - local
    }


    public Pencil(String color, boolean hasEraser) {
        this(color);
        this.hasEraser = hasEraser;
    }

    @Override
    public String toString() {
        return "" +
                "color='" + color + '\'' +
                ", hasEraser=" + hasEraser +
                '}';
    }
}
