package agiletdd.exercices;


import agiletdd.exercices.common.BusinessStatic;

import java.util.ArrayList;
import java.util.List;

public class RefactorStatic {

    public List<String> getAllEntities(int page, int size) {

        String connection = BusinessStatic.getConnectionUri();
        System.out.println("current connection : " + connection);

        return BusinessStatic.findAllEntities(connection, page, size);
    }

    public static void main(String[] args) {
        RefactorStatic refStatic = new RefactorStatic();
        for (int i = 0; i < 3; i++) {
            refStatic.getAllEntities(i, 10).stream().forEach(System.out::println);
        }
    }

}

