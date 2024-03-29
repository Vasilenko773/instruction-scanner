package mr.green.prodiction;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Log4j2
public class Application {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        InstructionCounter counter = new InstructionCounter();
        Path pathToDir = Paths.get(
                "");

        List<File> files = fileReader.getFilesFrom(pathToDir);
        Integer instructions = counter.getCountInstructionsFrom(files);

        log.info("Path {}", pathToDir.toAbsolutePath());
        log.warn("Count files = {}", files.size());
        log.warn("Count instruction = {}", instructions);
    }
}
