import org.example.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.JOptionPane;
import org.example.JOptionPaneTestHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class MainTest {
    private Main.CalculatorGUI calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Main.CalculatorGUI();
    }

    @Test
    public void testAddition() {
        calculator.numberButtons[2].doClick(); // Click the "2" button
        calculator.operatorButtons[0].doClick(); // Click the "+" button
        calculator.numberButtons[3].doClick(); // Click the "3" button
        calculator.equalsButton.doClick(); // Click the "=" button

        assertEquals("5.0", calculator.textField.getText());
    }

    @Test
    public void testSubtraction() {
        calculator.numberButtons[7].doClick(); // Click the "7" button
        calculator.operatorButtons[1].doClick(); // Click the "-" button
        calculator.numberButtons[4].doClick(); // Click the "4" button
        calculator.equalsButton.doClick(); // Click the "=" button

        assertEquals("3.0", calculator.textField.getText());
    }

    @Test
    public void testMultiplication() {
        calculator.numberButtons[5].doClick(); // Click the "5" button
        calculator.operatorButtons[2].doClick(); // Click the "*" button
        calculator.numberButtons[6].doClick(); // Click the "6" button
        calculator.equalsButton.doClick(); // Click the "=" button

        assertEquals("30.0", calculator.textField.getText());
    }

    @Test
    public void testDivision() {
        calculator.numberButtons[9].doClick(); // Click the "9" button
        calculator.operatorButtons[3].doClick(); // Click the "/" button
        calculator.numberButtons[3].doClick(); // Click the "3" button
        calculator.equalsButton.doClick(); // Click the "=" button

        assertEquals("3.0", calculator.textField.getText());
    }

    @Test
    public void testDivisionByZero() {
        calculator.numberButtons[5].doClick(); // Click the "5" button
        calculator.operatorButtons[3].doClick(); // Click the "/" button
        calculator.numberButtons[0].doClick(); // Click the "0" button
        calculator.equalsButton.doClick(); // Click the "=" button

        assertEquals(null, JOptionPaneTestHelper.showMessageDialogCalledWith());
    }

    @Test
    public void testDeleteButton() {
        calculator.numberButtons[1].doClick(); // Click the "1" button
        calculator.numberButtons[2].doClick(); // Click the "2" button
        calculator.numberButtons[3].doClick(); // Click the "3" button
        calculator.deleteButton.doClick(); // Click the "DEL" button

        assertEquals("12", calculator.textField.getText());
    }

    @Test
    public void testClearButton() {
        calculator.numberButtons[4].doClick(); // Click the "4" button
        calculator.numberButtons[5].doClick(); // Click the "5" button
        calculator.operatorButtons[0].doClick(); // Click the "+" button
        calculator.numberButtons[6].doClick(); // Click the "6" button
        calculator.clearButton.doClick(); // Click the "C" button

        assertEquals("", calculator.textField.getText());
    }
}
