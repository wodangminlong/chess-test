package com.ml.filter;

import com.ml.util.ZipUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author dml
 * @date 2021/11/30 17:28
 */
@Slf4j
@Component
public class ResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        WrappedResponse wrapResponse = new WrappedResponse((HttpServletResponse) servletResponse);
        filterChain.doFilter(request, wrapResponse);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        byte[] resData = wrapResponse.getResponseData();
        String resultDataString = new String(resData, StandardCharsets.UTF_8);
        log.info("resultDataString: {}", resultDataString);
        resultDataString = ZipUtils.zipStr(resultDataString);
        log.info("resultDataString1: {}", resultDataString);
        writeResponse(response, resultDataString);
    }

    private void writeResponse(ServletResponse response, String responseString) throws IOException {
        response.setContentLength(-1);
        PrintWriter out = response.getWriter();
        out.write(responseString);
        out.flush();
        out.close();
    }

}
