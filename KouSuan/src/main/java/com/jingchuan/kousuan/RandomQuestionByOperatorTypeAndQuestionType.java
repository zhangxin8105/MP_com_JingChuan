
package com.jingchuan.kousuan;

import java.util.ArrayList;
import java.util.Arrays;

public class RandomQuestionByOperatorTypeAndQuestionType extends RandomQuestionByOperatorType {

    protected ArrayList<QuestionType> questionTypes;

    public RandomQuestionByOperatorTypeAndQuestionType(int min, int max,
            OperatorType[] operatorTypes,
            QuestionType[] types) {
        super(min, max, operatorTypes);

        this.questionTypes = new ArrayList<QuestionType>(Arrays.asList(types));
    }

    @Override
    public void make() {

        do {
            super.make();

            if (questionTypes.contains(questionType)) {
                break;
            }

        } while (true);
    }
}
