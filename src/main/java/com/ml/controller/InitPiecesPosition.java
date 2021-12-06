package com.ml.controller;

import com.ml.aspect.Log;
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
 * init pieces position
 *
 * @author dml
 * @date 2021/11/19 10:18
 */
@Slf4j
@RestController
public class InitPiecesPosition extends ExceptionAdvice {

    @Resource
    private ChessPiecesService chessPiecesService;

    @Log("初始化棋盘")
    @PostMapping("initPiecesPosition")
    public ApiResponse initPiecesPosition() {
        byte chessPiecesCount = 32;
        List<ChessPieces> chessPiecesList = chessPiecesService.listGetPieces();
        if (CollectionUtils.isEmpty(chessPiecesList) || chessPiecesList.size() != chessPiecesCount) {
            return ApiResponse.error(ApiErrorCode.SYSTEM_ERROR);
        }
        return ApiResponse.success(ChessPiecesRule.initChessPieces(chessPiecesList));
    }

}
