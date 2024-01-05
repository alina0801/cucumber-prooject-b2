package practice;

import java.util.Arrays;

public class UsePencil {
    public static void main(String[] args) {
        Pencil pencil1 = new Pencil();
        pencil1.color = "red";
        System.out.println(pencil1.color);

        Pencil pencil2 = new Pencil();
        pencil2.color = "green";
        System.out.println(pencil2.color);

        Pencil pencil3 = new Pencil("purple");
        System.out.println(pencil3.color);

        Pencil pencil4 = new Pencil("purple", true);
        System.out.println(pencil4.color + " " + pencil4.hasEraser + Pencil.brand);

        pencil4.brand = "Unknown";
        System.out.println(Pencil.brand);

        System.out.println(pencil1);

        Pencil [] pencils = {pencil1, pencil2, pencil3, pencil4};
        System.out.println(Arrays.toString(pencils));

        String [] colors = {pencil1.color, pencil2.color};
        System.out.println(Arrays.toString(colors));
    }

}
