package com.ProjectName.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:rerunResults/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        glue = "com/ProjectName/step_definitions",
        features = "src/test/resources/features",
        tags = "@wip",
        publish = false,
        dryRun = false




)
//check selenium Grid Hub for available instances to run
//to run Selenium/Cucumber - Binaries (Browsers should be installed) and annotations are used to run the test
public class CukeRunner {
}
