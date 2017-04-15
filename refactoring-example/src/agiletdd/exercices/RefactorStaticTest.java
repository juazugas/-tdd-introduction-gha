package agiletdd.exercices;

import agiletdd.exercices.common.BusinessStaticDelegate;
import agiletdd.exercices.common.BusinessStaticFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by jzuriaga on 15/4/17.
 */
public class RefactorStaticTest {

    private RefactorStatic refactorStatic = null;

    private BusinessStaticFactory businessStaticFactory;

    private BusinessStaticDelegate businessStatic;

    @Before
    public void setUp () throws Exception {
        businessStaticFactory = spy(BusinessStaticFactory.class);
        createBusinessStaticMock();
        doReturn(businessStatic).when(businessStaticFactory).getBusinessStatic();
        refactorStatic = new RefactorStatic(businessStaticFactory);
    }

    @Test
    public void should_get_all_entities_of_page_0_with_size_3() throws Exception {
        List<String> entities = null;
        _given:

        _when:
            entities = refactorStatic.getAllEntities(0, 3);

        _then: {
            assertNotNull(entities);
            assertThat(entities, hasSize(3));
            assertThat(entities, hasItems(equalTo("entity1"), equalTo("entity2"), equalTo("entity3")));
        }
    }

    @Test
    public void should_get_all_entities_of_page_1_with_size_2() throws Exception {
        List<String> entities = null;
        _given:

        _when:
            entities = refactorStatic.getAllEntities(1, 2);

        _then:
            assertNotNull(entities);
            assertThat(entities, hasSize(2));
            assertThat(entities, hasItems(equalTo("entity3"), equalTo("entity4")));
    }

    private void createBusinessStaticMock() {
        businessStatic = mock(BusinessStaticDelegate.class);
        doReturn("dummy:connection").when(businessStatic).getConnectionUri();
        doAnswer(invocation -> {
            System.out.println("connection : " + invocation.getArguments()[0]);
            int page = invocation.getArgumentAt(1, int.class);
            int size = invocation.getArgumentAt(2, int.class);

            return IntStream.range(1,100).skip(page*size).limit(size).mapToObj(String::valueOf).map("entity"::concat).collect(toList());
        }).when(businessStatic).findAllEntities(anyString(), anyInt(), anyInt());
    }

}