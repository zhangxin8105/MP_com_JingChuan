
package com.jingchuan.kousuan;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KouSuan {
    private static final String TAG = TestRandomQuestion.class.getSimpleName();
    private static final Logger LOG = LoggerFactory.getLogger(TAG);
    private static final boolean DEBUG = false;

    private static final int NUMBER_MIN = 0;
    private static final int NUMBER_MAX = 20 + 1;

    private static final int QUESTIONS_MAX_COUNT_PER_DAY = 50;

    private ArrayList<RandomQuestion> list = new ArrayList<RandomQuestion>();
    private StringBuilder sb;

    public void make() {
        RandomQuestion randomQuestion = new RandomQuestionByOperatorTypeAndQuestionType(
                NUMBER_MIN,
                NUMBER_MAX,
                new OperatorType[] {
                        OperatorType.Add,
                        OperatorType.Subtract,
                },
                new QuestionType[] {
                        QuestionType._1Digit,
                        QuestionType._1DigitTo2Digit,
                        QuestionType._1DigitAnd2Digit,
                });

        sb = new StringBuilder();
        for (int i = 0; i < QUESTIONS_MAX_COUNT_PER_DAY; i++) {
            randomQuestion.make();
            list.add(randomQuestion);

            sb.append(String.format("(%02d)  ", i + 1))
                    .append(randomQuestion.toString())
                    .append("\r\n");
        }

        if (DEBUG) LOG.info("\r\n" + sb.toString());
    }

    public ArrayList<RandomQuestion> getList() {
        return list;
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}
