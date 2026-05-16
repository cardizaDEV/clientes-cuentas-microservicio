package dev.cardiza.clientescuentas.infrastructure.adapter.in.rest.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class OpenApiExamples {

    public static final String DNI = "11111111A";
    public static final String NAME = "Juan";
    public static final String FIRST_SURNAME = "Pérez";
    public static final String SECOND_SURNAME = "López";
    public static final String BIRTH_DATE = "1959-09-12";

    public static final String CUENTA_ID = "1";
    public static final String CUENTA_TYPE_PREMIUM = "PREMIUM";
    public static final String CUENTA_TYPE_NORMAL = "NORMAL";
    public static final String TOTAL_PREMIUM = "150000";
    public static final String TOTAL_NORMAL = "50000";
    public static final String UPDATED_TOTAL = "180000";

    public static final String AMOUNT = "1000";
}