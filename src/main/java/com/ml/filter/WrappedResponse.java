package com.ml.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 返回内容读取
 *
 * @author dml
 * @date 2021/01/19 16:34
 */
@Slf4j
public class WrappedResponse extends HttpServletResponseWrapper {

    private final ByteArrayOutputStream buffer;
    private final ServletOutputStream out;
    private final PrintWriter writer;

    public WrappedResponse(HttpServletResponse response) {
        super(response);
        // 真正存储数据的流
        buffer = new ByteArrayOutputStream();
        out = new WapperedOutputStream(buffer);
        writer = new PrintWriter(new OutputStreamWriter(buffer, StandardCharsets.UTF_8));
    }

    /** 重载父类获取outPutStream的方法 */
    @Override
    public ServletOutputStream getOutputStream() {
        return out;
    }

    /** 重载父类获取writer的方法 */
    @Override
    public PrintWriter getWriter() {
        return writer;
    }

    /** 重载父类获取flushBuffer的方法 */
    @Override
    public void flushBuffer() throws IOException {
        if (out != null) {
            out.flush();
        }
        if (writer != null) {
            writer.flush();
        }
    }

    @Override
    public void reset() {
        buffer.reset();
    }

    /** 将out、writer中的数据强制输出到WapperedResponse的buffer里面，否则取不到数据 */
    public byte[] getResponseData() throws IOException {
        flushBuffer();
        return buffer.toByteArray();
    }

    /** 内部类，对ServletOutputStream进行包装 */
    private static class WapperedOutputStream extends ServletOutputStream {
        private final ByteArrayOutputStream bos;

        public WapperedOutputStream(ByteArrayOutputStream stream) {
            bos = stream;
        }

        @Override
        public void write(int b) {
            bos.write(b);
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {
            log.info("writeListener...");
        }
    }
}
