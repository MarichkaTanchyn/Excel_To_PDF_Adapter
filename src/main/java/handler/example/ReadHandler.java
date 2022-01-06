package handler.example;

import java.util.ArrayList;
import java.util.List;

public class ReadHandler extends Handler {

    @Override
    public void process(Object objectPath) {
        System.out.println("Called ReadHandler class");
        String path = (String)objectPath;

        System.out.println("Reading file " + path);

        List<String> newData = new ArrayList<>();
        newData.add("1 2 3 4");
        newData.add("Hey I am Max");

        next(newData);
    }
}
