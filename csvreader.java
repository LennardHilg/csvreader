import java.io.*;
import java.util.ArrayList;


public class csvreader {


    // method which reads and works with csv file, gives back an ArrayList with books. Uses quotation marks as delimiter first, then comma
    public static ArrayList<book> read (String csvFile) {
        ArrayList<book> list = new ArrayList<book>();
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            String[] tempArr;
            // consum first line and ignore
            br.readLine();
            // loop which stops reading after last line
            while((line = br.readLine()) != null) {
                // use quotation marks or comma as delimiter
                if (line.contains("\"")){
                    tempArr = splitWithQuotation(line);
                }else {
                    tempArr = line.split(",");
                }
                tempArr = replaceMissingData(tempArr);
                // in a correct csv file, at index 0 is title, at 1 author, at 2 genre, at 3 height, at 4 publisher always
                String title = tempArr[0];
                String author = tempArr[1];
                String genre = tempArr[2];
                int height = Integer.valueOf(tempArr[3]);
                String publisher = tempArr[4];
                // add new book to ArrayList 
                list.add(new book(title, author, genre, height, publisher));
            }
            br.close();
        } 
        catch(IOException ioe) {
            System.out.println(ioe);
        }

        return list;
    } 

    // method which handles quotation marks as delimiter
    private static String[] splitWithQuotation (String line){
        String[] tempArr = line.split("");
        String[] output = new String[5];
        int index = 0;
            for (int i = 0; i<tempArr.length; i++){
                output[index] = "";
                if (tempArr[i].equals("\"")){
                    i++;
                    while (!(tempArr[i].equals("\""))){
                        output[index] = output[index] + tempArr[i];
                        i++;
                    }
                    // next index is a comma always so we must skip it so next step of for loop works fine
                    i++;
                    index++;
                // no quotation mark for this part
                }else if (!(tempArr[i].equals("\""))){
                    if  (tempArr[i].equals(",")){
                        // this is to handle missing data which is given by ",," in csv file.
                        if (tempArr[i+1].equals(",")){
                            output[index] = "unknown";
                            i++;
                        }else if (tempArr[i-1].equals(",")){
                            output[index] = "unknown";
                        } else{
                            i++;
                        }
                    }
                    while (!(tempArr[i].equals(","))){
                        output[index] = output[index] + tempArr[i];
                        i++; 
                        if (i == tempArr.length){
                            break;
                        }
                    }
                    index++;
                }
            }
        return output;
    }

    // method which replace missing data with String "unknown" or 0 in case of missing height
    private static String[] replaceMissingData (String[] test){
        
        for (int i = 0; i < test.length; i++){
            if (test[i] == null){
                if (i == 3){
                    test[3] = "0";
                }else if (i != 3){
                    test[i] = "unknown";
                }
            }
        }
        return test;
    }
}