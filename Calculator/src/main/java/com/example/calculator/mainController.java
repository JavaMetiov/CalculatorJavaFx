package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class mainController {

    public double intAnswer;
    public double currentNumber;
    public double memoryNumber;
    public boolean isOperator = true;
    public boolean isNum = true;
    String value = "+";

    DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
    String pattern = "#.######";
    NumberFormat numberFormat = new DecimalFormat(pattern, otherSymbols);



    public void operator(double firstNum, double secondNum, String value) {
        switch (value) {
            case "^" -> {
                firstNum = Math.pow(firstNum, secondNum);
                textField.setText(String.valueOf(numberFormat.format(firstNum)));
                try {
                    intAnswer = Double.parseDouble(textField.getText());
                } catch (NumberFormatException e) {
                    System.err.println("The value range is exceeded");
                }
                isOperator = false;
            }
            case "sqrt" -> {
                firstNum = Double.parseDouble(textField.getText());
                firstNum = firstNum * 0.25;
                textField.setText(String.valueOf(numberFormat.format(firstNum)));
                intAnswer = Double.parseDouble(textField.getText());
                isOperator = false;
            }
            case "%" -> {
                firstNum = firstNum % secondNum;
                textField.setText(String.valueOf(numberFormat.format(firstNum)));
                intAnswer = Double.parseDouble(textField.getText());
                isOperator = false;
            }
            case "*" -> {
                firstNum = firstNum * secondNum;
                textField.setText(String.valueOf(numberFormat.format(firstNum)));
                intAnswer = Double.parseDouble(textField.getText());
                isOperator = false;
            }
            case "/" -> {
                if (secondNum != 0) {
                    firstNum = firstNum / secondNum;
                } else {
                    firstNum = 0;
                }
                textField.setText(String.valueOf(numberFormat.format(firstNum)));
                intAnswer = Double.parseDouble(textField.getText());
                isOperator = false;
            }
            case "+" -> {
                firstNum = firstNum + secondNum;
                textField.setText(String.valueOf(numberFormat.format(firstNum)));
                intAnswer = Double.parseDouble(textField.getText());
                isOperator = false;
            }
            case "-" -> {
                firstNum = firstNum - secondNum;
                textField.setText(String.valueOf(numberFormat.format(firstNum)));
                intAnswer = Double.parseDouble(textField.getText());
                isOperator = false;
            }
            case "=" -> {
                textField.setText(String.valueOf(numberFormat.format(firstNum)));
                intAnswer = Double.parseDouble(textField.getText());
                isOperator = false;
            }
            default -> System.err.println("Unexpected error");
        }
    }

    @FXML
    void equalsCol() {
        if(isOperator)
            operator(intAnswer, currentNumber, value);
        value = "=";
        isNum = true;
    }

    @FXML
    void plusCol() {
        if(isOperator)
            operator(intAnswer, currentNumber, value);
        value = "+";
        isNum = true;
    }

    @FXML
    void minusCol() {
        if(isOperator)
            operator(intAnswer, currentNumber, value);
        value = "-";
        isNum = true;
    }

    @FXML
    void eightCol() {
        if(isNum) {
            textField.setText("0");
        }

        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "8";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "8";
            textField.setText(column);
        } else {
            column = "8";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }



    @FXML
    private TextField textField;

    @FXML
    void acCol() {
        textField.setText("0");
        intAnswer = 0;
        currentNumber = 0;
        isOperator = true;
        isNum = true;
        value = "+";
        memoryNumber = 0;
    }

    @FXML
    void backspaceCol() {
        String column;
        column = textField.getText();
        column = column.substring(0, column.length() - 1);
        if(!column.isEmpty())
        {
            if(!isOperator) {
                textField.setText(column);
                intAnswer = Double.parseDouble(column);
            } else {
                textField.setText(column);
                currentNumber = Double.parseDouble(column);
            }
        } else if (!isOperator) {
            textField.setText("0");
            intAnswer = 0;
        } else {
            textField.setText("0");
            currentNumber = 0;
        }
    }

    @FXML
    void cCol() {
        textField.setText("0");
        intAnswer = 0;
        currentNumber = 0;
        isOperator = true;
        isNum = true;
        value = "+";
    }

    @FXML
    void divideCol() {
        if(isOperator)
            operator(intAnswer, currentNumber, value);
        value = "/";
        isNum = true;
    }




    @FXML
    void fiveCol() {
        if(isNum) {
            textField.setText("0");
        }

        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "5";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "5";
            textField.setText(column);
        } else {
            column = "5";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }

    @FXML
    void fourCol() {
        if(isNum) {
            textField.setText("0");
        }

        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "4";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "4";
            textField.setText(column);
        } else {
            column = "4";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }

    @FXML
    void mcCol() {
    memoryNumber = 0;
    }



    @FXML
    void mrCol() {

        if (!isOperator && value.equals("=")) {
            textField.setText(String.valueOf(numberFormat.format(memoryNumber)));
            currentNumber = memoryNumber;
            if(currentNumber!=intAnswer)
            intAnswer = memoryNumber;
        } else {
            textField.setText(String.valueOf(numberFormat.format(memoryNumber)));
            currentNumber = memoryNumber;
        }
        isOperator = true;
    }

    @FXML
    void msCol() {
        memoryNumber = Double.parseDouble(textField.getText());
    }

    @FXML
    void multiplyCol() {
        if(isOperator)
            operator(intAnswer, currentNumber, value);
        value = "*";
        isNum = true;
    }

    @FXML
    void nineCol() {
        if(isNum) {
            textField.setText("0");
        }

        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "9";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "9";
            textField.setText(column);
        } else {
            column = "9";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }

    @FXML
    void oneCol() {
        if(isNum) {
            textField.setText("0");
        }
        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "1";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "1";
            textField.setText(column);
        } else {
            column = "1";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }

    @FXML
    void sevenCol() {
        if(isNum) {
            textField.setText("0");
        }
        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "7";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "7";
            textField.setText(column);
        } else {
            column = "7";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }

    @FXML
    void sixCol() {
        if(isNum) {
            textField.setText("0");
        }
        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "6";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "6";
            textField.setText(column);
        } else {
            column = "6";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }

    @FXML
    void squareRootCol() {
        value = "sqrt";
        operator(intAnswer, currentNumber, value);
        isNum = true;
    }

    @FXML
    void theRemainderOfTheDivisionCol() {
        if(isOperator)
            operator(intAnswer, currentNumber, value);
        value = "%";
        isNum = true;
    }

    @FXML
    void threeCol() {
        if(isNum) {
            textField.setText("0");
        }

        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "3";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "3";
            textField.setText(column);
        } else {
            column = "3";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }

    @FXML
    void twoCol() {
        if(isNum) {
            textField.setText("0");
        }

        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "2";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "2";
            textField.setText(column);
        } else {
            column = "2";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }


    @FXML
    void xToPowerYCol() {
        if(isOperator)
            operator(intAnswer, currentNumber, value);
        value = "^";
        isNum = true;
    }

    @FXML
    void zeroCol() {
        if(isNum) {
            textField.setText("0");
        }
        double isNull;
        String column;
        isNull = Double.parseDouble(textField.getText());
        if (isNull != 0) {
            column = textField.getText();
            column = column + "0";
            textField.setText(column);
        } else if (textField.getText().contains(".")) {
            column = textField.getText();
            column = column + "0";
            textField.setText(column);
        } else {
            column = "0";
            textField.setText(column);
        }
        if(!isOperator && value.equals("=")) {
            intAnswer = Double.parseDouble(column);
        } else {
            currentNumber = Double.parseDouble(column);
        }
        isOperator = true;
        isNum = false;
    }

    @FXML
    void pointCol() {
        if (!textField.getText().contains(".")) {
            if (isNum) {
                textField.setText("0");
            }
            String column;

            column = textField.getText();
            column = column + ".";
            textField.setText(column);


            if(!isOperator && value.equals("=")) {
                intAnswer = Double.parseDouble(column);
            } else {
                currentNumber = Double.parseDouble(column);
            }
            isOperator = true;
            isNum = false;
        }
    }
}


