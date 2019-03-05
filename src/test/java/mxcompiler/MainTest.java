package mxcompiler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class MainTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void AnswerTree()
    {
        assertEquals(Compiler.command("test.in"), "");
    }
}
