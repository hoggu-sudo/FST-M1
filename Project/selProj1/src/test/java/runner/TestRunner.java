package runner;

import org.junit.platform.suite.api.*;

import io.cucumber.junit.platform.engine.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("Features")

@ConfigurationParameter(
    key = Constants.GLUE_PROPERTY_NAME,
    value = "stepDefinitions"
)

@ConfigurationParameter(
    key = Constants.PLUGIN_PROPERTY_NAME,
    value = "pretty, html:Reports/report.html"
)

@ConfigurationParameter(
		  key = Constants.FILTER_TAGS_PROPERTY_NAME,
		  value = "@menu"		//Run all: value = ""
		)

public class TestRunner {
}


/*

@title
@image
@footer
@login
@color
@menu
@leads
@accounts
@leadstable

*/