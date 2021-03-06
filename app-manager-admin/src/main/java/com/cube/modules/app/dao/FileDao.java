package com.cube.modules.app.dao;

import com.cube.modules.app.entity.FileEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * APP文件管理
 * 
 * @author tututu
 * @email 289911401@qq.com
 * @date 2019-12-05 10:57:12
 */
@Mapper
public interface FileDao extends BaseMapper<FileEntity> {
	
}
