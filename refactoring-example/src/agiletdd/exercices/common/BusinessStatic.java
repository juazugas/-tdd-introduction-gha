package agiletdd.exercices.common;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BusinessStatic {

    private final static ConcurrentMap<String, Integer> internalMap = new ConcurrentHashMap<>();

    private final static int ALGORITHM_TYPE = 1;

    private final static int MAXIMUM_CONNECTIONS = 10;

    private static String connectionUri = "myjdbcConnection";

    private final static Random random = new Random();

    private BusinessStatic() { }

    public static String getConnectionUri() {

        int connectionPool = random.nextInt(MAXIMUM_CONNECTIONS);
        String connectionPoolUri = connectionUri + connectionPool;
        int reuseNum = useConnection(connectionPoolUri);
        System.out.println(connectionPoolUri + " reused " + reuseNum);

        return connectionPoolUri;
    }

    private static int useConnection(String connectionPoolUriKey) {
        int reuseNum = 0;
        if (internalMap.containsKey(connectionPoolUriKey)) {
            reuseNum = internalMap.computeIfPresent(connectionPoolUriKey, (key, previousValue) -> Integer.sum(previousValue, 1));
        } else {
            internalMap.put(connectionPoolUriKey, 0);
        }
        return reuseNum;
    }

    public static List<String> findAllEntities(String connectionUri, int page, int size) {
        System.out.println("using : " + connectionUri + " total " + size + " of page " + page);
        return IntStream.range(1, 100)
                .skip(page*size)
                .limit(size)
                .mapToObj(String::valueOf).map(s -> "entity".concat(s)).collect(Collectors.toList());
    }
}