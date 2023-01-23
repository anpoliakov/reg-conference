package model.enums;

import constants.SQLConstants;

public enum SectionKind {
    ALL(SQLConstants.WHERE_ALL),
    TODAY(SQLConstants.WHERE_TODAY),
    TOMORROW(SQLConstants.WHERE_TOMORROW),
    SOON(SQLConstants.WHERE_SOON),
    PAST(SQLConstants.WHERE_PAST),
    CONF_BY_USER(SQLConstants.WHERE_CONF_BY_USER);

    private String sql;
    private SectionKind(String sql){this.sql = sql;}

    public String getSql(){return SQLConstants.SELECT_CONF + this.sql;}
}
