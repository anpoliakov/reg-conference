package model.enums;

public class EnumManager {
    public static SectionKind getKindConf(String param) {
        try {
            SectionKind kind = SectionKind.valueOf(param.toUpperCase());
            return kind;
        } catch (IllegalArgumentException e) {
            return SectionKind.ALL;
        }
    }
}
