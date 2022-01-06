package handler.example;

import java.util.List;

public class FormatHandler extends Handler {

    @Override
    public void process(Object objectList) {
        System.out.println("Called FormatHandler class");
        List<String> list = (List<String>)objectList;

        list.forEach(System.out::println);
    }
}
