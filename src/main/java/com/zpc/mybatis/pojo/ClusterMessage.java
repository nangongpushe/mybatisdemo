package com.zpc.mybatis.pojo;

public class ClusterMessage {

    private Integer clusterId;
    private String clusterName;
    private Long clusterTime;
    private String clusterAddress;
    private String clusterAccessUser;
    private String clusterAccessPasswd;

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Long getClusterTime() {
        return clusterTime;
    }

    public void setClusterTime(Long clusterTime) {
        this.clusterTime = clusterTime;
    }

    public String getClusterAddress() {
        return clusterAddress;
    }

    public void setClusterAddress(String clusterAddress) {
        this.clusterAddress = clusterAddress;
    }

    public String getClusterAccessUser() {
        return clusterAccessUser;
    }

    public void setClusterAccessUser(String clusterAccessUser) {
        this.clusterAccessUser = clusterAccessUser;
    }

    public String getClusterAccessPasswd() {
        return clusterAccessPasswd;
    }

    public void setClusterAccessPasswd(String clusterAccessPasswd) {
        this.clusterAccessPasswd = clusterAccessPasswd;
    }

    @Override
    public String toString() {
        return "ClusterMessage{" +
                "clusterId=" + clusterId +
                ", clusterName='" + clusterName + '\'' +
                ", clusterTime=" + clusterTime +
                ", clusterAddress='" + clusterAddress + '\'' +
                ", clusterAccessUser='" + clusterAccessUser + '\'' +
                ", clusterAccessPasswd='" + clusterAccessPasswd + '\'' +
                '}';
    }
}
