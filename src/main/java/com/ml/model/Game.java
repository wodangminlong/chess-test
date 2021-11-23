package com.ml.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author dml
 * @date 2021/11/19 13:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "tb_game")
public class Game {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Date startTime;

    private Date endTime;

    private Byte type;

    private Byte status;

    private Byte result;

    private Byte resultReason;

    private Byte flagDel;

}
