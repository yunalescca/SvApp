package com.example.yunalescca.swedishpronunciations.enums;

/**
 * Created by Lina on 2016-09-30.
 */

public enum LetterID {
    A_LETTER,
    B_LETTER,
    C_LETTER,
    D_LETTER,
    E_LETTER,
    F_LETTER,
    G_LETTER,
    H_LETTER,
    I_LETTER,
    J_LETTER,
    K_LETTER,
    L_LETTER,
    M_LETTER,
    N_LETTER,
    O_LETTER,
    P_LETTER,
    Q_LETTER,
    R_LETTER,
    S_LETTER,
    T_LETTER,
    U_LETTER,
    V_LETTER,
    W_LETTER,
    X_LETTER,
    Y_LETTER,
    Z_LETTER,
    Å_LETTER,
    Ä_LETTER,
    Ö_LETTER;

    public static LetterID[] getVowels() {
        LetterID[] vowels = {
                A_LETTER,
                E_LETTER,
                I_LETTER,
                O_LETTER,
                U_LETTER,
                Y_LETTER,
                Å_LETTER,
                Ä_LETTER,
                Ö_LETTER
        };
        return vowels;
    }
}
