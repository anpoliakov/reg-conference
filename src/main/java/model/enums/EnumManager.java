package model.enums;

public class EnumManager {
    public static SelectionKindConf getKindConf(String param) {
        try {
            SelectionKindConf kind = SelectionKindConf.valueOf(param.toUpperCase());
            return kind;
        } catch (IllegalArgumentException e) {
            return SelectionKindConf.ALL;
        }
    }
}
