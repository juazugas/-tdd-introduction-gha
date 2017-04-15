package agiletdd.exercices;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

/**
 * Created by jzuriaga on 15/4/17.
 */
public class RefactorStaticTest {

    private RefactorStatic refactorStatic;

    @Before
    public void setUp() throws Exception {
        refactorStatic = new RefactorStatic();
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

}