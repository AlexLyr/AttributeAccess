package com.ursip.dsproxy;

import java.sql.Connection;
import java.util.Set;

/**
 * @author Lyrchikov Alexander

 */
public interface ConnectionIdManager {

    String getId(Connection connection);

    /**
     * Notify this manager that id of corresponding connection has addClosedId.
     *
     * @param closedId addClosedId connection id

     */
    void addClosedId(String closedId);

    /**
     * Return set of connection ids that have not yet addClosedId.
     *
     * @return set of open connection ids

     */
    Set<String> getOpenConnectionIds();

}