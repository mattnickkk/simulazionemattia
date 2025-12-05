import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student's gradebook for a specific subject.
 * Allows adding grades (0-30) and calculating the average.
 * NOTE: Contains intentional bugs for educational purposes.
 */
public class StudentGradebook {

    private String studentName;
    private List<Integer> grades;

    public StudentGradebook(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        this.studentName = studentName;
        this.grades = new ArrayList<>();
    }

    /**
     * Adds a grade to the gradebook.
     * Valid grades are from 0 to 30.
     * @param grade The grade to add.
     */
    public void addGrade(int grade) {
        // BUG INTENZIONALE 1:
        // L'università accetta 30, ma qui la condizione è 'grade < 30'.
        // Se provi ad aggiungere 30, lancerà eccezione.
        if (grade < 0 || grade > 30) {
            throw new IllegalArgumentException("Grade must be between 0 and 30");
        }
        grades.add(grade);
    }

    /**
     * Calculates the average of the grades.
     * @return The average score, or 0.0 if no grades exist.
     */
    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }

        // BUG INTENZIONALE 2:
        // Divisione tra interi! Se somma=5 e size=2, restituisce 2.0 invece di 2.5
        return sum / grades.size();
    }

    /**
     * Returns true if the student has passed (average >= 18).
     */
    public boolean isPassed() {
        return calculateAverage() >= 18;
    }

    // BUG INTENZIONALE 3: Rompe l'incapsulamento restituendo la lista originale
    public List<Integer> getGrades() {
        return grades;
    }
}