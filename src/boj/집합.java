package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 집합 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < commandCount; i++) {
            String commandLine = br.readLine();

            if (commandLine.startsWith("add")) {
                int number = Integer.parseInt(commandLine.split(" ")[1]);
                if (!list.contains(number)) list.add(number);

            } else if (commandLine.startsWith("remove")) {
                int number = Integer.parseInt(commandLine.split(" ")[1]);
                if (list.contains(number)) list.remove(list.indexOf(number));

            } else if (commandLine.startsWith("check")) {
                int number = Integer.parseInt(commandLine.split(" ")[1]);

                if (list.contains(number)) sb.append(1);
                else sb.append(0);

                sb.append("\n");

            } else if (commandLine.startsWith("toggle")) {
                int number = Integer.parseInt(commandLine.split(" ")[1]);

                if (list.contains(number)) list.remove(list.indexOf(number));
                else list.add(number);

            } else if (commandLine.equals("all")) {
                list.clear();

                for (int j = 1; j <= 20; j++) {
                    list.add(j);
                }

            } else if (commandLine.equals("empty")) {
                list.clear();

            } else break;
        }

        System.out.println(sb);
    }
}
