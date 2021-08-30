
package com.jingchuan.kousuan;

public class RandomQuestionByOperatorType extends RandomQuestion {
    public RandomQuestionByOperatorType(int min, int max, OperatorType[] types) {
        super(min, max);

        this.operatorTypes = types;
    }
}
