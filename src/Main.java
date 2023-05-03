import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Task task = new Task();
        task.createFile();
        task.addTextFile("Hello word !!!");
        task.task2();
        task.task3();
        List<String> list;
        list = task.task4(new File("filename.txt"));
        for (String element : list) {
            System.out.println(element.toUpperCase());
        }

        task.task6(list);


    }
}