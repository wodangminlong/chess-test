package com.ml.controller;

import com.ml.common.ApiResponse;
import com.ml.exception.ExceptionAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * StartNewGame
 *
 * @author dml
 * @date 2021/11/8 16:09
 */
@Slf4j
@RestController
public class StartNewGame extends ExceptionAdvice {

    /**
     * start new game
     *
     * @return  ApiResponse
     */
    @PostMapping("startNewGame")
    public ApiResponse startNewGame() {
        return ApiResponse.success();
    }

}
