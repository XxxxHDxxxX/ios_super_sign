package com.wlznsb.iossupersign.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wlznsb.iossupersign.entity.MdmSoftwareDistributeDownRecordEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【mdm_software_distribute_down_record】的数据库操作Mapper
* @createDate 2022-04-23 18:34:42
* @Entity com.wlznsb.iossupersign.entity.MdmSoftwareDistributeDownRecordEntity
*/
public interface MdmSoftwareDistributeDownRecordMapper extends BaseMapper<MdmSoftwareDistributeDownRecordEntity> {

    List<MdmSoftwareDistributeDownRecordEntity> selectByAppId(@Param("appId") String appId);

}




