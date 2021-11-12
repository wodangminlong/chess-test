package com.ml.controller;

import com.ml.common.ApiResponse;
import com.ml.exception.ExceptionAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * get pieces next
 *
 * @author dml
 * @date 2021/11/12 16:42
 */
@Slf4j
@RestController
public class GetPiecesNext extends ExceptionAdvice {

    @PostMapping("getPiecesNext")
    public ApiResponse getPiecesNext() {
        return ApiResponse.success();
    }

}
