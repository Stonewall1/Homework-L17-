package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FolderReadingAndProcessing {
    public void readingAndProcessing(){
        // C:\Users\User\IdeaProjects\Homework17\TextFilesFolder
        try( DirectoryStream<Path> listOfFiles = Files.newDirectoryStream(Path.of(Input.getInputPathToFolder())) ){

            Map<String , Document> resume = new HashMap<>();

           List<String> list = listFill(listOfFiles);
            int validFiles = 0;
            int invalidFiles = 0;
            int filesToProcess = Input.getInputDocsQuantity();

            if(filesToProcess <= 0){
                System.out.println(ProcessExceptions.getBelowZero());
            }
            else if(list.size() == 0){
                System.out.println(ProcessExceptions.getNoFiles());
            }
            else{
                for (int i = 0; i < Math.min(list.size() , filesToProcess); i++) {
                    if(list.get(i).matches(".+\\.txt\\b")){
                        System.out.println(list.get(i));
                        validFiles++;

                        String fileInn = Files.readString(Path.of(list.get(i)));
                        System.out.println(fileInn);

                    }
                    else {
                        System.out.println(list.get(i) + ProcessExceptions.getWrongFormat());
                        invalidFiles++;
                    }
                }
                System.out.println("Valid files : " + validFiles);
                System.out.println("Invalid files : " + invalidFiles);
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }
    private List<String> listFill(DirectoryStream<Path> listOfFiles){
        List<String> list = new ArrayList<>();
        for(Path path : listOfFiles){
            list.add(path.toString());
        }
        return list;
    }
}
