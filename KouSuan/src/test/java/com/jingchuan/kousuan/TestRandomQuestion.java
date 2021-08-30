
package com.jingchuan.kousuan;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestRandomQuestion {
    private static final String TAG = TestRandomQuestion.class.getSimpleName();
    private static final Logger LOG = LoggerFactory.getLogger(TAG);

    // @Test
    public void test() {
        RandomQuestion randomQuestion = new RandomQuestion(0, 20);
        for (int i = 0; i < 10; i++) {
            randomQuestion.make();

            LOG.info(randomQuestion.toString());
        }
    }

    // @Test
    public void test2() {
        RandomQuestion randomQuestion = new RandomQuestionByOperatorType(
                0,
                20,
                new OperatorType[] {
                        OperatorType.Add,
                        OperatorType.Subtract
                });
        for (int i = 0; i < 10; i++) {
            randomQuestion.make();
            // randomQuestion.checkType();

            LOG.info(randomQuestion.toString() + randomQuestion.result);
        }
    }

    // @Test
    public void test3() {
        RandomQuestion randomQuestion = new RandomQuestionByOperatorTypeAndQuestionType(
                0,
                20,
                new OperatorType[] {
                        OperatorType.Add,
                        OperatorType.Subtract,
                },
                new QuestionType[] {
                        QuestionType._1Digit,
                        QuestionType._1DigitTo2Digit,
                });
        for (int i = 0; i < 50; i++) {
            randomQuestion.make();
            // randomQuestion.checkType();

            LOG.info(randomQuestion.toString() + randomQuestion.result);
        }
    }

    @Test
    public void test4() {
        KouSuan kouSuan = new KouSuan();
        kouSuan.make();

        for (int i = 0; i < 10; i++) {
            kouSuan.make();
            // randomQuestion.checkType();

            System.out.print(kouSuan.toString() + "\r\n");
        }
    }
}
