package mxcompiler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static java.lang.System.exit;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import mxcompiler.main.Compiler;

/**
 * Created by mercy on 17-3-26.
 */
@RunWith(Parameterized.class)
public class SemanticTest {
    private boolean shouldPass;
    private String[] args;
    private static final String path = "/home/xun/Documents/mxc/src/test/cases/";

    public SemanticTest(String[] args, boolean shouldPass) {
        this.args = args;
        this.shouldPass = shouldPass;
    }

    @Test
    public void test() throws Error {
        System.out.println("# " + shouldPass);
        System.out.flush();
        try {
            Compiler mxc = new Compiler(this.args[0]);
            mxc.execute(this.args);
            if (!shouldPass) {
                fail("this case should fail, but you succeed.");
            }
        } catch (Error e) {
            if (shouldPass) {
                fail("this case should succeed, but you got: " + e.getMessage());
            }
        }
    }

    /** BUG: can not use pass check and failed check at the same time,
     * comment the pass while checking fail
     */
    /** all transfered into construct functino of this test class */
    @Parameterized.Parameters
    public static Collection<Object[]> testcase() {
        Collection<Object[]> files = new ArrayList<>();
        String[] args = new String[2]; // can not has null-string
        args[0] = "--test";

        for (File f : new File(path + "semantic/pass/").listFiles()) {
            if (f.isFile() && f.getName().endsWith(".mx")) {
                args[1] = path + "semantic/pass/" + f.getName();
                files.add(new Object[] { args, true });
            }
        }

        for (File f : new File(path + "semantic/error/").listFiles()) {
            if (f.isFile() && f.getName().endsWith(".mx")) {
                args[1] = path + "semantic/error/" + f.getName();
                files.add(new Object[] { args, false });
            }
        }

        return files;
    }
}