package mr.green.prodiction;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {

    private final String first;
    protected String second;
    public String third;


    public methodContainsInstructions() {
        List<File> firsInstruction = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(path)) {
            secondInstruction = paths
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .toList();
        }
        if (firsInstruction.isEmpty()) {
            Integer thirdInstruction = 3;
            switch (thirdInstruction) {
                case : fourInstruction;
                case : fiveInstruction;
                default: sixInstruction;
            }
        }

        return sevenInstruction;
    }
}
