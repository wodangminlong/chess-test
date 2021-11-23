package com.ml.controller;

import com.ml.common.ApiResponse;
import com.ml.exception.ExceptionAdvice;
import com.ml.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * StartNewGame
 *
 * @author dml
 * @date 2021/11/8 16:09
 */
@Slf4j
@RestController
public class StartNewGame extends ExceptionAdvice {

    @Resource
    private GameService gameService;

    /**
     * start new game
     *
     * @return  ApiResponse
     */
    @PostMapping("startNewGame")
    public ApiResponse startNewGame() {
        Long id = gameService.startNewGame();
        log.info("id: {}", id);
        if (Objects.isNull(id)) {
            return ApiResponse.error();
        }
        return ApiResponse.success();
    }

}
