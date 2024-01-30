package mr.green.prodiction;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionCounterTest {


    @Test
    void ifDirEmptyCountInstructionIsNull() {
        FileReader reader =  new FileReader();
        InstructionCounter counter = new InstructionCounter();
        Path empty = new File("C:\\projects\\instruction-scanner\\src\\main\\resources\\static").toPath();

        List<File> files = reader.getFilesFrom(empty);
        Integer count = counter.getCountInstructionsFrom(files);

        assertThat(count).isZero();
    }

    @Test
    void ifFileContainsSevenInstructionCountEqualsSeven() {
        FileReader reader =  new FileReader();
        InstructionCounter counter = new InstructionCounter();
        Path empty = new File("C:\\projects\\instruction-scanner\\src\\test\\resources").toPath();

        List<File> files = reader.getFilesFrom(empty);
        Integer count = counter.getCountInstructionsFrom(files);

        assertThat(count).isEqualTo(7);
    }
}