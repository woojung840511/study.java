package ch14_LamdaAndStream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {
        String[] lineArr = {
          "Belive or not It is true",
          "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);

//        Stream<Stream<String>> strStream1 = lineStream.map(line -> Stream.of(line.split(" +")));
        Stream<String> strStream2 = lineStream.flatMap(line -> Stream.of(line.split(" +")));


    }

}
