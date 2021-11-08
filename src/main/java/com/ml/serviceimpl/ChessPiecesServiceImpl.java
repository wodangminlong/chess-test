package com.ml.serviceimpl;

import com.ml.mapper.ChessPiecesMapper;
import com.ml.model.ChessPieces;
import com.ml.service.ChessPiecesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dml
 * @date 2021/11/8 18:34
 */
@Service
public class ChessPiecesServiceImpl implements ChessPiecesService {

    @Resource
    private ChessPiecesMapper chessPiecesMapper;

    @Override
    public List<ChessPieces> listGetPieces() {
        return chessPiecesMapper.selectList(null);
    }

}
