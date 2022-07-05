package task1;

public class Main {
    public static void main(String[] args) {
        ValidationProtocol protocol = new ValidationProtocol();
        boolean result = protocol.check(Input.getInput());
        System.out.println("IP adress is valid : " + result);
    }
}
