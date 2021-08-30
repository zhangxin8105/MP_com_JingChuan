
package com.jingchuan.kousuan;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomQuestion {
    private static final String TAG = RandomQuestion.class.getSimpleName();
    private static final Logger LOG = LoggerFactory.getLogger(TAG);
    private static final boolean DEBUG = false;

    private final int min;
    private final int max;
    private Random mRandom = new Random();

    public int number1;
    public int number2;

    protected OperatorType[] operatorTypes = OperatorType.values();
    public OperatorType operatorType;

    public QuestionType questionType;
    public double result;

    public RandomQuestion(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void make() {
        number1 = randomNumber();
        number2 = randomNumber();

        int operatorTypeInt = mRandom.nextInt(operatorTypes.length);
        operatorType = operatorTypes[operatorTypeInt];

        adjustSubtractAndDivide();

        checkType();
    }

    private int randomNumber() {
        return mRandom.nextInt(max - min) + min;
    }

    public void adjustSubtractAndDivide() {
        if (DEBUG) {
            LOG.info("adjustSubtractAndDivide");
        }
        switch (operatorType) {
            case Add:
            case Multiply:
                break;
            case Subtract:
            case Divide:
                if (number1 < number2) {
                    int t = number1;
                    number1 = number2;
                    number2 = t;
                }
                break;
        }
        if (operatorType == OperatorType.Divide) {
            if (number2 == 0) {
                number2 = 1;
                return;
            }
            double result = number1 / number2;
            double floor = Math.floor(result);
            number1 = (int) (floor * number2);
        }
    }

    public void checkType() {
        if (DEBUG) {
            LOG.info("checkType");
        }
        result = 0;
        switch (operatorType) {
            case Add:
                result = number1 + number2;
                break;

            case Subtract:
                result = number1 - number2;
                break;

            case Multiply:
                result = number1 * number2;
                break;

            case Divide:
                result = number1 / number2;
                break;
        }

        if (0 <= number1 && number1 < 10
                && 0 <= number2 && number2 < 10
                && 0 <= result && result <= 10) {
            questionType = QuestionType._1Digit;
            return;
        }
        if (0 <= number1 && number1 < 10
                && 0 <= number2 && number2 < 10
                && 10 < result) {
            questionType = QuestionType._1DigitTo2Digit;
            return;
        }

        if (0 <= number1 && number1 < 10
                && 10 <= number2 && number2 < 100) {
            questionType = QuestionType._1DigitAnd2Digit;
            return;
        }
        if (0 <= number2 && number2 < 10
                && 10 <= number1 && number1 < 100) {
            questionType = QuestionType._1DigitAnd2Digit;
            return;
        }

        if (10 <= number2 && number2 < 100
                && 10 <= number2 && number2 < 100
                && 10 <= result && result <= 100) {
            questionType = QuestionType._2Digit;
            return;
        }
        if (10 <= number2 && number2 < 100
                && 10 <= number2 && number2 < 100
                && 100 < result) {
            questionType = QuestionType._2DigitTo3Digit;
            return;
        }

        questionType = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(number1).append(" ");

        switch (operatorType) {
            case Add:
                sb.append("+");
                break;

            case Subtract:
                sb.append("-");
                break;

            case Multiply:
                sb.append("×");
                break;

            case Divide:
                sb.append("÷");
                break;
        }
        sb.append(" ");
        sb.append(number2).append(" = ");

        return sb.toString();
    }
}
