package model.enums;

import constants.SQLConstants;

public enum SelectionKindConf {
    ALL(SQLConstants.SELECT_CONF),
    TODAY(SQLConstants.SELECT_CONF + SQLConstants.WHERE_TODAY),
    TOMORROW(SQLConstants.SELECT_CONF + SQLConstants.WHERE_TOMORROW),
    SOON(SQLConstants.SELECT_CONF + SQLConstants.WHERE_SOON),
    FINISHED(SQLConstants.SELECT_CONF + SQLConstants.WHERE_FINISHED);

    private String sql;
    private SelectionKindConf(String sql){this.sql = sql;}

    public String getSql(){return sql;}
}
