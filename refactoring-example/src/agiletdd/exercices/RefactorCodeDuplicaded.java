package agiletdd.exercices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RefactorCodeDuplicaded {


    public List getDirectorieNames(String path) {
        List directoryNames = new ArrayList<>();
        File pathFile = new File(path);

        if(!pathFile.exists())
            throw new RuntimeException("Directory not exits.");

        File[] files = pathFile.listFiles();

        for(File file : files){
            if(file.isDirectory()){
                directoryNames.add(file.getName());
            }
        }

        return directoryNames;
    }

    public List getDirectorieAbsolutePath(String pathName) {
        List allNames = new ArrayList<>();
        File rootFile = new File(pathName);

        if(!rootFile.exists())
            throw new RuntimeException("Directory not exits.");

        File[] allRootFiles = rootFile.listFiles();

        for(File fileNode : allRootFiles){
            if(fileNode.isDirectory()){
                allNames.add(fileNode.getAbsolutePath());
            }
        }

        return allNames;
    }

    public List getDirectorieCanonicalPath(String path) throws IOException {
        return getDirectories(path, (file) -> {
            try {
                return file.getCanonicalPath();
            } catch (IOException io) {
                io.printStackTrace();
            }
            return "";
        });
    }

    List<String> getDirectories(String path, Function<File, String> function) throws IOException {
        File pathFile = new File(path);

        if(!pathFile.exists()) {
            throw new RuntimeException("Directory not exits.");
        }

        return Arrays.stream(pathFile.listFiles())
                .filter(File::isDirectory)
                .map(function)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toList());
    }

}
