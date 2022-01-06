package handler.example;

public class Main {
    public static void main(String[] args) {
        Handler read = new ReadHandler();
        Handler format = new FormatHandler();

        read.setNext(format);

        read.process("My path");
    }
}
