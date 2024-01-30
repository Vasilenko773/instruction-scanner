package mr.green.prodiction;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

@Log4j2
public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        Path pathToDir = Paths.get(
                "C:\\MTC\\sales-management\\apps\\rest-api\\src\\main\\java\\ru\\mts\\salesdriver\\admin");
        List<File> files = application.fileTo(pathToDir);
        Integer countInstructions = application.getCountInstructionsFrom(files);
        log.info("Path {}", pathToDir.toAbsolutePath());
        log.warn("Count instruction = {}", countInstructions);
    }


    @SneakyThrows
    private List<File> fileTo(Path path) {
        List<File> files = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(path)) {
            files = paths
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .toList();
        }
        return files;
    }

    private Integer getCountInstructionsFrom(List<File> files) {
        Integer instruction = 0;
        for (var file : files) {
            try {
                instruction = instructionFromFile(instruction, file);
            } catch (IOException e) {
                log.error("File + {} non read", file.getName());
                throw new NoSuchElementException();
            }
        }
        return instruction;
    }

    private Integer instructionFromFile(Integer instruction, File file) throws IOException {

        try (Stream<String> lines = Files.lines(file.toPath())) {
            List<String> fileData = lines.toList();
            for (var line : fileData) {
                if (isInstruction(line)) {
                    instruction++;
                }
            }
        }
        return instruction;
    }

    private boolean isInstruction(String line) {
        line = line.strip();
        return line.endsWith(";")
                &&
                (!line.startsWith("package")
                        && !line.startsWith("import")
                        && !line.startsWith("private")
                        && !line.startsWith("protected")
                        && !line.startsWith("public"));
    }
}
