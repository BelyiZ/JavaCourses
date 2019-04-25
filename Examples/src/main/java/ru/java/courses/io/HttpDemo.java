package ru.java.courses.io;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpDemo {

    public static class ResponseData {

        public String url, body;
        public int status;
        Map<String, List<String>> headers;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder()
                    .append("URL= ").append(url).append('\n')
                    .append("STATUS= ").append(status).append('\n')
                    .append("BODY=\n").append(body).append('\n')
                    .append("HEADERS=\n");

            headers.entrySet().stream()
                    .filter(entry -> entry.getKey() != null)
                    .forEach(entry -> {
                        builder.append(entry.getKey()).append(": ");
                        List<String> headerValues = entry.getValue();
                        for (String headerValue : headerValues) {
                            builder.append(headerValue).append(", ");
                        }
                        builder.append("\n");
                    });

            return builder.toString();
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(HttpDemo.class);

    public static void main(String[] args) {
        ResponseData responseData = doRequest("https://www.reksoft.ru", null, null);
        LOG.info(responseData.toString());
    }

    private static ResponseData doRequest(String url, Map<String, String> parameters, Map<String, String> headers) {
        HttpURLConnection connection = null;
        try {
            URL requestUrl = new URL(url);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");

            if (parameters != null) {
                connection.setDoOutput(true);
                try (DataOutputStream out = new DataOutputStream(connection.getOutputStream())) {
                    out.writeBytes(getParamsString(parameters));
                    out.flush();
                }
            }

            if (headers != null) {
                for (Entry<String, String> header : parameters.entrySet()) {
                    connection.setRequestProperty(header.getKey(), header.getValue());
                }
            }

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            ResponseData response = new ResponseData();
            response.status = status;
            response.headers = connection.getHeaderFields();

            try (
                    InputStreamReader streamReader = status >= 300 ?
                            new InputStreamReader(connection.getErrorStream()) :
                            new InputStreamReader(connection.getInputStream());
                    BufferedReader responseReader = new BufferedReader(streamReader);
            ) {
                String inputLine;
                StringBuilder body = new StringBuilder();
                while ((inputLine = responseReader.readLine()) != null) {
                    body.append(inputLine);
                }
                response.body = body.toString();
            }
            return response;
        } catch (Exception e) {
            LOG.error("Error while HTTP request. URL: " + url, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }

    private static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.isEmpty() ? resultString : resultString.substring(0, resultString.length() - 1);
    }

}
