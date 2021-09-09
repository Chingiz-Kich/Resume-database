package model;

public enum SectionType {
    PERSONAL("Личные качества"),
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Личные достижения"),
    QUALIFICATIONS("Квалификации"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("ОБразование");

    private String title;
    private String[] list;

    private SectionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
