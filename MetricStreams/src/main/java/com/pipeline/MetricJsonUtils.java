package com.pipeline;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

public class MetricJsonUtils {

    public static double getTotalCpuPercent(String value) {
        return JsonParser().parser(value).getJsonObject().getJsonObject().get("system").
        getJsonObject().get("cpu")
                .getAsJsonObject().get("total").getAsJsonObject().get("norm").
                getAsJsonObject().get("pct").getAsDouble();
    }

    public static String getMetricName(String value) {
        return JsonParser().parser(value).getJsonObject().get("metricset").
        getAsJsonObject().get("name")
                .getAsString();
    }

    public static String getHostTimestamp(String value) {
        JsonObject objectValue = new JsonParser().parse(value).
        getAsJsonObject();

        JsonObject result = objectValue.getAsJsonObject("host");
        result.add("timestamp", objectValue.get("@timestamp"));
        return result.toString();
    }
}