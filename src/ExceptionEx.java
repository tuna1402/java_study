public class ExceptionEx {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0); // 0으로 나누기 예외
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        } finally {
            System.out.println("프로그램 종료");
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}