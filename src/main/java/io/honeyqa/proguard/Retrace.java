package io.honeyqa.proguard;

import proguard.retrace.ReTrace;

import java.io.*;

/**
 * Created by devholic on 10/5/15.
 */

public class Retrace {

    public static String retraceCode(File mappingFile, String stackTrace) {
        LineNumberReader stackTraceReader = new LineNumberReader(new StringReader(stackTrace));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter decodedStackTraceReader = new PrintWriter(out);
        ReTrace r = new ReTrace(ReTrace.STACK_TRACE_EXPRESSION, false, mappingFile);
        try {
            r.retrace(stackTraceReader, decodedStackTraceReader);
            stackTraceReader.close();
            decodedStackTraceReader.close();
            String result = out.toString("UTF-8");
            out.close();
            return result;
        } catch (IOException e){
            return null;
        }
    }

}
