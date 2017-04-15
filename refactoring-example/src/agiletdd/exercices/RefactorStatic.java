package agiletdd.exercices;


import agiletdd.exercices.common.BusinessStaticDefaultFactory;
import agiletdd.exercices.common.BusinessStaticFactory;

import java.util.List;

public class RefactorStatic {

    private final BusinessStaticFactory bizzFactory;

    public RefactorStatic(BusinessStaticFactory factory) {
        this.bizzFactory = factory;
    }

    public List<String> getAllEntities(int page, int size) {

        String connection = bizzFactory.getBusinessStatic().getConnectionUri();
        System.out.println("current connection : " + connection);

        return bizzFactory.getBusinessStatic().findAllEntities(connection, page, size);
    }

    public static void main(String[] args) {
        RefactorStatic refStatic = new RefactorStatic(new BusinessStaticDefaultFactory());
        for (int i = 0; i < 3; i++) {
            refStatic.getAllEntities(i, 10).stream().forEach(System.out::println);
        }
    }

}

