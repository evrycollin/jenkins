package hudson.search;

import org.jvnet.hudson.test.HudsonTestCase;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

/**
 * @author Kohsuke Kawaguchi
 */
public class SearchTest extends HudsonTestCase {
    /**
     * No exact match should result in a failure status code.
     */
    public void testFailure() throws Exception {
        try {
            search("no-such-thing");
            fail("404 expected");
        } catch (FailingHttpStatusCodeException e) {
            assertEquals(404,e.getResponse().getStatusCode());
        }
    }
}
