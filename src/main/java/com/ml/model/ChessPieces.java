package com.ml.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author dml
 * @date 2021/11/8 16:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "tb_chess_pieces")
public class ChessPieces {

    private Byte id;

    private Character name;
}
