package com.yin.product.dao;

import com.yin.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-26 15:28:23
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {

}
