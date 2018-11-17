package com.ursip.dsproxy;

import java.sql.Connection;

/**
 * @author Lyrchikov Alexander

 */
public class ConnectionInfo {

    private String dataSourceName;
    private String connectionId;
    private boolean isClosed;
    private int commitCount;
    private int rollbackCount;

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    /**
     * Increment commit count.
     *

     */
    public void incrementCommitCount() {
        this.commitCount++;
    }

    /**
     * Increment rollback count.
     *

     */
    public void incrementRollbackCount() {
        this.rollbackCount++;
    }

    /**
     * Returns how many times {@link Connection#commit()} method is called.
     *
     * @return num of commit method being called

     */
    public int getCommitCount() {
        return commitCount;
    }

    /**
     * @param commitCount num of commit method call

     */
    public void setCommitCount(int commitCount) {
        this.commitCount = commitCount;
    }

    /**
     * Returns how many times {@link Connection#rollback()} method is called.
     *
     * @return num of rollback method being called

     */
    public int getRollbackCount() {
        return rollbackCount;
    }

    /**
     * @param rollbackCount num of rollback method call

     */
    public void setRollbackCount(int rollbackCount) {
        this.rollbackCount = rollbackCount;
    }

    /**

     */
    public boolean isClosed() {
        return isClosed;
    }

    /**

     */
    public void setClosed(boolean closed) {
        isClosed = closed;
    }

}
