package com.ml.rule;

import com.ml.model.ChessPieces;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dml
 * @date 2021/11/12 16:30
 */
public class ChessPiecesRule {

    private ChessPiecesRule() {

    }

    public static Byte[] initChessPieces(List<ChessPieces> chessPiecesList) {
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
        return chessArray;
    }

    public static int[] getPiecesNext(Byte id) {
        int[] indexArray = new int[]{};
        switch (id) {
            case 1:
            case 9:
            case 17:
            case 25:
                // 车走直线
                break;
            case 2:
            case 18:
                // 马向前一步向对角线的点走
                break;
            default:
                break;
        }
        return indexArray;
    }

    private int[] getChariotNext(int index, Byte id, Byte[] piecesPositionArray) {
        List<Integer> result = new ArrayList<>();
        int y = 10;
        // 上检索
        for (int i = 0; i < y; i++) {
            int positionTopIndex = index + i * 9;
            if (positionTopIndex > 89) {
                continue;
            }
            if (piecesPositionArray[positionTopIndex] == null) {
                result.add(positionTopIndex);
            }
        }
        // 下检索
        for (int i = 0; i < y; i++) {
            int positionBottomIndex = index - i * 9;
            if (positionBottomIndex < 0) {
                continue;
            }
            if (piecesPositionArray[positionBottomIndex] == null ) {
                result.add(positionBottomIndex);
            }
        }
        int x = 9;
        // 左检索
        for (int i = 0; i < y; i++) {
            int positionTopIndex = index + i * 9;
            if (positionTopIndex > 89) {
                continue;
            }
            if (piecesPositionArray[positionTopIndex] == null) {
                result.add(positionTopIndex);
            }
        }
        // 右检索
        for (int i = 0; i < y; i++) {
            int positionBottomIndex = index - i * 9;
            if (positionBottomIndex < 0) {
                continue;
            }
            if (piecesPositionArray[positionBottomIndex] == null ) {
                result.add(positionBottomIndex);
            }
        }
    }

}
