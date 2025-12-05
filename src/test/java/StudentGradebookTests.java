import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentGradebookTests {
    StudentGradebook gradebook;

    @BeforeEach
    public void setup() {
        String nome = "Mattia";
        gradebook = new StudentGradebook(nome);
    }


    @Test
    public void nomeVuotoanciaEccezioneTest() {
        String nome = "";
        assertThrows(IllegalArgumentException.class, () -> {StudentGradebook gradebook = new StudentGradebook (nome);});
    }

    @Test
    public void nomeNulloLancaEccezioneTest() {
        String nome = null;
        assertThrows(IllegalArgumentException.class, () -> {StudentGradebook gradebook = new StudentGradebook(nome);});
    }




}
