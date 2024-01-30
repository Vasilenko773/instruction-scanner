package mr.green.prodiction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class InstructionCounter {


    public Integer getCountInstructionsFrom(List<File> files) {
        Integer instruction = 0;
        for (var file : files) {
            try {
                instruction = instructionFromFile(instruction, file);
            } catch (IOException e) {
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
