package model.enums;

public class SectionManager {
    public static SectionKind getSectionKind(String param) {
        try {
            SectionKind kind = SectionKind.valueOf(param.toUpperCase());
            return kind;
        } catch (IllegalArgumentException e) {
            return SectionKind.ALL;
        }
    }
}
