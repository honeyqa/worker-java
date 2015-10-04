package io.honeyqa.proguard;

import io.honeyqa.test.util.StringHelper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by devholic on 10/5/15.
 */
public class RetraceTest {

    @Test
    public void testRetraceResult() {
        ClassLoader classLoader = getClass().getClassLoader();
        File mapping = new File(classLoader.getResource("retrace/mapping.txt").getFile());
        try {
            assertEquals(
                    StringHelper.convertStreamToString(classLoader.getResourceAsStream("retrace/result.txt")),
                    Retrace.retraceCode(mapping,
                            StringHelper.convertStreamToString(classLoader.getResourceAsStream("retrace/stacktrace.txt"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
