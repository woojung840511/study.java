package javaJeongSuk.ch12_genericsEnumerationAnnotion;

public class EnumTest {

    public enum Gender {

        MALE(0, "남자"),
        FEMALE(1, "여자");

        private static final Gender[] GENDER_ARR = Gender.values();
        private final int value;
        private final String str;

        Gender(int value, String str) {
            this.value = value;
            this.str = str;
        }

        public static Gender of(int value) {
            if (!(value == 0 || value == 1)) {
                throw new IllegalArgumentException("0이나 1을 넣어주세요");
            }

            for (Gender gender : GENDER_ARR) {
                if (gender.getValue() == value) {
                    return gender;
                }
            }
            return null;
        }

        public static Gender of(String str) {
            for (Gender gender : GENDER_ARR) {
                if (gender.getStr().equals(str)) {
                    return gender;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }

        public String getStr() {
            return str;
        }
    }

    public static void main(String[] args) {

        System.out.println("Gender.MALE.getValue() = " + Gender.MALE.getValue());
        System.out.println(Gender.of("남자"));
        System.out.println(Gender.of(1));
    }

}
