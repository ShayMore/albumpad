package com.pad.base.generate;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author myl
 * Created by Administrator on 2017/7/17 0017.
 */
@Repository
public interface IdentifierMapper {

    public String getId(@Param("last")String last, @Param("first")String first);

}
