package com.ml.serviceimpl;

import com.ml.mapper.GameMapper;
import com.ml.model.Game;
import com.ml.service.GameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author dml
 * @date 2021/11/19 14:36
 */
@Service
public class GameServiceImpl implements GameService {

    @Resource
    private GameMapper gameMapper;

    @Override
    public Long startNewGame() {
        Game game = new Game();
        game.setStartTime(new Date());
        game.setType((byte) 1);
        game.setStatus((byte) 1);
        int result = gameMapper.insert(game);
        if (result > 0) {
            return game.getId();
        }
        return null;
    }

}
