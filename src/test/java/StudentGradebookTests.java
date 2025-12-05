import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;
import java.lang.classfile.constantpool.IntegerEntry;
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

    @ParameterizedTest
    @ValueSource (ints = {40, -1})
    public void votoNonValidoLanciaEccezioneTest(int voto){
        assertThrows(IllegalArgumentException.class, () -> {gradebook.addGrade(voto);});
    }





}
