
package com.jingchuan.kousuan;

enum QuestionType {
    _1Digit, /*             */// 1位数间 的计算
    _1DigitTo2Digit, /*     */// 1位数 进位到 2位数 的计算
    _1DigitAnd2Digit, /*    */// 1位数 与 2位数 的计算（有进位）
    _2Digit, /*             */// 2位数间的计算（加、减、除）
    _2DigitTo3Digit, /*     */// 2位数 进位到 3位数 的计算
}
