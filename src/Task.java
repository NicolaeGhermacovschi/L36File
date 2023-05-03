import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task {
    public void createFile() {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addTextFile(String text) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void task2() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(new File("filename.txt"))) {
            int content;
            while ((content = fis.read()) != -1) {
                stringBuilder.append((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = stringBuilder.toString();
        System.out.println(s);
    }

    public void task3(){
        try (ObjectInputStream objectStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("filename.txt")))) {
            System.out.println(objectStream.readObject());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public  List<String> task4(File source) throws IOException {
        List<String> data = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String s;
            while((s = reader.readLine()) != null ) {
                data.add(s);
            }
        }
        return data;
    }

    public void task6(List<String> list){
        try (FileOutputStream fos = new FileOutputStream("newfile.txt")) {

            for ( String text : list) {
                byte[] mybytes = text.toUpperCase().getBytes();
                fos.write(mybytes);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
