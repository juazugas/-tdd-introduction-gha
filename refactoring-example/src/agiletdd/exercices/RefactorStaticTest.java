package agiletdd.exercices;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by jzuriaga on 15/4/17.
 */
public class RefactorStaticTest {

    @Test
    public void should_get_all_entities_of_page_0_with_size_3() throws Exception {
        List<String> entities = null;
        RefactorStatic refactorStatic = null;
        _given:
            refactorStatic = new RefactorStatic();

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
        RefactorStatic refactorStatic = null;
        _given:
            refactorStatic = new RefactorStatic();

        _when:
            entities = refactorStatic.getAllEntities(1, 2);

        _then:
            assertNotNull(entities);
            assertThat(entities, hasSize(2));
            assertThat(entities, hasItems(equalTo("entity3"), equalTo("entity4")));
    }

}