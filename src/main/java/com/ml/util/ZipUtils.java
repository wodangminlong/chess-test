package com.ml.util;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author dml
 * @date 2021/11/30 17:22
 */
@Slf4j
public class ZipUtils {

    private ZipUtils() {

    }

    public static String zipStr(String str) {
        Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION);
        deflater.setInput(str.getBytes());
        deflater.finish();
        final byte[] bytes = new byte[256];
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256)) {
            while (!deflater.finished()) {
                int length = deflater.deflate(bytes);
                outputStream.write(bytes, 0, length);
            }
            deflater.end();
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());
        } catch (IOException e) {
            log.error("zipStr has error: ", e);
        }
        return "";
    }

    public static String unzipStr(String str) {
        byte[] decodeBytes = Base64.getMimeDecoder().decode(str);
        Inflater inflater = new Inflater();
        inflater.setInput(decodeBytes);
        final byte[] bytes = new byte[256];
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream(256)) {
            while (!inflater.finished()) {
                int length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
            return outputStream.toString();
        }catch (DataFormatException | IOException e) {
            log.error("unzipStr has error: ", e);
            return "";
        } finally {
            inflater.end();
        }
    }

}
