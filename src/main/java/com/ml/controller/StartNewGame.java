package com.ml.controller;

import com.ml.common.ApiErrorCode;
import com.ml.common.ApiResponse;
import com.ml.exception.ExceptionAdvice;
import com.ml.model.ChessPieces;
import com.ml.service.ChessPiecesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Byte[] chessArray = new Byte[90];
        // 红棋
        chessArray[0] = chessPiecesList.get(0).getId();
        chessArray[1] = chessPiecesList.get(1).getId();
        chessArray[2] = chessPiecesList.get(2).getId();
        chessArray[3] = chessPiecesList.get(3).getId();
        chessArray[4] = chessPiecesList.get(4).getId();
        chessArray[5] = chessPiecesList.get(5).getId();
        chessArray[6] = chessPiecesList.get(6).getId();
        chessArray[7] = chessPiecesList.get(7).getId();
        chessArray[8] = chessPiecesList.get(8).getId();
        chessArray[19] = chessPiecesList.get(9).getId();
        chessArray[25] = chessPiecesList.get(10).getId();
        chessArray[27] = chessPiecesList.get(11).getId();
        chessArray[29] = chessPiecesList.get(12).getId();
        chessArray[31] = chessPiecesList.get(13).getId();
        chessArray[33] = chessPiecesList.get(14).getId();
        chessArray[35] = chessPiecesList.get(15).getId();
        // 黑棋
        chessArray[89] = chessPiecesList.get(16).getId();
        chessArray[88] = chessPiecesList.get(17).getId();
        chessArray[87] = chessPiecesList.get(18).getId();
        chessArray[86] = chessPiecesList.get(19).getId();
        chessArray[85] = chessPiecesList.get(20).getId();
        chessArray[84] = chessPiecesList.get(21).getId();
        chessArray[83] = chessPiecesList.get(22).getId();
        chessArray[82] = chessPiecesList.get(23).getId();
        chessArray[81] = chessPiecesList.get(24).getId();
        chessArray[70] = chessPiecesList.get(25).getId();
        chessArray[64] = chessPiecesList.get(26).getId();
        chessArray[62] = chessPiecesList.get(27).getId();
        chessArray[60] = chessPiecesList.get(28).getId();
        chessArray[58] = chessPiecesList.get(29).getId();
        chessArray[56] = chessPiecesList.get(30).getId();
        chessArray[54] = chessPiecesList.get(31).getId();
        char[] chessCharArray = new char[chessPiecesCount];
        for (int i = 0; i < chessPiecesCount; i++) {
            chessCharArray[i] = chessPiecesList.get(i).getName();
        }
        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("chessList", chessArray);
        resultMap.put("chessCharArray", chessCharArray);
        return ApiResponse.success(resultMap);
    }

}
