package com.mitchellbosecke.benchmark;

import httl.Engine;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.ParseException;
import java.util.Map;

public class Httl extends BaseBenchmark {

    private Engine engine = Engine.getEngine();

    private Map<String, Object> context;

    @Setup
    public void setup() throws IOException {
        this.context = getContext();
    }

    @Benchmark
    public String benchmark() throws IOException, ParseException {
        Writer writer = new StringWriter();
        engine.getTemplate("templates/stocks.httl.html").render(context, writer);
        return writer.toString();
    }

}
