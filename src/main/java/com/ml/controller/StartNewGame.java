package com.ml.controller;

import com.ml.common.ApiErrorCode;
import com.ml.common.ApiResponse;
import com.ml.exception.ExceptionAdvice;
import com.ml.model.ChessPieces;
import com.ml.rule.ChessPiecesRule;
import com.ml.service.ChessPiecesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    private ChessPiecesService chessPiecesService;

    /**
     * start new game
     *
     * @return  ApiResponse
     */
    @PostMapping("startNewGame")
    public ApiResponse startNewGame() {
        byte chessPiecesCount = 32;
        List<ChessPieces> chessPiecesList = chessPiecesService.listGetPieces();
        if (CollectionUtils.isEmpty(chessPiecesList) || chessPiecesList.size() != chessPiecesCount) {
            return ApiResponse.error(ApiErrorCode.SYSTEM_ERROR);
        }
        return ApiResponse.success(ChessPiecesRule.initChessPieces(chessPiecesList));
    }

}
