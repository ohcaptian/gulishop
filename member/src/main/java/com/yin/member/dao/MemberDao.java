package com.yin.member.dao;

import com.yin.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author yyf
 * @email 1769498362@qq.com
 * @date 2021-05-27 15:08:49
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
