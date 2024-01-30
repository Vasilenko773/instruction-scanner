package mr.green.prodiction;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {


    @SneakyThrows
    public List<File> getFilesFrom(Path path) {
        List<File> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(path)) {
            files = paths
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .toList();
        }
        return files;
    }
}
