class Leap {

    boolean isLeapYear(int year) {
        boolean evenDivisibleBy4 = year % 4 == 0;
        boolean notEvenDivisibleBy100 = year % 100 != 0;
        boolean evenDivisibleBy400 = year % 400 == 0;

        return evenDivisibleBy4 && (notEvenDivisibleBy100 || evenDivisibleBy400);
    }

}
