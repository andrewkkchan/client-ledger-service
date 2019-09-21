package com.industrieit.ledger.clientledger.web;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void testRun() {
        Application application = new Application();
        application.run();
    }

    @Test
    public void testRunWithParam() {
        try {
            Application application = new Application();
            application.run("exitcode");
        } catch (Application.ExitException e) {
            Assert.assertEquals(10, e.getExitCode());
        }
    }
}
