package com.zpc.mybatis.dao;

import com.zpc.mybatis.pojo.ClusterMessage;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

@MapperScan
public interface ClusterMessageMapper {

    @Insert("insert into cluster_manager(cluster_name, cluster_time, cluster_address, cluster_access_user, cluster_access_passwd) " +
            "values(#{clusterName}, #{clusterTime}, #{clusterAddress}, #{clusterAccessUser}, #{clusterAccessPasswd})")
    @Options(useGeneratedKeys = true, keyColumn = "cluster_id", keyProperty = "clusterId")
    public void insertClusterMessage(ClusterMessage clusterMessage);

//    @Select("select * from cluster_manager")
//    @Results(
//            cluster_id = "clusterMessage",
//            value = {
//                    @Result(column = "cluster_name", property = "clusterName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//                    @Result(column = "cluster_time", property = "clusterTime", javaType = Long.class, jdbcType = JdbcType.BIGINT),
//                    @Result(column = "cluster_address", property = "clusterAddress", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//                    @Result(column = "cluster_access_user", property = "clusterAccessUser", javaType = String.class, jdbcType = JdbcType.VARCHAR),
//                    @Result(column = "cluster_access_passwd", property = "clusterAccessPasswd", javaType = String.class, jdbcType = JdbcType.VARCHAR)
//            }
//    )
//    public List<ClusterMessage> getClusterMessage();

    @Select("select * from cluster_manager")
    @MapKey("clusterId")
    public Map<Integer, ClusterMessage> getClusterMessageMapper();

    @Select("select * from cluster_manager where cluster_id=#{clusterId}")
    @ResultMap("clusterMessage")
    public ClusterMessage getClusterMessageById(@Param("clusterId") int clusterId);


    @Update("update cluster_manager set cluster_name=#{clusterName} where cluster_id=#{clusterId}")
    public void updateClusterMessage(ClusterMessage clusterMessage);


    @Delete("delete from cluster_manager where cluster_id=#{clusterId}")
    public void deleteClusterMessage(@Param("clusterId")int clusterId);
}
