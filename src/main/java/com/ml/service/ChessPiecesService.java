package com.ml.service;

import com.ml.model.ChessPieces;

import java.util.List;

/**
 * ChessPiecesService
 *
 * @author dml
 * @date 2021/11/8 16:58
 */
public interface ChessPiecesService {

    /**
     * get pieces list
     *
     * @return  list
     */
    List<ChessPieces> listGetPieces();

}
