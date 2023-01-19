package model.enums;

import constants.SQLConstants;

public enum SelectionKindConf {
    ALL(SQLConstants.WHERE_ALL),
    TODAY(SQLConstants.WHERE_TODAY),
    TOMORROW(SQLConstants.WHERE_TOMORROW),
    SOON(SQLConstants.WHERE_SOON),
    FINISHED(SQLConstants.WHERE_FINISHED);

    private String sql;
    private SelectionKindConf(String sql){this.sql = sql;}

    public String getSql(){return SQLConstants.SELECT_CONF + this.sql;}
}
